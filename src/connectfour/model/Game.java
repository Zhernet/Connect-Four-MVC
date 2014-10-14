package connectfour.model;

import connectfour.view.ViewInterface;

public class Game implements GameInterface {
    
    private Board boardModel;
    private Cell lastPlayedPlayer;
    private Cell currentPlayer;
    
    private ViewInterface view;
        
    public Game(ViewInterface view){
        this.view = view;
        boardModel = new Board();
    }
    
    @Override
    public void initialize(){
        lastPlayedPlayer = Cell.EMPTY;
        currentPlayer = Cell.PLAYER1;
        boardModel.reset();        
        
        view.displayBoard( boardModel.getBoard() );
        view.displayCurrentPlayerTurn(currentPlayer);
    }
    
    public void addDisc(int col) {
        try {
            if (currentPlayer == lastPlayedPlayer)
                throw new SamePlayerTwiceException();            
            boardModel.addDisc(currentPlayer, col);   
            view.displayBoard( boardModel.getBoard() );
            doEndOfTurn();
           
        } catch (NullCellException e) {
            System.out.println("Invalid player!");          
        
        } catch (InvalidColumnException e) {
            System.out.println("Invalid column! Choose another column.");
        
        } catch (ColumnFullException e) {
            System.out.println("Column full! Choose another column.");       
        }
    }     
    
    private void doEndOfTurn() {;    
        if ( boardModel.playerHasWon(currentPlayer) )
            endGameWithAWinner(currentPlayer);
        else if ( boardModel.boardIsFull() ) 
            endGameTie();
        else              
            changePlayer(); 
    }
    
    private void endGameWithAWinner(Cell winner) {
        view.playerWins(winner);
        initialize();
    }
    
    private void endGameTie() {
        view.tie();
        initialize();
    }
    
    private void changePlayer() {
        lastPlayedPlayer = currentPlayer;
        
        if (currentPlayer == Cell.PLAYER1)
            currentPlayer = Cell.PLAYER2;
        else
            currentPlayer = Cell.PLAYER1;
        
        view.displayCurrentPlayerTurn(currentPlayer);
    };          
    
}
