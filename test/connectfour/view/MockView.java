package connectfour.view;

import connectfour.model.Cell;

public class MockView implements ViewInterface {

    @Override
    public void displayBoard(Cell[][] board) {
    }

    @Override
    public void tie() {            
    }

    @Override
    public void playerWins(Cell player) {
    }
    
    @Override
    public void displayCurrentPlayerTurn(Cell player) {
    }
}
