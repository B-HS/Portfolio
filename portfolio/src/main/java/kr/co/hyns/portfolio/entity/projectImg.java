package kr.co.hyns.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class projectImg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgid;

    
    private String filename;

    @ManyToOne
    private projectDetail pDetail;
}
