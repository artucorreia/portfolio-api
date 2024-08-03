package com.portfolio.api.controllers.mail;

import com.portfolio.api.data.v1.dto.mail.MailDTO;
import com.portfolio.api.services.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mails")
public class MailController {

    @Autowired
    private MailService service;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MailDTO> sendMail(@RequestBody MailDTO mailDTO) {
        return ResponseEntity.ok(service.sendMail(mailDTO));
    }
}