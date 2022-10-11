package com.example.vn_social_network.controller.action;

import com.example.vn_social_network.model.action.Mail;
import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.service.action.mail.MailService;
import com.example.vn_social_network.service.app_users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
// http://localhost:8080/mail/forgotpass
    @PostMapping("/forgotpass")
    public ResponseEntity<Mail> fogotPass(@RequestBody Optional<AppUsers> appUser){
        AppUsers appUsers=userService.findByMail(appUser.get().getEmail());
        Mail mail = new Mail();
        mail.setMailFrom("nguyenhuuquyet07092001@gmail.com");
        mail.setMailTo(appUsers.getEmail());
        mail.setMailSubject("Forgot password");
        mail.setMailContent("Kính chào "+appUsers.getUserName()+"\nPassword của bạn là: "+appUsers.getPassword()+"\nĐồ ngu có cái pass cũng không nhớ nổi");

        mailService.sendEmail(mail);
        return new ResponseEntity<>(mail, HttpStatus.OK);
    }
}
