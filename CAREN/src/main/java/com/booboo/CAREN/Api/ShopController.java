package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Shop;
import org.springframework.web.bind.annotation.*;


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


    @CrossOrigin
    @PostMapping()
    @RequestMapping("/buy")
    public String buyAnti(@RequestBody String antibody){
        if(antibody == "antiA"){
            shop.buyAntiA();
        }else if(antibody == "antiB"){
            shop.buyAntiB();
        }else if(antibody == "antiC"){
            shop.buyAntiC();
        }

        return "Sent Request Successfully";

    }
}
