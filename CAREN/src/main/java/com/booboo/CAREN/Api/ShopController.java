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
        int y = p.getP()%25;
        if(y==0){
            y=25;
        }
        int x = ((p.getP()- y) / 25) + 1;

        shop.buyAntiA(x, y);
        return "Sent Request Successfully, posx,y " +x +", " + y +"  ,"  +shop.getMoney();

    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyB")
    public String buyantiB(@RequestBody Position p){
        int y = p.getP()%25;
        if(y==0){
            y=25;
        }
        int x = ((p.getP()- y) / 25) + 1;

        shop.buyAntiA(x, y);
        return "Sent Request Successfully, posx,y " +x +", " + y +"  ,"  +shop.getMoney();
    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/buyC")
    public String buyantiC(@RequestBody Position p){
        int y = (p.getP())%25;
        if(y==0){
            y=25;
        }
        int x = ((p.getP()- y) / 25) + 1;

        shop.buyAntiA(x, y);
        return "Sent Request Successfully, posx,y " +x +", " + y +"  ,"  +shop.getMoney();
    }
}
