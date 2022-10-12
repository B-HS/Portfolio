package kr.co.hyns.portfolio.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.hyns.portfolio.dto.projectDetailDTO;
import kr.co.hyns.portfolio.entity.QprojectDetail;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDetailServiceImpl implements ProjectDetailService{
    private final JPAQueryFactory factory;
    @PersistenceContext
    EntityManager em;

    @Override
    public projectDetailDTO getList(Long pid) {
        QprojectDetail project = QprojectDetail.projectDetail;
        return toDTO(factory.selectFrom(project).where(project.pid.eq(pid)).fetchOne());
    }

    @Override
    public boolean writeArticle(projectDetailDTO dto) {
        
        return false;
    }
}
