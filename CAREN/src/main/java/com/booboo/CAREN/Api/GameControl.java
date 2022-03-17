package com.booboo.CAREN.Api;


import com.booboo.CAREN.Model.Gameplay;
import com.booboo.CAREN.Model.Position;
import com.booboo.CAREN.Model.Shop;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class GameControl {

     Gameplay game = new Gameplay();
     private boolean s = false;

     Shop shop = Shop.getInsShop();


    @CrossOrigin
    @PostMapping
    @RequestMapping("/start")
    public String gameState(@RequestBody String state) throws InterruptedException {
         shop.reBalance();
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
    @PostMapping
    @RequestMapping("/speedup")
    public String speedUpState(@RequestBody String state) throws InterruptedException {
        System.out.println("call speedup");

        game.setSpeedUpState(true);
//            game.resumeGame(false);

        return "Speed Up is click";

    }

    @CrossOrigin
    @PostMapping
    @RequestMapping("/speeddown")
    public String speedDowmState(@RequestBody String state) throws InterruptedException {
        System.out.println("call speeddown");

        game.setSpeedDownState(true);
//            game.resumeGame(false);

        return "Speed Down is click";

    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("/gameover")
    public String isOver(){
        System.out.println("eP" + game.getEndState() + " iWP" + game.getIsWin());
        if(game.getEndState()){
            System.out.println("ifEnd" );
            if(game.getIsWin()){
                System.out.println("ifWin" );
                return "You win";
            }
            return "You lose";
        }
        return "Playing";

    }

}
