package kr.co.hyns.portfolio.service;

import kr.co.hyns.portfolio.dto.projectDetailDTO;
import kr.co.hyns.portfolio.entity.projectDetail;


public interface ProjectDetailService {
    projectDetailDTO getList(Long pid);
    boolean writeArticle(projectDetailDTO dto);

    default projectDetailDTO toDTO(projectDetail entity){
        return projectDetailDTO.builder()
                                .pid(entity.getPid())
                                .title(entity.getTitle())
                                .duration(entity.getDuration())
                                .stack(entity.getStack())
                                .context(entity.byteToString(entity.getContext()))
                                .build();
    }

    default projectDetail toEntity(projectDetailDTO dto){
        return projectDetail.builder()
                                .pid(dto.getPid())
                                .title(dto.getTitle())
                                .duration(dto.getDuration())
                                .stack(dto.getStack())
                                .context(dto.getContext().getBytes())
                                .build();
    }
}
