package com.booboo.CAREN.Api;


import com.booboo.CAREN.Model.Gameplay;
import com.booboo.CAREN.Model.Position;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class GameControl {

     Gameplay game = new Gameplay();
     private boolean s = false;


    @CrossOrigin
    @PutMapping("/start/{state}")
    public String gameState(@PathVariable String state) throws InterruptedException {
        game.startGame();
        return "run start game";
    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/pause")
    public String pauseState(@RequestBody String state) throws InterruptedException {
        System.out.println("call pause");

        game.setPauseState(true);

        return "Pause is click";

    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/resume")
    public String resumeState(@RequestBody String state) throws InterruptedException {
        System.out.println("call resume");

        game.resumeGame(true);
//            game.resumeGame(false);

        return "Resume is click";

    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("/gameover")
    public String isOver(){
        if(game.endState){
            if(game.iswin){
                return "You win";
            }
            return "You lose";
        }
        return "Playing";
//        return "You win";
//        return "You lose";
    }

}
