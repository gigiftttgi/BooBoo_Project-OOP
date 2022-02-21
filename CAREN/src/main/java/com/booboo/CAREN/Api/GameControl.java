package com.booboo.CAREN.Api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booboo")
public class GameControl {


    @PostMapping()
    @RequestMapping("/shop")  //localhost:8080/booboo/shop
    public String buyAntiA(@RequestBody ShopRequest request){
        return "buy"+request;
    }

}
