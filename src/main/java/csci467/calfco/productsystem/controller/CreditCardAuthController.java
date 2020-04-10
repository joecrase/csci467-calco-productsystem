package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import csci467.calfco.productsystem.service.CreditCardAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/creditcard")
public class CreditCardAuthController {

    CreditCardAuthService creditCardAuthService;

    public CreditCardAuthController(CreditCardAuthService creditCardAuthService) {
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
