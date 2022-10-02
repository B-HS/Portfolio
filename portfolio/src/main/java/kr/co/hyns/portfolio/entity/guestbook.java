package kr.co.hyns.portfolio.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class guestbook extends DateEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;
    
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String context;


}
