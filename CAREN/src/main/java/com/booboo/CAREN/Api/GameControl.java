package com.booboo.CAREN.Api;

import com.booboo.CAREN.Model.Gameplay;
import com.booboo.CAREN.Model.Position;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class GameControl {

     Gameplay game = new Gameplay();

    @CrossOrigin
    @PutMapping("/start/{state}")
    public String gameState(@PathVariable String state) throws InterruptedException {
        game.startGame();
        return "run start game";
    }

}
