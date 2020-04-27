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


    // Request Body
    /*
    {
	"vendor": "VE001-99", (done in backend)
	"trans": "907-987654321-296", ** NEEDS TO BE IN THIS FORMAT, AND UNIQUE (done in backend)
	"cc": "6011 1234 4321 1234", *** THIS HAS TO BE THIS EXACT CC NUMBER
	"name": "John Doe",
	"exp": "12/2020",
	"amount": 654.32
	}
     */
    // Response Body
    /*
    {
    "authorization": "16167",           ** null is failed
    "vendor": "VE001-99",
    "trans": "907-987654322-296",
    "cc": "6011 1234 4321 1234",
    "name": "John Doe",
    "exp": "12/2020",
    "brand": "discover",
    "timeStamp": "1587751245003",       ** null is failed
    "_id": "5ea3294d41d82e11ff6b16ad",  ** null is failed
    "errors": []                        **** Will have an "error": "abc" if failed
    }
     */

    @PostMapping("/auth")
    public @ResponseBody CreditCardAuthResponse authorizeTransaction(@RequestBody CreditCardAuthRequest request){

        // TODO Create transaction id, use common vendo id
        return creditCardAuthService.sendRequest(request);
    }

}
