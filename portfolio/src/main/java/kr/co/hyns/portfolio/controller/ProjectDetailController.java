package kr.co.hyns.portfolio.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import kr.co.hyns.portfolio.dto.projectDetailDTO;
import kr.co.hyns.portfolio.service.ProjectDetailService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectDetailController {
    @Value("${kr.co.hyns.portfolio.password}")
    private String passwd;
    private final ProjectDetailService pdser;

    @RequestMapping(value = "/writecheck", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> writeCheck(@RequestBody String wpass){
        return passchecking(wpass);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<projectDetailDTO>> projectLists(@RequestBody int page){
        Pageable pageable = PageRequest.of(page, 18);
        return new ResponseEntity<>(pdser.getList(pageable), HttpStatus.OK);
    }


    @RequestMapping(value = "/img/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> projectImg(@PathVariable("fileName") String fileName){
        try {
            File imgFile = new File("/Users/hyunseokbyun/Documents/Imagefiles/" + File.separator + fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", Files.probeContentType(imgFile.toPath()));
            return new ResponseEntity<>(FileCopyUtils.copyToByteArray(imgFile), headers,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> writeArticle(projectDetailDTO dto){
        Long result = pdser.writeArticle(dto);
        if (result>0){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(-1L, HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Boolean> passchecking(String wpass){
        if (passwd.equals(wpass.substring(0, wpass.length()-1))) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else{
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }
}
