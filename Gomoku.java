import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Programming Project 5 <br>
 * Gomoku class <br>
 * The class represent a Gomoku game.
 * @author Trung Nguyen Huynh
 */
public class Gomoku extends Application {
  /** An array of integers which describe row-directions in the following order: right, left, down, up, down-right, up-left, down-left, up-right */
  private static final int dirX[] = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
  
  /** An array of integers which describe column-directions in the following order: right, left, down, up, down-right, up-left, down-left, up-right */
  private static final int dirY[] = new int[]{1, -1, 0, 0, 1, -1, -1, 1};
  
  /** A number describes which player plays in the current turn
    * 0: Black player
    * 1: White player
    * -1: The game already has the winner */
  private int currentPlayer;
  
  /**
   * Set the current player by an integer.
   * @param value  the input integer describing the player
   */
  public void setCurrentPlayer(int value) {
    currentPlayer = value;
  }
  
  /**
   * Get the current player
   * @return an integer describing the current player
   */
  public int getCurrentPlayer() {
    return currentPlayer;
  }
  
  /**
   * Check if the current position is valid or not
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @return true if the next position is valid; otherwise, return false.
   */
  public static boolean isValid(int[][] board, int idRow, int idColumn) {
    return (idRow >= 0 && idColumn >= 0 && idRow < board.length && idColumn < board[idRow].length);
  }
  
  /**
   * Count how many continuous squares has the same color starting from and including the given position, in the given direction
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @param dir  the given direction
   * @return the number of continuous squares having the same color
   */
  public static int numberInLine(int[][] board, int idRow, int idColumn, int dir) {
    // Store the current index of row (in the loop)
    int curRow = idRow;
    // Store the current index of column (in the loop)
    int curColumn = idColumn;
    // Store the number of continuous squares having the same color as the given position
    int count = 0;
    // The loop to update the variable count
    while (isValid(board, curRow, curColumn) && board[curRow][curColumn] == board[idRow][idColumn]) {
      ++count;
      curRow += dirX[dir];
      curColumn += dirY[dir];
    }
    return count;
  }
  
  /**
   * Check if from the current position and the following same pieces of the board in the given direction, we can reach an empty 
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @param dir  the given direction
   * @return the number of continuous squares having the same color
   */
  public static boolean isOpen(int[][] board, int idRow, int idColumn, int dir) {
    // Store the number of continuous, same squares starting from idRow and idColumn
    int samePiece = numberInLine(board, idRow, idColumn, dir);
    return (isValid(board, idRow + samePiece * dirX[dir], idColumn + samePiece * dirY[dir]) && board[idRow + samePiece * dirX[dir]][idColumn + samePiece * dirY[dir]] == -1);
  }
  
  /**
   * Check if the move at the current position can help the player win the game immediately
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @param numNeedToWin  the number of continuous squares needed to win the game
   * @return true if the player can win immediately; otherwise, return false
   */
  public static boolean isWin(int[][] board, int idRow, int idColumn, int numNeedToWin) {
    // The loop to check if we can win by counting the total same pieces in 4 directions: horizontal, vertical, two diagonals
    for(int i = 0; i < 4; i++) {
      // Store the total same pieces in just one direction
      int totalSamePiece = numberInLine(board, idRow, idColumn, i * 2) + numberInLine(board, idRow, idColumn, i * 2 + 1) - 1;
      if (totalSamePiece == numNeedToWin)
        return true;
    }
    return false;
  }
  
  /**
   * Check if the move at the current position violates the four-four rule or not
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @param numNeedToWin  the number of continuous squares needed to win the game
   * @return true if the move violates the four-four rule; otherwise, return false
   */
  public static boolean isFourFour(int[][] board, int idRow, int idColumn, int numNeedToWin) {
    // Store the number of groups that have 4 pieces (in 4 directions: horizontal, vertical, two diagonals)
    int count = 0;
    for(int i = 0; i < 4; i++) {
      // Store the total same pieces in just one direction
      int totalSamePiece = numberInLine(board, idRow, idColumn, i * 2) + numberInLine(board, idRow, idColumn, i * 2 + 1) - 1;
      if (totalSamePiece == numNeedToWin - 1)
        ++count;
    }
    return (count >= 2);
  }
  
  /**
   * Check if the move at the current position violates the three-three rule or not
   * @param board  2-dimensional array describing the game board
   * @param idRow  current X position
   * @param idColumn  current Y position
   * @param numNeedToWin  the number of continuous squares needed to win the game
   * @return true if the move violates the three-three rule; otherwise, return false
   */
  public static boolean isThreeThree(int[][] board, int idRow, int idColumn, int numNeedToWin) {
    // Store the number of open rows that have 3 pieces (in 4 directions: horizontal, vertical, two diagonals)
    int count = 0;
    for(int i = 0; i < 4; i++) {
      // Store the total same pieces in one way of the 'direction'
      int same1 = numberInLine(board, idRow, idColumn, i * 2) - 1;
      // Store the total same pieces in another way of the 'direction'
      int same2 = numberInLine(board, idRow, idColumn, i * 2 + 1) - 1;
      if (same1 + same2 + 1 == numNeedToWin - 2
            && isOpen(board, idRow, idColumn, i * 2)
            && isOpen(board, idRow, idColumn, i * 2 + 1))
        ++count;
    }
    return (count >= 2);
  }
  
