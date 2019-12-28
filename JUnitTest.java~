import org.junit.*;
import static org.junit.Assert.*;

/**
 * Programming Project 5 <br>
 * JUnitTest class <br>
 * The class to test the Gomoku class
 * @author Trung Nguyen Huynh
 */
public class JUnitTest {
  /**
   * Test isValid(int[][], int, int) method
   */
  @Test
  public void testIsValid() {
    // 2-dimensional array of integers describing the game board
    int[][] board = new int[19][17];
    // Test out-of-board
    //// Up
    assertFalse("Should return false", Gomoku.isValid(board, -1, -1));
    assertFalse("Should return false", Gomoku.isValid(board, -1, 5));
    assertFalse("Should return false", Gomoku.isValid(board, -1, 17));
    //// Down
    assertFalse("Should return false", Gomoku.isValid(board, 19, -1));
    assertFalse("Should return false", Gomoku.isValid(board, 19, 4));
    assertFalse("Should return false", Gomoku.isValid(board, 19, 17));
    //// Left
    assertFalse("Should return false", Gomoku.isValid(board, -1, -1));
    assertFalse("Should return false", Gomoku.isValid(board, 10, -1));
    assertFalse("Should return false", Gomoku.isValid(board, 19, -1));
    //// Right
    assertFalse("Should return false", Gomoku.isValid(board, -1, 17));
    assertFalse("Should return false", Gomoku.isValid(board, 12, 17));
    assertFalse("Should return false", Gomoku.isValid(board, 19, 17));
    // Test inside-board
    //// In the first row
    assertTrue("Should return true", Gomoku.isValid(board, 0, 0));
    assertTrue("Should return true", Gomoku.isValid(board, 0, 15));
    assertTrue("Should return true", Gomoku.isValid(board, 0, 16));
    //// In the last row
    assertTrue("Should return true", Gomoku.isValid(board, 18, 0));
    assertTrue("Should return true", Gomoku.isValid(board, 18, 4));
    assertTrue("Should return true", Gomoku.isValid(board, 18, 16));
    //// In the middle row
    assertTrue("Should return true", Gomoku.isValid(board, 5, 0));
    assertTrue("Should return true", Gomoku.isValid(board, 3, 3));
    assertTrue("Should return true", Gomoku.isValid(board, 10, 16));
  }
  
