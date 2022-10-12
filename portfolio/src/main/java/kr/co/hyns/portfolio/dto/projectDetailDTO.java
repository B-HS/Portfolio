package kr.co.hyns.portfolio.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class projectDetailDTO {
    private Long pid;
    private String title;
    private LocalDate duration;
    private String stack;
    private String context;
}
