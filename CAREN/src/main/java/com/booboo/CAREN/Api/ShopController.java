package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Shop;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/shop")
public class ShopController {
    Shop shop = Shop.getInsShop();

    String type;

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
    @RequestMapping("/type")
    public String getType(@RequestBody String type){
        char temp = type.charAt(0);
//        System.out.println(temp);
        this.type = Character.toString(temp);
        return "this antibody type = " + type;
    }


    @CrossOrigin
    @PostMapping()
    @RequestMapping("/buy")
    public String buyanti(@RequestBody PositionApi p){
        int pos = p.getP();
        shop.buyAnti(type, pos);
        System.out.println(type);
        type = null;
        System.out.println("Reset type" + type);
        return "Sent Request A Successfully"  +shop.getMoney();

    }

//    @CrossOrigin
//    @PostMapping
//    @RequestMapping("/buyB")
//    public String buyantiB(@RequestBody PositionApi p){
//        int y = p.getP()%25;
//        if(y==0){
//            y=25;
//        }
//        int x = ((p.getP()- y) / 25) + 1;
//
//        shop.buyAntiB(x, y);
//        return "Sent Request B Successfully, posx,y " +x +", " + y +"  ,"  +shop.getMoney();
//    }
//
//    @CrossOrigin
//    @PostMapping
//    @RequestMapping("/buyC")
//    public String buyantiC(@RequestBody PositionApi p){
//        int y = (p.getP())%25;
//        if(y==0){
//            y=25;
//        }
//        int x = ((p.getP()- y) / 25) + 1;
//
//        shop.buyAntiC(x, y);
//        return "Sent Request C Successfully, posx,y " +x +", " + y +"  ,"  +shop.getMoney();
//    }
}