  /**
   * Test numberInLine(int[][], int, int, int) method
   */
  @Test
  public void testNumberInLine() {
    // 2-dimensional array of integers describing the game board
    int[][] board;
    // Test right
    //// There is only 1 piece
    board = new int[][]{{-1, -1, -1}, {-1, 0, 1}, {-1, 1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 0));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 2, 1, 0));
    //// There are some pieces
    board = new int[][]{{-1, 1, 1, 0}, {0, 1, 1, -1}};
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 0, 1, 0));
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 1, 1, 0));
    //// Reaches the edge of the board
    board = new int[][]{{-1, 1, 1, 1}, {0, 1, 1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 1, 0));
    // Test left
    //// There is only 1 piece
    board = new int[][]{{-1, -1, -1}, {1, 0, 1}, {-1, 1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 1));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 2, 1, 1));
    //// There are some pieces
    board = new int[][]{{-1, 1, 1, 0}, {0, 1, 1, -1}};
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 0, 2, 1));
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 1, 2, 1));
    //// Reaches the edge of the board
    board = new int[][]{{1, 1, 1, -1}, {0, 1, 1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 2, 1));
    // Test down
    //// There is only 1 piece
    board = new int[][]{{-1, -1, -1}, {-1, 0, 0}, {-1, 1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 2));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 2, 2));
    //// There are some pieces
    board = new int[][]{{-1, 0}, {1, 1}, {1, 1}, {0, -1}}; 
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 1, 0, 2));
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 1, 1, 2));
    //// Reaches the edge of the board
    board = new int[][]{{-1, 0}, {1, 1}, {1, 1}, {1, -1}}; 
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 1, 0, 2));
    // Test up
    //// There is only 1 piece
    board = new int[][]{{-1, 1, -1}, {-1, 0, 0}, {-1, -1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 3));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 2, 3));
    //// There are some pieces
    board = new int[][]{{-1, 0}, {1, 1}, {1, 1}, {0, -1}}; 
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 2, 0, 3));
    assertEquals("Should return 2", 2, Gomoku.numberInLine(board, 2, 1, 3));
    //// Reaches the edge of the board
    board = new int[][]{{1, 0}, {1, 1}, {1, 1}, {-1, -1}}; 
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 2, 0, 3));
    // Test down-right
    //// There is only 1 piece
    board = new int[][]{{-1, -1, -1}, {0, 0, -1}, {-1, 1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 0, 4));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 4));
    //// There are some pieces
    board = new int[][]{{0, -1, -1, -1}, {-1, 0, -1, -1}, {-1, -1, 0, -1}, {-1, -1, -1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 0, 4));
    board[3][3] = 1;
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 0, 4));
    //// Reaches the edge of the board
    board = new int[][]{{0, -1, -1, -1}, {-1, 0, -1, -1}, {-1, -1, 0, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 0, 4));
    // Test up-left
    //// There is only 1 piece
    board = new int[][]{{-1, 1, -1}, {-1, 0, 0}, {-1, -1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 0, 5));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 5));
    //// There are some pieces
    board = new int[][]{{-1, -1, -1, -1}, {-1, 0, -1, -1}, {-1, -1, 0, -1}, {-1, -1, -1, 0}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 3, 3, 5));
    board[0][0] = 1;
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 3, 3, 5));
    //// Reaches the edge of the board
    board = new int[][]{{-1, 0, -1, -1}, {-1, -1, 0, -1}, {-1, -1, -1, 0}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 2, 3, 5));
    // Test down-left
    //// There is only 1 piece
    board = new int[][]{{-1, -1, -1}, {-1, 0, 0}, {1, -1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 0, 6));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 6));
    //// There are some pieces
    board = new int[][]{{-1, -1, -1, 0}, {-1, -1, 0, -1}, {-1, 0, -1, -1}, {-1, -1, -1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 3, 6));
    board[3][0] = 1;
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 3, 6));
    //// Reaches the edge of the board
    board = new int[][]{{-1, -1, -1, 0}, {-1, -1, 0, -1}, {-1, 0, -1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 0, 3, 6));
    // Test up-right
    //// There is only 1 piece
    board = new int[][]{{-1, -1, 1}, {0, 0, -1}, {-1, -1, -1}};
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 0, 7));
    assertEquals("Should return 1", 1, Gomoku.numberInLine(board, 1, 1, 7));
    //// There are some pieces
    board = new int[][]{{-1, -1, -1, -1}, {-1, -1, 0, -1}, {-1, 0, -1, -1}, {0, -1, -1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 3, 0, 7));
    board[0][3] = 1;
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 3, 0, 7));
    //// Reaches the edge of the board
    board = new int[][]{{-1, -1, 0, -1}, {-1, 0, -1, -1}, {0, -1, -1, -1}};
    assertEquals("Should return 3", 3, Gomoku.numberInLine(board, 2, 0, 7));
  }
  
  /**
   * Test isOpen(int[][], int, int, int)
   */
  @Test
  public void testIsOpen() {
    // 2-dimensional array of integers describing the game board
    int[][] board;
    // Test right
    //// Return true
    board = new int[][]{{0, 0, -1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 0, 0, 0));
    //// Return false: the square is occupied
    board = new int[][]{{0, 0, 1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 0, 0));
    //// Return false: reaches the edge of the board
    board = new int[][]{{0, 0, 0, 0}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 0, 0));
    // Test left
    //// Return true
    board = new int[][]{{-1, -1, 1, 1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 0, 3, 1));
    //// Return false: the square is occupied
    board = new int[][]{{-1, 0, 1, 1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 3, 1));
    //// Return false: reaches the edge of the board
    board = new int[][]{{1, 1, 1, 1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 3, 1));
    // Test down
    //// Return true
    board = new int[][]{{-1, 0, -1}, {-1, 0, -1}, {-1, -1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 0, 1, 2));
    //// Return false: the square is occupied
    board = new int[][]{{-1, 0, -1}, {-1, 0, -1}, {-1, 1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 1, 2));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, 0, -1}, {-1, 0, -1}, {-1, 0, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 1, 2));
    // Test up
    //// Return true
    board = new int[][]{{-1, -1, -1}, {-1, 0, -1}, {-1, 0, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 2, 1, 3));
    //// Return false: the square is occupied
    board = new int[][]{{-1, 1, -1}, {-1, 0, -1}, {-1, 0, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 1, 3));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, 0, -1}, {-1, 0, -1}, {-1, 0, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 1, 3));
    // Test down-right
    //// Return true
    board = new int[][]{{-1, 1, -1, -1}, {-1, -1, 1, -1}, {-1, -1, -1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 0, 1, 4));
    //// Return false: the square is occupied
    board = new int[][]{{-1, 1, -1, -1}, {-1, -1, 1, -1}, {-1, -1, -1, 0}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 1, 4));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, 0, -1, -1}, {-1, -1, 0, -1}, {-1, -1, -1, 0}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 1, 4));
    // Test up-left
    //// Return true
    board = new int[][]{{-1, -1, -1, -1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 2, 2, 5));
    //// Return false: the square is occupied
    board = new int[][]{{0, -1, -1, -1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 2, 5));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, 0, -1, -1}, {-1, -1, 0, -1}, {-1, -1, -1, 0}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 3, 5));
    // Test down-left
    //// Return true
    board = new int[][]{{-1, -1, 0}, {-1, 0, -1}, {-1, -1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 0, 2, 6));
    //// Return false: the square is occupied
    board = new int[][]{{-1, -1, 0}, {-1, 0, -1}, {1, -1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 2, 6));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, -1, 0}, {-1, 0, -1}, {0, -1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 0, 2, 6));
    // Test up-right
    //// Return true
    board = new int[][]{{-1, -1, -1}, {-1, 0, -1}, {0, -1, -1}};
    assertTrue("Should return true", Gomoku.isOpen(board, 2, 0, 7));
    //// Return false: the square is occupied
    board = new int[][]{{-1, -1, 1}, {-1, 0, -1}, {0, -1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 0, 7));
    //// Return false: reaches the edge of the board
    board = new int[][]{{-1, -1, 0}, {-1, 0, -1}, {0, -1, -1}};
    assertFalse("Should return false", Gomoku.isOpen(board, 2, 0, 7));
  }
  
  /**
   * Test isWin(int[][], int, int, int)
   */
  @Test
  public void testIsWin() {
    // 2-dimensional array of integers describing the game board
    int[][] board;
    // Return true: The player can win
    //// The last move is at the endpoints of the series
    board = new int[][]{{1, 0, 0, 0, 0, 0, -1}};
    assertTrue("Should return true", Gomoku.isWin(board, 0, 1, 5));               // numNeedToWin = 5, horizontal direction
    board = new int[][]{{0}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {-1}};
    assertTrue("Should return true", Gomoku.isWin(board, 7, 0, 7));               // numNeedToWin = 7, vertical direction
    //// The last move is at the middle of the series
    board = new int[][]{{-1, -1, -1, -1, -1, -1, -1}, 
                        {-1, -1, -1, -1, -1, 0, -1}, 
                        {-1, -1, -1, -1, 0, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1},
                        {-1, -1, 0, -1, -1, -1, -1},
                        {-1, 0, -1, -1, -1, -1, -1},
                        {0, -1, -1, -1, -1, -1, -1}};
    assertTrue("Should return true", Gomoku.isWin(board, 4, 2, 6));               // numNeedToWin = 6, diagonal direction
    board = new int[][]{{-1, -1, -1, -1, -1, -1, -1}, 
                        {-1, 0, -1, -1, -1, -1, -1}, 
                        {-1, -1, 0, -1, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1},
                        {-1, -1, -1, -1, 0, -1, -1},
                        {-1, -1, -1, -1, -1, 0, -1},
                        {-1, -1, -1, -1, -1, -1, 0}};
    assertTrue("Should return true", Gomoku.isWin(board, 3, 3, 6));               // numNeedToWin = 6, diagonal direction
    // Return false: The player cannot win
    //// Less than numNeedToWin
    board = new int[][]{{-1, 0, -1, -1, -1, -1},
                        {-1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1}, 
                        {-1, -1, -1, -1, 0, -1}, 
                        {1, 1, 1, -1, 1, -1}};
    assertFalse("Should return false", Gomoku.isWin(board, 1, 2, 5));             // numNeedToWin = 5
    //// Overline: more than numNeedToWin
    board = new int[][]{{-1, 0, -1, -1, -1, -1, -1},
                        {-1, -1, 0, -1, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, -1, 0, -1, -1}, 
                        {-1, -1, -1, -1, -1, 0, -1},
                        {-1, -1, -1, -1, -1, -1, 0}};
    assertFalse("Should return false", Gomoku.isWin(board, 3, 4, 5));             // numNeedToWin = 5
  }
  
  /**
   * Test isFourFour(int[][], int, int, int)
   */
  @Test
  public void testIsFourFour() {
    // 2-dimensional array of integers describing the game board
    int[][] board;
    // Return true: The player violates 4-4 rule
    //// Closed rows
    board = new int[][]{{-1, 0, -1, 0, -1, -1, -1},
                        {-1, -1, 0, 0, -1, -1, -1},
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, 0, -1, -1},
                        {-1, -1, -1, 1, -1, 1, -1}};
    assertTrue("Should return true", Gomoku.isFourFour(board, 2, 3, 5));          // numNeedToWin = 5
    //// Open rows
    board = new int[][]{{-1, -1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, 0, -1},
                        {-1, -1, -1, -1, 0, -1, -1},
                        {-1, 0, 0, 0, 0, -1, -1}, 
                        {-1, -1, 0, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, 1, -1}};
    assertTrue("Should return true", Gomoku.isFourFour(board, 3, 3, 5));          // numNeedToWin = 5
    //// Closed & open rows
    board = new int[][]{{-1, -1, -1, 0, -1, -1, -1},
                        {-1, 0, -1, 0, -1, -1, -1},
                        {-1, -1, 0, 0, -1, -1, -1},
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, 0, -1, -1},
                        {-1, -1, -1, 1, -1, 0, -1}};
    assertTrue("Should return true", Gomoku.isFourFour(board, 3, 3, 6));          // numNeedToWin = 6
    // Return false: The player does not violate 4-4 rule
    //// A row with more than (numNeedToWin - 1) continuous pieces
    board = new int[][]{{-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {0, 0, 0, 0, 0, 0, 0}, 
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1}};
    assertFalse("Should return false", Gomoku.isFourFour(board, 2, 3, 6));        // numNeedToWin = 6
    //// A row with less than (numNeedToWin - 1) continuous pieces
    board = new int[][]{{-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, 0, 0, 0, 0, 0, -1}, 
                        {-1, -1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, 1, -1, -1, -1}};
    assertFalse("Should return false", Gomoku.isFourFour(board, 2, 3, 6));        // numNeedToWin = 6
  }
  
  /**
   * Test isThreeThree(int[][], int, int, int)
   */
  @Test
  public void testIsThreeThree() {
    // 2-dimensional array of integers describing the game board
    int[][] board;
    // Return true: The player violates 3-3 rule
    //// Two open '3-3' rows
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, -1, 1, -1, -1, -1}, 
                        {-1, -1, 1, 1, 1, -1}, 
                        {-1, -1, 1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1}};
    assertTrue("Should return true", Gomoku.isThreeThree(board, 2, 2, 5));       // numNeedToWin = 5
    //// More than two open '3-3' rows
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, 1, -1, 1, -1, -1}, 
                        {-1, -1, 1, 1, 1, -1}, 
                        {-1, 1, -1, 1, -1, -1},
                        {-1, -1, -1, -1, -1, -1}};
    assertTrue("Should return true", Gomoku.isThreeThree(board, 2, 2, 5));       // numNeedToWin = 5
    // Return false: The player does not violate 3-3 rule
    //// Less than 2 open '3-3' rows
    board = new int[][]{{-1, -1, 0, -1, -1, -1}, 
                        {-1, -1, 1, 1, -1, -1}, 
                        {-1, -1, 1, 1, 1, -1}, 
                        {-1, 1, 1, -1, -1, -1},
                        {0, -1, -1, -1, -1, -1}};
    assertFalse("Should return false", Gomoku.isThreeThree(board, 2, 2, 5));     // numNeedToWin = 5
    //// There are not enough rows that has exactly (numNeedToWin - 2) pieces
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, -1, 1, 0, -1, -1}, 
                        {-1, 1, 1, 1, 1, -1}, 
                        {-1, 1, 1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1}};
    assertFalse("Should return false", Gomoku.isThreeThree(board, 2, 2, 5));     // numNeedToWin = 5
  }
  
  /**
   * Test processMove(int[][], int, int, int)
   */
  @Test
  public void testProcessMove() {
    // Store an instance of Gomoku
    Gomoku gomoku = new Gomoku();
    // Store the game board and another board to compare
    int[][] board, compBoard;
    // Test: The game has already had a winner
    gomoku.setCurrentPlayer(-1);
    board = new int[][]{{-1, 1}};
    compBoard = new int[][]{{-1, 1}};
    assertEquals("Should return -1", -1, gomoku.processMove(board, 0, 0, 0));
    assertArrayEquals("Should not change the board", compBoard, board);
    assertEquals("Should not change the current player", -1, gomoku.getCurrentPlayer());
    // Test: The square to process is already occupied
    gomoku.setCurrentPlayer(1);
    board = new int[][]{{0, -1, 1}, {-1, -1, -1}};
    compBoard = new int[][]{{0, -1, 1}, {-1, -1, -1}};
    assertEquals("Should return -1", -1, gomoku.processMove(board, 0, 2, 0));
    assertArrayEquals("Should not change the board", compBoard, board);
    assertEquals("Should not change the current player", 1, gomoku.getCurrentPlayer());
    // Test: The move makes the current player win the game
    gomoku.setCurrentPlayer(1);
    board = new int[][]{{-1, -1, -1, 1, -1}, 
                        {1, -1, -1, 1, -1}, 
                        {-1, 1, -1, 1, -1}, 
                        {-1, -1, 1, 1, -1},
                        {-1, -1, -1, -1, -1}};
    compBoard = new int[][]{{-1, -1, -1, 1, -1}, 
                            {1, -1, -1, 1, -1}, 
                            {-1, 1, -1, 1, -1}, 
                            {-1, -1, 1, 1, -1},
                            {-1, -1, -1, 1, -1}};
    assertEquals("Should return 1", 1, gomoku.processMove(board, 4, 3, 5));
    assertArrayEquals("Should change the board", compBoard, board);
    assertEquals("Current player should now be -1", -1, gomoku.getCurrentPlayer());
    // Test: The move violates '4-4' rule
    gomoku.setCurrentPlayer(0);
    board = new int[][]{{-1, -1, -1, 0, -1, -1}, 
                        {-1, -1, 0, -1, 0, -1}, 
                        {-1, -1, -1, 0, -1, -1}};
    compBoard = new int[][]{{-1, -1, -1, 0, -1, -1}, 
                            {-1, -1, 0, -1, 0, -1}, 
                            {-1, -1, -1, 0, -1, -1}};
    assertEquals("Should return -2", -2, gomoku.processMove(board, 1, 3, 4));
    assertArrayEquals("Should not change the board", compBoard, board);
    assertEquals("Current player should still be 0", 0, gomoku.getCurrentPlayer());
    // Test: The move violates '3-3' rule
    gomoku.setCurrentPlayer(0);
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, 0, -1, 0, -1, -1}, 
                        {-1, -1, -1, -1, -1, -1}, 
                        {-1, 0, -1, 0, -1, -1}, 
                        {-1, -1, -1, -1, -1, -1}};
    compBoard = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                            {-1, 0, -1, 0, -1, -1}, 
                            {-1, -1, -1, -1, -1, -1}, 
                            {-1, 0, -1, 0, -1, -1},
                            {-1, -1, -1, -1, -1, -1}};
    assertEquals("Should return -3", -3, gomoku.processMove(board, 2, 2, 5));
    assertArrayEquals("Should not change the board", compBoard, board);
    assertEquals("Current player should still be 0", 0, gomoku.getCurrentPlayer());
    // Test: The move is completely valid
    gomoku.setCurrentPlayer(1);
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, -1, 1, -1, -1, -1}, 
                        {-1, 1, -1, 1, 1, -1}, 
                        {-1, -1, 1, -1, -1, -1}, 
                        {-1, -1, -1, -1, -1, -1}};
    compBoard = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                            {-1, -1, 1, -1, -1, -1}, 
                            {-1, 1, 1, 1, 1, -1}, 
                            {-1, -1, 1, -1, -1, -1}, 
                            {-1, -1, -1, -1, -1, -1}};
    assertEquals("Should return 0", 0, gomoku.processMove(board, 2, 2, 5));
    assertArrayEquals("Should allow the move", compBoard, board);
    assertEquals("Current player should now be 0", 0, gomoku.getCurrentPlayer());
    gomoku.setCurrentPlayer(0);
    board = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                        {-1, -1, 0, -1, -1, -1}, 
                        {1, 0, -1, 0, 1, -1}, 
                        {-1, -1, 0, -1, -1, -1}, 
                        {-1, -1, -1, -1, -1, -1}};
    compBoard = new int[][]{{-1, -1, -1, -1, -1, -1}, 
                            {-1, -1, 0, -1, -1, -1}, 
                            {1, 0, 0, 0, 1, -1}, 
                            {-1, -1, 0, -1, -1, -1}, 
                            {-1, -1, -1, -1, -1, -1}};
    assertEquals("Should return 0", 0, gomoku.processMove(board, 2, 2, 5));
    assertArrayEquals("Should allow the move", compBoard, board);
    assertEquals("Current player should now be 1", 1, gomoku.getCurrentPlayer());
  }
  
  /**
   * Test resetGame(int[][])
   */
  public void testResetGame() {
    // Store an instance of Gomoku
    Gomoku gomoku = new Gomoku();
    // Store the game board and another board to compare
    int[][] board, compBoard;
    // A board with one row and one column
    gomoku.setCurrentPlayer(1);
    board = new int[][]{{1}};
    compBoard = new int[][]{{-1}};
    gomoku.resetGame(board);
    assertArrayEquals("Should set everything into -1", compBoard, board);
    assertEquals("Black should be the current player", 0, gomoku.getCurrentPlayer());
    // A board with many rows and one column
    gomoku.setCurrentPlayer(-1);
    board = new int[][]{{-1}, {1}, {0}, {-1}};
    compBoard = new int[][]{{-1}, {-1}, {-1}, {-1}};
    gomoku.resetGame(board);
    assertArrayEquals("Should set everything into -1", compBoard, board);
    assertEquals("Black should be the current player", 0, gomoku.getCurrentPlayer());
    // A board with one row and many columns
    gomoku.setCurrentPlayer(1);
    board = new int[][]{{-1, 0, 1, 1, 1}};
    compBoard = new int[][]{{-1, -1, -1, -1, -1}};
    gomoku.resetGame(board);
    assertArrayEquals("Should set everything into -1", compBoard, board);
    assertEquals("Black should be the current player", 0, gomoku.getCurrentPlayer());
    // A board with many rows and many columns
    gomoku.setCurrentPlayer(-1);
    board = new int[][]{{-1, 0, 1, 1, 1}, {-1, -1, -1, 1, 0}, {1, 1, 0, 1, 1}};
    compBoard = new int[][]{{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}};
    gomoku.resetGame(board);
    assertArrayEquals("Should set everything into -1", compBoard, board);
    assertEquals("Black should be the current player", 0, gomoku.getCurrentPlayer());
  }
}