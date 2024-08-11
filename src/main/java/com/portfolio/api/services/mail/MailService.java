package com.portfolio.api.services.mail;

import com.portfolio.api.data.v1.dto.mail.MailDTO;
import com.portfolio.api.exceptions.EmailSendingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Service
public class MailService {
    private final Logger logger = Logger.getLogger(MailService.class.getName());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail-config.username}")
    private String recipient;

    @Value("${mail-config.subject}")
    private String subject;

    public MailDTO sendMail(MailDTO mailDTO) {
        logger.info("Sending a email");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("<" + recipient + ">");
            helper.setFrom("no-reply@sendermail.dev");
            helper.setSubject(subject);

            String template = getMailTemplate();
            template = template.replace("${senderName}", mailDTO.getSenderName());
            template = template.replace("${senderMail}", mailDTO.getSenderMail());
            template = template.replace("${message}", mailDTO.getMessage());

            helper.setText(
                    "New Message:\n" +
                            "\nName: " + mailDTO.getSenderName() +
                            "\nE-mail: " + mailDTO.getSenderMail() +
                            "\n\nMessage:\n" + mailDTO.getMessage()
                    , template);

            mailSender.send(message);
        }
        catch (Exception e) {
            throw new EmailSendingException("Error when trying to send email. ", e);
        }

        return mailDTO;
    }

    public String getMailTemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/mail-template.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
