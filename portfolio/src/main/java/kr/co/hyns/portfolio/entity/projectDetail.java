package kr.co.hyns.portfolio.entity;

import java.nio.charset.Charset;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.querydsl.core.annotations.PropertyType;
import com.querydsl.core.annotations.QueryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class projectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column
    private String title;

    @Column
    private LocalDate duration;

    @Column
    private String stack;

    @Lob
    @Column
    @QueryType(PropertyType.STRING)
    private byte[] context;

    public String byteToString(byte[] context){
        return new String(context, Charset.forName("utf8"));
    }
}
