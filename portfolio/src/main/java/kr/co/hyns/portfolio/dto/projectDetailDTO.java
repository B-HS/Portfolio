package kr.co.hyns.portfolio.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class projectDetailDTO {
    private Long pid;
    private String title;
    private String duration;
    private String stack;
    private String context;
}
