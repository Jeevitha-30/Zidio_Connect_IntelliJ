package service;

import dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(EmailRequest request){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(request.to);
        message.setSubject(request.subject);
        message.setText(request.message);
        message.setFrom("jeevithasivan30@gmail.com");
        mailSender.send(message);
        return "Email sent Successfully";
    }
}
