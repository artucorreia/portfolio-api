package com.portfolio.api.controllers.mail;

import com.portfolio.api.data.v1.dto.mail.MailDTO;
import com.portfolio.api.services.mail.MailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mails")
@Tag(name = "Mails", description = "Endpoint for send mails")
public class MailController {

    @Autowired
    private MailService service;

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200", "https://portfolio-artucorreia.web.app"})
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Send a mail",
            description = "Send a mail",
            tags = {"Mails"},
            method = "GET"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = MailDTO.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
            }
    )

    public ResponseEntity<MailDTO> sendMail(@RequestBody MailDTO mailDTO) {
        return ResponseEntity.ok(service.sendMail(mailDTO));
    }
}