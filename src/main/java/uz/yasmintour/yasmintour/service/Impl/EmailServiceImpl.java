package uz.yasmintour.yasmintour.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uz.yasmintour.yasmintour.dto.MessageDto;
import uz.yasmintour.yasmintour.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    public boolean sendSimpleMail(MessageDto details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo("rembraini@gmail.com");
            mailMessage.setText(String.format("Name : %s\nPhone number - %s\nEmail - %s\nMessage - %s",details.getFirstName(),details.getNumber(),details.getMail(),details.getMessage()));
            mailMessage.setSubject(String.format("Yasmin Tour"));
            javaMailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

