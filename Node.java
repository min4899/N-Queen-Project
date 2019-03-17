import java.util.Random;

// Node class specifically for the n-queens project.
public class Node
{
  private int[] board;
  private int evalValue;

  // Constructor with input board setup.
  // Array Indexes represent column, Array Elements represents row.
  public Node(int[] board)
  {
    this.board = board.clone();
    evalValue = evaluation();
  } // end constructor

  // Move a random piece and return a new Node with the new move.
  public Node randomMove()
  {
    Random rand = new Random();
    int[] nextBoard = board.clone();
    int row = 0;
    int col = 0;
    do
    {
      row = rand.nextInt(board.length);
      col = rand.nextInt(board.length);
    } while(row == nextBoard[col]); // if it doesn't move
    nextBoard[col] = row;
    Node returnNode = new Node(nextBoard);
    return returnNode;
  } // end random Move

  // Evaluation function determines number of queens that can attack each other.
  // Lower value means better evaluation.
  // 0 if no queens can attack each other.
  public int evaluation()
  {
    int eval = 0;
    for(int i = 0; i < board.length; i++)
    {
      for(int j = 0; j < board.length; j++)
      {
        if(i != j)
        {
          // same row or diagonal
          if((board[i] == board[j]) || (Math.abs(board[i] - board[j]) == Math.abs(i - j)))
          {
            eval++;
          }
        }
      }
    }
    return eval;
  } // end evaluation

  public double incompleteness()
  {
    return ((double)evalValue) / ((board.length-1)*(board.length));
  }

  // Returns number of non-attacking pairs of queens.
  // Highest (best) value is (board.length-1)*(board.length), where no queen pairs can attack each other.
  // Lowest (worst) value is 0, where all queen pairs can attack each other.
  public int nonAttackingPairs()
  {
    //return ((board.length-1)*board.length - evaluation())/2;
    return ((board.length-1)*board.length - evalValue)/2;
  } // end nonAttackingQueens

  public int[] getArray()
  {
    return board.clone();
  }

  public int getEvalValue()
  {
    return evalValue;
  }

  public void printBoard()
  {
    int[][] chessboard = new int[board.length][board.length];
    for(int i = 0; i < board.length; i++)
    {
      chessboard[(board.length-1)-board[i]][i] = 1;
    }

    // Print board
    for(int i = 0; i < board.length; i++) // row
    {
      for(int j = 0; j < board.length; j++) // column
      {
        if(chessboard[i][j] != 0)
        {
          System.out.print("= ");
        }
        else
        {
          System.out.print(chessboard[i][j] + " ");
        }
      }
      System.out.println();
    }
    System.out.println("\n= -> Queen     0 -> Blank Space\n");

    System.out.println("\nLocations (which row each queen is on for its respective column): \n");
    for(int i = 0; i < board.length; i++)
    {
      System.out.print(board[i]+1 + " ");
    }
    System.out.println();
  } // end printBoard
} // end of Node class
