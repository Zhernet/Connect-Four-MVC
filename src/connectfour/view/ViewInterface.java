package connectfour.view;

import connectfour.model.Cell;

public interface ViewInterface {
     public void displayBoard(Cell[][] board); 
     public void displayCurrentPlayerTurn(Cell player);
     public void tie();   
     public void playerWins(Cell player); 
}
