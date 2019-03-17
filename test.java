import java.util.Random;

public class test
{
  public static void main(String[] args)
  {
    //Node testNode = new Node(generateBoard(6));
    //Node testNode = new Node(board);
    //testNode.printBoard();
    //System.out.println("\n" + testNode.evaluation());
    //System.out.println("\n" + testNode.nonAttackingPairs());

    /*
    int[] board1 = generateBoard(8);
    int[] board2 = generateBoard(8);
    for(int i = 0; i < board1.length; i++)
    {
      System.out.print(board1[i] + " ");
    }
    System.out.println();
    for(int i = 0; i < board2.length; i++)
    {
      System.out.print(board2[i] + " ");
    }
    System.out.println();
    Node testNode1 = new Node(board1);
    Node testNode2 = new Node(board2);
    Node childNode = reproduce(testNode1, testNode2);
    int[] childBoard = childNode.getArray();
    for(int i = 0; i < childBoard.length; i++)
    {
      System.out.print(childBoard[i] + " ");
    }
    */
    int[] board = {0, 0, 0, 0, 0, 0, 0, 0};
    Node childNode = new Node(board);
    double fitnessPercent = childNode.incompleteness();
    System.out.println(fitnessPercent * 100);
  }

  public static int[] generateBoard(int size)
  {
    int[] board = new int[size];
    Random rand = new Random();
    for(int i = 0; i < size; i++)
    {
      board[i] = rand.nextInt(size);
    }
    return board;
  } // generateBoard

  public static Node reproduce(Node x, Node y)
  {
    int[] xBoard = x.getArray();
    int[] yBoard = y.getArray();
    int[] childBoard = new int[xBoard.length];

    // Get crossover point.
    Random rand = new Random();
    int crossover = rand.nextInt(xBoard.length);
    // Copy part of X, from 0 to index before crossover point.
    for(int i = 0; i < crossover; i++)
    {
      childBoard[i] = xBoard[i];
    }
    // Copy part of Y, from crossover point to end of array.
    for(int i = crossover; i < childBoard.length; i++)
    {
      childBoard[i] = yBoard[i];
    }
    Node child = new Node(childBoard); // Create new child node with result array.
    return child;
  }

  // Take a fitness array and return a probable index of parent node.
  public static int randomSelection(int[] fitness)
  {
    int total = fitness[fitness.length-1]; // Last value is the total.
    Random rand = new Random();
    int chance = rand.nextInt(total+1); // Random location on the "wheel".
    // Nodes with higher non attacking pair sizes should have higher chance of being selected.
    // (Bigger sections of the "wheel").
    for(int i = 0; i < fitness.length; i++)
    {
      if(chance <= fitness[i])
      {
        return i;
      }
    }
    return fitness.length-1; // If somehow none was chosen, just return last node index.
  }
}
