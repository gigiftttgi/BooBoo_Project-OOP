package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Field;
import com.booboo.CAREN.Model.Gamecharacter;
import com.booboo.CAREN.Model.Shop;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/field")
public class FieldController {
    Field field = Field.getInstance();
    Shop shop = Shop.getInsShop();

    @CrossOrigin
    @GetMapping("/character")
    public List<Gamecharacter> getChar(){
        return field.getAllChar();
    }

    @CrossOrigin
    @PostMapping("/move")
    public String moveAnti(@RequestBody PositionApi pos){
        int cost = field.movetoPosition(pos.getP(), pos.getQ());
        shop.moveCost(cost);
        return "Successfully sent movePos" + pos.getP() + " " + pos.getQ();
    }

}
