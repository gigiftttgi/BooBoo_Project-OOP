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
    public String buyantiA(@RequestBody Position p){
        shop.buyAntiA(p.getPosx(), p.getPosy());
        return "Sent Request Successfully, posx,y " +p.getPosx() +", " + p.getPosy() +"  ,"  +shop.getMoney();

    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyB")
    public String buyantiB(@RequestBody Position p){
        shop.buyAntiB(p.getPosx(), p.getPosy());
        return "Sent Request Successfully, posx,y " +p.getPosx() +", " + p.getPosy() +"  ,"  +shop.getMoney();
    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyC")
    public String buyantiC(@RequestBody Position p){
        shop.buyAntiC(p.getPosx(), p.getPosy());
        return "Sent Request Successfully, posx,y "  +p.getPosx() +", " + p.getPosy() +"  ,"  +shop.getMoney();
    }
}
