package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Shop;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/shop")
public class ShopController {
    Shop shop = Shop.getInsShop();

    @CrossOrigin
    @GetMapping("/")
    public Shop getShop(){
        return shop;
    }

    @CrossOrigin
    @GetMapping("/money")
    public int getMoney(){
        return shop.getMoney();
    }


//    @CrossOrigin
//    @PostMapping("/buy")
//    public String buyAnti(){
//        return "buy";
//    }
}
