package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.EmailRequest;
import csci467.calfco.productsystem.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/email")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    EmailServiceImpl emailService;

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @GetMapping(path = "/send")
    public @ResponseBody String sendEmail(@RequestBody EmailRequest request){

        emailService.sendSimpleMessage(request.getEmail(), request.getSubject(), request.getContent());

        return "Message sent to " + request.getEmail();
    }
}
