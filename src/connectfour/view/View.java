package connectfour.view;

import connectfour.controller.Controller;
import connectfour.model.Board;
import connectfour.model.Cell;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class View extends javax.swing.JFrame implements ViewInterface {
    
    private Controller controller;
    private JButton[][] visualBoard = new JButton[Board.WIDTH][Board.HEIGHT];
    private JButton[] discInputs = new JButton[Board.WIDTH];
    
    private static javax.swing.ImageIcon player1InputIcon = new ImageIcon("resources/red_arrow.png");
    private static javax.swing.ImageIcon player2InputIcon = new ImageIcon("resources/yellow_arrow.png");
    
    private static javax.swing.ImageIcon emptyCellIcon = new ImageIcon("resources/empty_cell.png");
    private static javax.swing.ImageIcon player1CellIcon = new ImageIcon("resources/red_cell.png");
    private static javax.swing.ImageIcon player2CellIcon = new ImageIcon("resources/yellow_cell.png");
    
    private final String PLAYER1_COLOR = "Red";
    private final String PLAYER2_COLOR = "Yellow";
    
    public View(Controller controller) {
        this.controller = controller;
        initComponents();
        initializeBoard(); 
        initializeDiscInputs();
        setVisible(true);
    }
    
    private void initializeBoard() {
        visualBoard[0][0] = jButtonA1;
        visualBoard[0][1] = jButtonB1;
        visualBoard[0][2] = jButtonC1;
        visualBoard[0][3] = jButtonD1;
        visualBoard[0][4] = jButtonE1;
        visualBoard[0][5] = jButtonF1;
        
        visualBoard[1][0] = jButtonA2;
        visualBoard[1][1] = jButtonB2;
        visualBoard[1][2] = jButtonC2;
        visualBoard[1][3] = jButtonD2;
        visualBoard[1][4] = jButtonE2;
        visualBoard[1][5] = jButtonF2;
        
        visualBoard[2][0] = jButtonA3;
        visualBoard[2][1] = jButtonB3;
        visualBoard[2][2] = jButtonC3;
        visualBoard[2][3] = jButtonD3;
        visualBoard[2][4] = jButtonE3;
        visualBoard[2][5] = jButtonF3;
        
        visualBoard[3][0] = jButtonA4;
        visualBoard[3][1] = jButtonB4;
        visualBoard[3][2] = jButtonC4;
        visualBoard[3][3] = jButtonD4;
        visualBoard[3][4] = jButtonE4;
        visualBoard[3][5] = jButtonF4;
        
        visualBoard[4][0] = jButtonA5;
        visualBoard[4][1] = jButtonB5;
        visualBoard[4][2] = jButtonC5;
        visualBoard[4][3] = jButtonD5;
        visualBoard[4][4] = jButtonE5;
        visualBoard[4][5] = jButtonF5;
        
        visualBoard[5][0] = jButtonA6;
        visualBoard[5][1] = jButtonB6;
        visualBoard[5][2] = jButtonC6;
        visualBoard[5][3] = jButtonD6;
        visualBoard[5][4] = jButtonE6;
        visualBoard[5][5] = jButtonF6;        
            
        visualBoard[6][0] = jButtonA7;
        visualBoard[6][1] = jButtonB7;
        visualBoard[6][2] = jButtonC7;
        visualBoard[6][3] = jButtonD7;
        visualBoard[6][4] = jButtonE7;
        visualBoard[6][5] = jButtonF7;        
    }
    
    private void initializeDiscInputs() {
        discInputs[0] = jButtonInput1;
        discInputs[1] = jButtonInput2;
        discInputs[2] = jButtonInput3;
        discInputs[3] = jButtonInput4;
        discInputs[4] = jButtonInput5;
        discInputs[5] = jButtonInput6;
	discInputs[6] = jButtonInput7;
        
        for (JButton button : discInputs)
            button.addActionListener( new EntryPointListener() ); 
    }    
    
    class EntryPointListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for (int col = 0; col < discInputs.length; col++)
                if (discInputs[col] == (JButton)e.getSource() )
                    controller.discEntered(col);
        }   
    }    
    
    @Override
    public void displayBoard(Cell[][] board){
        for (int col = 0; col < board.length; col++)
            for (int row = 0; row < board[col].length; row++) 
                setCellButtonIcon(visualBoard[col][row], board[col][row]);
    }
        
    private void setCellButtonIcon(JButton button, Cell cell) {
        button.setIcon( getCellInputIcon(cell) );
    }
    
    private javax.swing.ImageIcon getCellInputIcon(Cell cell) {
        if (cell == null)
            return emptyCellIcon;
        switch ( cell ) {
            case PLAYER1 :
                return player1CellIcon;                
            case PLAYER2 :
                return player2CellIcon;                
            default :
                return emptyCellIcon;                
        }
    } 
    
   @Override
   public void displayCurrentPlayerTurn(Cell player) {
       for (JButton button : discInputs)
           button.setIcon( getInputIcon(player) );
    };   
   
   private javax.swing.ImageIcon getInputIcon(Cell player) {
        if (player == null)
            return null;
        switch ( player ) {
            case PLAYER1 :
                return player1InputIcon;                
            case PLAYER2 :
                return player2InputIcon;                
            default :
                return null;                
        }
    }       
    
    @Override
    public void tie() {
        displayMessage( "Draw.");
    };
    
    @Override
    public void playerWins(Cell player) {
         displayMessage( String.format("%s wins!", getPlayerColor(player)) );
    }; 
    
    private void displayMessage(String message){
        JOptionPane.showMessageDialog(this,
                message,
                "Connect Four",
                JOptionPane.PLAIN_MESSAGE);
    }
        
    private String getPlayerColor(Cell player){
        switch (player) {
            case PLAYER1:
                return PLAYER1_COLOR;
            case PLAYER2:
                return PLAYER2_COLOR;
            default:
                return "ERROR";
        }                
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBoard = new javax.swing.JPanel();
        jButtonA1 = new javax.swing.JButton();
        jButtonA2 = new javax.swing.JButton();
        jButtonA5 = new javax.swing.JButton();
        jButtonA3 = new javax.swing.JButton();
        jButtonA4 = new javax.swing.JButton();
        jButtonA6 = new javax.swing.JButton();
        jButtonA7 = new javax.swing.JButton();
        jButtonB1 = new javax.swing.JButton();
        jButtonB2 = new javax.swing.JButton();
        jButtonB4 = new javax.swing.JButton();
        jButtonB5 = new javax.swing.JButton();
        jButtonB6 = new javax.swing.JButton();
        jButtonB7 = new javax.swing.JButton();
        jButtonC7 = new javax.swing.JButton();
        jButtonC6 = new javax.swing.JButton();
        jButtonC5 = new javax.swing.JButton();
        jButtonC4 = new javax.swing.JButton();
        jButtonC3 = new javax.swing.JButton();
        jButtonC2 = new javax.swing.JButton();
        jButtonC1 = new javax.swing.JButton();
        jButtonD7 = new javax.swing.JButton();
        jButtonD6 = new javax.swing.JButton();
        jButtonD5 = new javax.swing.JButton();
        jButtonD4 = new javax.swing.JButton();
        jButtonD3 = new javax.swing.JButton();
        jButtonD2 = new javax.swing.JButton();
        jButtonD1 = new javax.swing.JButton();
        jButtonE7 = new javax.swing.JButton();
        jButtonE6 = new javax.swing.JButton();
        jButtonE5 = new javax.swing.JButton();
        jButtonE4 = new javax.swing.JButton();
        jButtonE3 = new javax.swing.JButton();
        jButtonE2 = new javax.swing.JButton();
        jButtonE1 = new javax.swing.JButton();
        jButtonF7 = new javax.swing.JButton();
        jButtonF6 = new javax.swing.JButton();
        jButtonF5 = new javax.swing.JButton();
        jButtonF4 = new javax.swing.JButton();
        jButtonF3 = new javax.swing.JButton();
        jButtonF2 = new javax.swing.JButton();
        jButtonF1 = new javax.swing.JButton();
        jButtonB3 = new javax.swing.JButton();
        jPanelInput = new javax.swing.JPanel();
        jButtonInput7 = new javax.swing.JButton();
        jButtonInput6 = new javax.swing.JButton();
        jButtonInput5 = new javax.swing.JButton();
        jButtonInput4 = new javax.swing.JButton();
        jButtonInput3 = new javax.swing.JButton();
        jButtonInput2 = new javax.swing.JButton();
        jButtonInput1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connect Four");
        setResizable(false);

        jPanelBoard.setBackground(new java.awt.Color(0, 51, 204));
        jPanelBoard.setPreferredSize(new java.awt.Dimension(780, 501));

        jButtonA1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA1.setBorderPainted(false);
        jButtonA1.setRolloverEnabled(false);

        jButtonA2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA2.setBorderPainted(false);
        jButtonA2.setRolloverEnabled(false);

        jButtonA5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA5.setBorderPainted(false);
        jButtonA5.setRolloverEnabled(false);

        jButtonA3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA3.setBorderPainted(false);
        jButtonA3.setRolloverEnabled(false);

        jButtonA4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA4.setBorderPainted(false);
        jButtonA4.setRolloverEnabled(false);

        jButtonA6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA6.setBorderPainted(false);
        jButtonA6.setRolloverEnabled(false);

        jButtonA7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonA7.setBorderPainted(false);
        jButtonA7.setRolloverEnabled(false);

        jButtonB1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB1.setBorderPainted(false);
        jButtonB1.setRolloverEnabled(false);

        jButtonB2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB2.setBorderPainted(false);
        jButtonB2.setRolloverEnabled(false);

        jButtonB4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB4.setBorderPainted(false);
        jButtonB4.setRolloverEnabled(false);

        jButtonB5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB5.setBorderPainted(false);
        jButtonB5.setRolloverEnabled(false);

        jButtonB6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB6.setBorderPainted(false);
        jButtonB6.setRolloverEnabled(false);

        jButtonB7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB7.setBorderPainted(false);
        jButtonB7.setRolloverEnabled(false);

        jButtonC7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC7.setBorderPainted(false);
        jButtonC7.setRolloverEnabled(false);

        jButtonC6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC6.setBorderPainted(false);
        jButtonC6.setRolloverEnabled(false);

        jButtonC5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC5.setBorderPainted(false);
        jButtonC5.setRolloverEnabled(false);

        jButtonC4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC4.setBorderPainted(false);
        jButtonC4.setRolloverEnabled(false);

        jButtonC3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC3.setBorderPainted(false);
        jButtonC3.setRolloverEnabled(false);

        jButtonC2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC2.setBorderPainted(false);
        jButtonC2.setRolloverEnabled(false);

        jButtonC1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonC1.setBorderPainted(false);
        jButtonC1.setRolloverEnabled(false);

        jButtonD7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD7.setBorderPainted(false);
        jButtonD7.setRolloverEnabled(false);

        jButtonD6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD6.setBorderPainted(false);
        jButtonD6.setRolloverEnabled(false);

        jButtonD5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD5.setBorderPainted(false);
        jButtonD5.setRolloverEnabled(false);

        jButtonD4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD4.setBorderPainted(false);
        jButtonD4.setRolloverEnabled(false);

        jButtonD3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD3.setBorderPainted(false);
        jButtonD3.setRolloverEnabled(false);

        jButtonD2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD2.setBorderPainted(false);
        jButtonD2.setRolloverEnabled(false);

        jButtonD1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonD1.setBorderPainted(false);
        jButtonD1.setRolloverEnabled(false);

        jButtonE7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE7.setBorderPainted(false);
        jButtonE7.setRolloverEnabled(false);

        jButtonE6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE6.setBorderPainted(false);
        jButtonE6.setRolloverEnabled(false);

        jButtonE5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE5.setBorderPainted(false);
        jButtonE5.setRolloverEnabled(false);

        jButtonE4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE4.setBorderPainted(false);
        jButtonE4.setRolloverEnabled(false);

        jButtonE3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE3.setBorderPainted(false);
        jButtonE3.setRolloverEnabled(false);

        jButtonE2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE2.setBorderPainted(false);
        jButtonE2.setRolloverEnabled(false);

        jButtonE1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonE1.setBorderPainted(false);
        jButtonE1.setRolloverEnabled(false);

        jButtonF7.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF7.setBorderPainted(false);
        jButtonF7.setRolloverEnabled(false);

        jButtonF6.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF6.setBorderPainted(false);
        jButtonF6.setRolloverEnabled(false);

        jButtonF5.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF5.setBorderPainted(false);
        jButtonF5.setRolloverEnabled(false);

        jButtonF4.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF4.setBorderPainted(false);
        jButtonF4.setRolloverEnabled(false);

        jButtonF3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF3.setBorderPainted(false);
        jButtonF3.setRolloverEnabled(false);

        jButtonF2.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF2.setBorderPainted(false);
        jButtonF2.setRolloverEnabled(false);

        jButtonF1.setBackground(new java.awt.Color(0, 51, 204));
        jButtonF1.setBorderPainted(false);
        jButtonF1.setRolloverEnabled(false);

        jButtonB3.setBackground(new java.awt.Color(0, 51, 204));
        jButtonB3.setBorderPainted(false);
        jButtonB3.setRolloverEnabled(false);

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonA1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonA7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonB1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonB7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonC7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonD1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonD7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonE1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonE7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jButtonF1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonF7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonA1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonA7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonB1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonB2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonB4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonB5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonB6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonB7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonB3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonC1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonC7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonD1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonD7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonE1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonE7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonF1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonF7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelInput.setPreferredSize(new java.awt.Dimension(780, 501));

        jButtonInput7.setBorderPainted(false);

        jButtonInput6.setBorderPainted(false);

        jButtonInput5.setBorderPainted(false);

        jButtonInput4.setBorderPainted(false);

        jButtonInput3.setBorderPainted(false);

        jButtonInput2.setBorderPainted(false);

        jButtonInput1.setBorderPainted(false);

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInput7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonInput7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelBoard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(jPanelInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA1;
    private javax.swing.JButton jButtonA2;
    private javax.swing.JButton jButtonA3;
    private javax.swing.JButton jButtonA4;
    private javax.swing.JButton jButtonA5;
    private javax.swing.JButton jButtonA6;
    private javax.swing.JButton jButtonA7;
    private javax.swing.JButton jButtonB1;
    private javax.swing.JButton jButtonB2;
    private javax.swing.JButton jButtonB3;
    private javax.swing.JButton jButtonB4;
    private javax.swing.JButton jButtonB5;
    private javax.swing.JButton jButtonB6;
    private javax.swing.JButton jButtonB7;
    private javax.swing.JButton jButtonC1;
    private javax.swing.JButton jButtonC2;
    private javax.swing.JButton jButtonC3;
    private javax.swing.JButton jButtonC4;
    private javax.swing.JButton jButtonC5;
    private javax.swing.JButton jButtonC6;
    private javax.swing.JButton jButtonC7;
    private javax.swing.JButton jButtonD1;
    private javax.swing.JButton jButtonD2;
    private javax.swing.JButton jButtonD3;
    private javax.swing.JButton jButtonD4;
    private javax.swing.JButton jButtonD5;
    private javax.swing.JButton jButtonD6;
    private javax.swing.JButton jButtonD7;
    private javax.swing.JButton jButtonE1;
    private javax.swing.JButton jButtonE2;
    private javax.swing.JButton jButtonE3;
    private javax.swing.JButton jButtonE4;
    private javax.swing.JButton jButtonE5;
    private javax.swing.JButton jButtonE6;
    private javax.swing.JButton jButtonE7;
    private javax.swing.JButton jButtonF1;
    private javax.swing.JButton jButtonF2;
    private javax.swing.JButton jButtonF3;
    private javax.swing.JButton jButtonF4;
    private javax.swing.JButton jButtonF5;
    private javax.swing.JButton jButtonF6;
    private javax.swing.JButton jButtonF7;
    private javax.swing.JButton jButtonInput1;
    private javax.swing.JButton jButtonInput2;
    private javax.swing.JButton jButtonInput3;
    private javax.swing.JButton jButtonInput4;
    private javax.swing.JButton jButtonInput5;
    private javax.swing.JButton jButtonInput6;
    private javax.swing.JButton jButtonInput7;
    private javax.swing.JPanel jPanelBoard;
    private javax.swing.JPanel jPanelInput;
    // End of variables declaration//GEN-END:variables
}
