package kr.co.hyns.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.hyns.portfolio.entity.projectDetail;

@Repository
public interface ProjectDetailRepository extends JpaRepository<projectDetail, Long>, QuerydslPredicateExecutor<projectDetail>{
    
}
