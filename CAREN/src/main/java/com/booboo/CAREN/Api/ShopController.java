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
    @RequestMapping("/buyA")
    public String buyantiA(@RequestBody String antibody){
        shop.buyAntiA();
        return "Sent Request Successfully, " + antibody +shop.getMoney();

    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyB")
    public String buyantiB(@RequestBody String anti){
        shop.buyAntiB();
        return "Sent Request Successfully, " + anti + shop.getMoney();
    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyC")
    public String buyantiC(@RequestBody String anti){
        shop.buyAntiC();
        return "Sent Request Successfully, " + anti +shop.getMoney();
    }
}
