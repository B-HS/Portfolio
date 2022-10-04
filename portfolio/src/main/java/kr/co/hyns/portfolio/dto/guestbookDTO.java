package kr.co.hyns.portfolio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class guestbookDTO {
    private Long gid;
    private String username;
    private String password;
    private String context;
    private Boolean open;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