  /**
   * Helper method: Process the move when a button is clicked
   * + Check if the player can win
   * + Check if the player violates 3-3 or 4-4 rule and print the message to notificationBar
   * + Set the appropriate color for button and showCurrentPlayer
   * @param board  the game board
   * @param idRow  row index of the button
   * @param idColumn  column index of the button
   * @param numNeedToWin  the number of continuous squares needed to win the game
   * @return 1 if the player can win; 
   *         -1 if the square is occupied or there is already the winner; 
   *         -2 if 4-4 rule is violated; 
   *         -3 if 3-3 rule is violated; 
   *         0 if the move is valid
   */
  public int processMove(int[][] board, int idRow, int idColumn, int numNeedToWin) {
    if (getCurrentPlayer() < 0 || board[idRow][idColumn] != -1)
      return -1;
    board[idRow][idColumn] = getCurrentPlayer();
    if (isWin(board, idRow, idColumn, numNeedToWin)) {
      setCurrentPlayer(-1);
      return 1;
    }
    if (isFourFour(board, idRow, idColumn, numNeedToWin)) {
      board[idRow][idColumn] = -1;
      return -2;
    }
    if (isThreeThree(board, idRow, idColumn, numNeedToWin)) {
      board[idRow][idColumn] = -1;
      return -3;
    }
    setCurrentPlayer((getCurrentPlayer() + 1) % 2);
    return 0;
  }
  
  /**
   * Reset the game board
   * @param board  2-dimensional array describing the game board
   */
  public void resetGame(int[][] board) {
    setCurrentPlayer(0);
    for(int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = -1;
    }
  }
  
