package connectfour.model;

import connectfour.view.ViewInterface;

public class Board {
    
    public static final int WIDTH = 7;
    public static final int HEIGHT = 6;
    private Cell[][] cells = new Cell[WIDTH][HEIGHT];  

        
    public Board(){
        reset();
    }
    
    public void reset() {
        for (int col = 0; col < WIDTH; col ++)   
            for (int row = 0; row < HEIGHT; row++)
                cells[col][row] = Cell.EMPTY;
    }
    
    public Cell[][] getBoard() {
        return cells;
    }
    
    public void addDisc(Cell disc, int column) {
        checkForIllegalOperations(disc, column);
        
        for (int row = HEIGHT -1; row >= 0; row--)
            if (cells[column][row] == Cell.EMPTY) {
                cells[column][row] = disc;                
                return;
            }
    }     
    
    private void checkForIllegalOperations(Cell disc, int column) {
        if (disc == Cell.EMPTY)
            throw new NullCellException();
        if (disc == null)
            throw new NullCellException(); 
        if (column < 0)
            throw new InvalidColumnException();
        if (column >= WIDTH)
            throw new InvalidColumnException();        
        if (columnIsFull(column))
            throw new ColumnFullException();
    }
        
    public Boolean boardIsFull() {
        for (int col = 0; col < WIDTH; col ++)   
            if (!columnIsFull(col))
                return false;
        return true;
    } 
    
    private Boolean columnIsFull(int col) {
        for (int row = 0; row < HEIGHT; row++)
            if (cells[col][row] == Cell.EMPTY)
                return false;
        return true;
    }      
   
    public boolean playerHasWon(Cell player) {   
        if (horizontalConnectFour(player))
            return true;
        if (verticalConnectFour(player))
            return true;
        if (diagonalLowerRightConnectFour(player))
            return true;
        if (diagonalLowerLeftConnectFour(player))
            return true;
        
        return false;
    }
    
    private boolean horizontalConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 0; row < HEIGHT; row++)
                if (cells[col][row] == disc &&
                cells[col + 1][row] == disc &&
                cells[col + 2][row] == disc &&
                cells[col + 3][row] == disc)
                    return true;
        
        return false;        
    }
     
    private boolean verticalConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH; col++)
            for (int row = 0; row < HEIGHT - 3; row++)
                if (cells[col][row] == disc &&
                cells[col][row + 1] == disc &&
                cells[col][row + 2] == disc &&
                cells[col][row + 3] == disc)
                    return true;
        
        return false;        
    }  
        
    private boolean diagonalLowerRightConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 0; row < HEIGHT - 3; row++)            
                if (cells[col][row] == disc &&
                cells[col + 1][row + 1] == disc &&
                cells[col + 2][row + 2] == disc &&
                cells[col + 3][row + 3] == disc)
                    return true;
        
        return false;        
    }   
    
    private boolean diagonalLowerLeftConnectFour(Cell disc) {
        for (int col = 0; col < WIDTH - 3; col++)
            for (int row = 3; row < HEIGHT; row++)            
                if (cells[col][row] == disc &&
                    cells[col + 1][row - 1] == disc &&
                    cells[col + 2][row - 2] == disc &&
                    cells[col + 3][row - 3] == disc)
                        return true;
        
        return false;        
    }   
    
}
