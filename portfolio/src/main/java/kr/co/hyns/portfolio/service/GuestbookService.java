package kr.co.hyns.portfolio.service;



import java.util.HashMap;

import kr.co.hyns.portfolio.dto.guestbookDTO;
import kr.co.hyns.portfolio.entity.guestbook;

public interface GuestbookService {

    guestbookDTO writeGuestbook(guestbookDTO dto);
    HashMap<String, Object> getGuestbookList(Integer pageNum);
    Boolean modifyGuestbook(guestbookDTO dto);
    Boolean removeGuestbook(guestbookDTO dto);
    
    default guestbookDTO entityToDTO(guestbook entity){
        guestbookDTO dto = guestbookDTO.builder()
        .gid(entity.getGid())
        .username(entity.getUsername())
        .context(entity.getContext())
        .open(entity.getOpen())
        .regdate(entity.getRegdate())
        .moddate(entity.getModdate())
        .build();
        return dto;
    }

    default guestbook DTOtoEntity(guestbookDTO dto){
        guestbook entity = guestbook.builder()
        .gid(dto.getGid())
        .username(dto.getUsername())
        .context(dto.getContext())
        .password(dto.getPassword())
        .open(dto.getOpen())
        .build();
        return entity;
    }
}