  /**
   * The main entry point for the JavaFX applications.
   * @param stage  The primary stage for this application, onto which the application scene can be set.
   */
  public void start(Stage stage) {
    /** 
     * Setup the game configuration 
     */
    // Store the number of continuous, same pieces needed to win
    final int numNeedToWin = Integer.parseInt(getParameters().getRaw().get(0));
    // Store the number of rows
    final int numRow = Integer.parseInt(getParameters().getRaw().get(1));
    // Store the number of columns
    final int numColumn = Integer.parseInt(getParameters().getRaw().get(2));
    // Store the configuration of game board
    int[][] board = new int[numRow][numColumn];
    setCurrentPlayer(0);
    
    /** 
     * Setup the GUI 
     */
    // Store the GUI of game board
    GridPane pane = new GridPane();
    // Store the scene to be set for the stage
    Scene scene = new Scene(pane);
    // Store the buttons to be clicked by players
    Button[][] button = new Button[numRow][numColumn];
    // The loop to set the background and size for buttons and add them into GridPane
    for(int i = 0; i < numRow; i++) {
      for(int j = 0; j < numColumn; j++) {
        button[i][j] = new Button();
        button[i][j].setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, new Insets(1.2))));
        button[i][j].setMinHeight(35);
        button[i][j].setMinWidth(35);
        button[i][j].setMaxHeight(35);
        button[i][j].setMaxWidth(35);
        pane.add(button[i][j], j, i);
      }
    }
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
    
    /** 
     * Extra: Setup more visual effects 
     * Effect 1: When mouse is over the button
     * Effect 2: When the button is clicked
     * Effect 3: When mouse exits the button
     */
    // The loop to set effects (change color) for button
    for(int i = 0; i < numRow; i++) {
      for(int j = 0; j < numColumn; j++) {
        button[i][j].setOnMouseEntered(e -> {
          ((Button)e.getSource()).setBackground(new Background(new BackgroundFill(Color.GREEN, null, new Insets(1.2))));
        });
        button[i][j].setOnMousePressed(e -> {
          ((Button)e.getSource()).setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, new Insets(1.2))));
        });
        button[i][j].setOnMouseExited(e -> {
          ((Button)e.getSource()).setBackground(new Background(new BackgroundFill(Color.DARKGREEN, null, new Insets(1.2))));
        });
      }
    }
    
    /** 
     * Extra: Adding three more features below the table to inform users of currentPlayer and the game message 
     * Feature 1: Inform players of which player is playing
     * Feature 2: A box to print the game's messages
     * Feature 3: A button to reset the game
     */
    // Store Rectangle to inform players of who is currently in turn
    Rectangle showCurrentPlayer = new Rectangle(35, 35, Color.BLACK);
    // Store TextArea to print the game's messages
    TextArea notificationBar = new TextArea("Welcome to Gomoku!\nBlack player goes first.\nThe box shows who will go in the next turn.\n");
    showCurrentPlayer.setStroke(Color.DARKGREEN);
    showCurrentPlayer.setStrokeWidth(5);
    notificationBar.setEditable(false);
    notificationBar.setMinWidth(Math.max(300, stage.getWidth() - 130));
    notificationBar.setMinHeight(150);
    notificationBar.setMaxHeight(150);
    // Store the reset button
    Button resetButton = new Button("Reset the game");
    resetButton.setOnAction(e -> {
      resetGame(board);
      for(int i = 0; i < numRow; i++) {
        for(int j = 0; j < numColumn; j++) {
          button[i][j].setGraphic(null);
          notificationBar.setText("Welcome to Gomoku!\nBlack player goes first.\nThe box shows who will go in the next turn.\n");
        }
      }
      showCurrentPlayer.setFill(Color.BLACK);
    });
    // Store VBox of showCurrentPlayer and resetButton
    VBox vBox = new VBox(10, showCurrentPlayer, resetButton);
    vBox.setAlignment(Pos.CENTER);
    // Store BorderPane to store the GridPane, Rectangle & TextArea, which now replaces GridPane in scene
    BorderPane borderPane = new BorderPane();
    borderPane.setLeft(vBox);
    borderPane.setRight(notificationBar);
    borderPane.setTop(pane);
    BorderPane.setAlignment(pane, Pos.CENTER);
    pane.setAlignment(Pos.CENTER);
    BorderPane.setAlignment(vBox, Pos.CENTER);
    BorderPane.setMargin(vBox, new Insets(0, 10, 10, 10));
    BorderPane.setMargin(pane, new Insets(10, 0, 10, 0));
    BorderPane.setMargin(notificationBar, new Insets(0, 10, 10, 0));
    scene.setRoot(borderPane);
    stage.sizeToScene();
    
    /** 
     * Setup the game action 
     */
    // The loop to set the initial configuration of game board and register for setOnAction of buttons
    for(int i = 0; i < numRow; i++) {
      for(int j = 0; j < numColumn; j++) {
        board[i][j] = -1;
        button[i][j].setOnAction(e -> {
          Button b = (Button)e.getSource();
          // Store the index of row and column of the clicked button
          int idRow = -1, idColumn = -1;
          // The loop to find idRow and idColumn of the clicked button
          for(int i1 = 0; i1 < numRow && idRow == -1; i1++) {
            for(int j1 = 0; j1 < numColumn && idColumn == -1; j1++) {
              if (button[i1][j1] == b) {
                idRow = i1;
                idColumn = j1;
              }
            }
          }
          switch (processMove(board, idRow, idColumn, numNeedToWin)) {
            case 1:
              if (board[idRow][idColumn] == 0)
                notificationBar.appendText("\nBLACK is the winner!");
              else
                notificationBar.appendText("\nWHITE is the winner!");
              break;
            case -2:
              notificationBar.appendText("\nYou cannot do the four-four. Please pick another place!");
              break;
            case -3:
              notificationBar.appendText("\nYou cannot do the three-three. Please pick another place!");
              break;
          }
          switch(board[idRow][idColumn]) {
            case 0:
              button[idRow][idColumn].setGraphic(new Circle(16.3, Color.BLACK));
              if (getCurrentPlayer() != -1)
                showCurrentPlayer.setFill(Color.WHITE);
              break;
            case 1:
              button[idRow][idColumn].setGraphic(new Circle(16.3, Color.WHITE));
              if (getCurrentPlayer() != -1)
                showCurrentPlayer.setFill(Color.BLACK);
          }
        });
      }
    }
  }
  
  /**
   * The main method for running
   * @param args  the arguments
   */
  public static void main(String[] args) {
    // Store the number of continuous, same pieces needed to win
    int numNeedToWin = 5;
    // Store the number of rows
    int numRow = 19;
    // Store the number of column
    int numColumn = 19;
    try {
      switch (args.length) {
        case 0:
          break;
        case 1:
          numNeedToWin = Integer.parseInt(args[0]);
          break;
        case 2:
          numRow = Integer.parseInt(args[0]);
          numColumn = Integer.parseInt(args[1]);
          break;
        case 3:
          numNeedToWin = Integer.parseInt(args[0]);
          numRow = Integer.parseInt(args[1]);
          numColumn = Integer.parseInt(args[2]);
          break;
        default:
          System.out.println("You must input an appropriate length (<= 3) of arguments. The program will automatically start with 19x19 board and numNeedToWin = 5");
      }
      Application.launch(new String[]{Integer.toString(numNeedToWin), Integer.toString(numRow), Integer.toString(numColumn)});
    }
    catch (NumberFormatException e) {
      System.out.println("Please input appropriate numbers!");
    }
  }
}