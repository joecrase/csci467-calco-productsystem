package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import csci467.calfco.productsystem.service.CreditCardAuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/creditcard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditCardAuthController {

    CreditCardAuthServiceImpl creditCardAuthService;

    public CreditCardAuthController(CreditCardAuthServiceImpl creditCardAuthService) {
        this.creditCardAuthService = creditCardAuthService;
    }

    @RequestMapping({"", "/", "index"})
    public @ResponseBody String test(){
        return "You have hit the creditcard controller";
    }

    @PostMapping("/auth")
    public @ResponseBody CreditCardAuthResponse authorizeTransaction(@RequestBody CreditCardAuthRequest request){

        return creditCardAuthService.sendRequest(request);
    }

}
