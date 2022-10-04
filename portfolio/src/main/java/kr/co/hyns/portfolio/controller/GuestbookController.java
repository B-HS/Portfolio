package kr.co.hyns.portfolio.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.hyns.portfolio.dto.guestbookDTO;
import kr.co.hyns.portfolio.service.GuestbookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService gser;

    @RequestMapping(value = "/list", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, Object>> sendList(@RequestBody Integer pageNum){
        return new ResponseEntity<>(gser.getGuestbookList(pageNum), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<guestbookDTO> addGuestbook(@RequestBody guestbookDTO dto){
        return new ResponseEntity<>(gser.writeGuestbook(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> modifyGuestbook(@RequestBody guestbookDTO dto){
        return new ResponseEntity<>(gser.modifyGuestbook(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> removeGuestbook(@RequestBody guestbookDTO dto){
        return new ResponseEntity<>(gser.removeGuestbook(dto), HttpStatus.OK);
    }
}
