package connectfour.main;

import connectfour.controller.Controller;
import connectfour.view.View;
import connectfour.view.ViewInterface;
import connectfour.model.GameInterface;
import connectfour.model.Game;

public class ConnectFourSwing {
    public static void main(String[] args) {
        Controller controller = new Controller();
        ViewInterface view = new View(controller);
        GameInterface game = new Game(view);
        controller.setup(game);
        
        game.initialize();
    }
}
