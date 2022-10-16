package kr.co.hyns.portfolio.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.co.hyns.portfolio.dto.projectDetailDTO;
import kr.co.hyns.portfolio.entity.projectDetail;


public interface ProjectDetailService {
    Page<projectDetailDTO> getList(Pageable pageable);
    Long writeArticle(projectDetailDTO dto);

    default projectDetailDTO toDTO(projectDetail entity){
        return projectDetailDTO.builder()
                                .pid(entity.getPid())
                                .title(entity.getTitle())
                                .duration(entity.getDuration())
                                .stack(entity.getStack())
                                .context(entity.byteToString(entity.getContext()))
                                .pImage(entity.getPImg().get(0).getFilename())
                                .build();
    }

    default projectDetail toEntity(projectDetailDTO dto){
        projectDetail entity = projectDetail.builder()
                    .pid(dto.getPid())
                    .title(dto.getTitle())
                    .duration(dto.getDuration())
                    .stack(dto.getStack())
                    .context(dto.getContext().getBytes())
                    .build();
        return entity;
    }
}
