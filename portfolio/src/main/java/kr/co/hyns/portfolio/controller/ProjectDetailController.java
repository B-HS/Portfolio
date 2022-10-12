package kr.co.hyns.portfolio.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hyns.portfolio.dto.projectDetailDTO;

@RestController
@RequestMapping("projects")
public class ProjectDetailController {
    @Value("${kr.co.hyns.portfolio.password}")
    private String passwd;

    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<projectDetailDTO>> projectList(Long pid){
        return null;
    }

    @RequestMapping(value = "/img/{fileName}", method = RequestMethod.POST)
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
}
