package kr.co.hyns.portfolio.service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.hyns.portfolio.dto.projectDetailDTO;
import kr.co.hyns.portfolio.entity.QprojectDetail;
import kr.co.hyns.portfolio.entity.projectDetail;
import kr.co.hyns.portfolio.entity.projectImg;
import kr.co.hyns.portfolio.repository.ProjectDetailRepository;
import kr.co.hyns.portfolio.repository.ProjectImgRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDetailServiceImpl implements ProjectDetailService {
    private final ProjectDetailRepository pdrepo;
    private final ProjectImgRepository pdirepo;
    private final JPAQueryFactory factory;

    @Override
    public Page<projectDetailDTO> getList(Pageable pageable) {
        QprojectDetail qprojectDetail = QprojectDetail.projectDetail;
        List<projectDetail> result = factory.selectFrom(qprojectDetail).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        JPAQuery<Long> countQuery = factory.select(qprojectDetail.count()).from(qprojectDetail);
        List<projectDetailDTO>dtoList = result.stream().map(ele->{
            projectDetailDTO tmp = toDTO(ele);
            Optional.ofNullable(ele.getPImg().get(0)).ifPresentOrElse(v->{tmp.setPImage(v.getFilename());}, ()->{tmp.setPImage("basic.png");});
            return tmp;
        }).toList();

        Page<projectDetailDTO> dtos = PageableExecutionUtils.getPage(dtoList, pageable, countQuery::fetchOne);
        
        return dtos;
    }

    @Override
    public Long writeArticle(projectDetailDTO dto) {
        projectDetail result = pdrepo.save(toEntity(dto));
        String uploadDir = "/Users/hyunseokbyun/Documents/Imagefiles/";
        Optional<MultipartFile> file = Optional.ofNullable(dto.getImg());
        file.ifPresent(img -> {
            try {
                String[] fileNameAry = img.getOriginalFilename().split("[.]");
                String fileName = UUID.randomUUID()+"."+fileNameAry[fileNameAry.length-1];
                img.transferTo(new File(uploadDir + fileName));
                pdirepo.save(projectImg.builder().filename(fileName).pDetail(result).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return result.getPid();
    }
}
