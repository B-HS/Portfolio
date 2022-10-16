package kr.co.hyns.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.hyns.portfolio.entity.projectImg;

@Repository
public interface ProjectImgRepository extends JpaRepository<projectImg, Long>{    
}
