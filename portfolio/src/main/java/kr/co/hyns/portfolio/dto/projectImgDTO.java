package kr.co.hyns.portfolio.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class projectImgDTO {
    private Long imgid;
    private String filename;
    private Long pDetail;
}
