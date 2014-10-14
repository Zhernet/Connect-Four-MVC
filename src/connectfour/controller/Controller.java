package connectfour.controller;
import connectfour.model.GameInterface;

public class Controller {
    private GameInterface model;
    
    public Controller(){
    }
    
    public void setup(GameInterface game) {
        this.model = game;
    }
    
    public void discEntered(int column) {
        model.addDisc(column);
    }           
    
}
