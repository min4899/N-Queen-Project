import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Implement of algorithms starts at line 346

public class main
{
  static int cost = 0;

  public static void main(String[] args)
  {
    Scanner reader = new Scanner(System.in);

    System.out.println("--- N-Queen Project by Minwoo Soh ---");
    System.out.println("Choose an option (1 to 4):");
    System.out.println("1. Generate a random solution with Simulated Annealing.");
    System.out.println("2. Test cases with Simulated Annealing.");
    System.out.println("3. Generate a random solution with Genetic Algorithm.");
    System.out.println("4. Test cases with Genetic Algorithm.");
    System.out.print("Input: ");

    int input = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        input = reader.nextInt();
        if(input >= 1 && input <= 4)
        {
          break;
        }
        else
        {
          System.out.println("Not a valid option. Please select an option from 1 to 4.");
          System.out.print("Input: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please select an option from 1 to 4.");
        System.out.print("Input: ");
      }
    }
    System.out.println();

    switch(input)
    {
      case 1:
        optionOne();
        break;
      case 2:
        optionTwo();
        break;
      case 3:
        optionThree();
        break;
      case 4:
        optionFour();
        break;
      default:
        System.out.println("Not a valid option.");
    }
  } // end of main method

  // Random Solution with Simulated Annealing.
  public static void optionOne()
  {
    Scanner reader = new Scanner(System.in);
    System.out.println("-- Random Solution with Simulated Annealing --\n");
    System.out.print("Please provide the number of queens (4 or greater): ");

    int numQueen = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        numQueen = reader.nextInt();
        if(numQueen >= 4)
        {
          break;
        }
        else
        {
          System.out.println("Solution for sizes below 4 are impossible. Please provide a different size.");
          System.out.print("Number of queens: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of queens: ");
      }
    }
    System.out.println();

    System.out.println("Generating a random solution for " + numQueen + " Queen.");
    int[] board = generateBoard(numQueen);
    Node result = simulatedAnnealing(board);

    if(result.getEvalValue() == 0)
    {
      System.out.println("Solution found. Displaying solution:\n");
      result.printBoard();
    }
    else
    {
      System.out.println("Solution not found. Displaying best fit state:\n");
      result.printBoard();
    }
  } // end optionOne

  // Test Cases with Simulated Annealing
  public static void optionTwo()
  {
    Scanner reader = new Scanner(System.in);
    System.out.println("-- Test Cases with Simulated Annealing --\n");
    System.out.print("Please provide the number of queens (4 or greater): ");
    int numQueen = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        numQueen = reader.nextInt();
        if(numQueen >= 4)
        {
          break;
        }
        else
        {
          System.out.println("Solution for sizes below 4 are impossible. Please provide a different size.");
          System.out.print("Number of queens: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of queens: ");
      }
    }
    System.out.println();

    System.out.print("Choose the number of test cases: ");
    int testcases = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        testcases = reader.nextInt();
        if(testcases >= 1)
        {
          break;
        }
        else
        {
          System.out.println("Not a valid option. Please provide a number greater than 0.");
          System.out.print("Number of test cases: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of test cases: ");
      }
    }
    System.out.println();

    System.out.println("Generating " + testcases + " test cases for " + numQueen + " Queen with Simulated Annealing.\n");
    double success = 0;
    int total = 0;
    double totalTime = 0.0;
    long start = 0;
    long end = 0;
    long executionTime = 0;
    double seconds = 0.0;
    for(int i = 0; i < testcases; i++)
    {
      int[] board = generateBoard(numQueen);
      start = System.nanoTime();
      Node result = simulatedAnnealing(board);
      end = System.nanoTime();
      executionTime = end - start;
      seconds = (double)executionTime/1000000000.0;
      total += cost;
      totalTime += seconds;
      cost = 0;
      if(result.evaluation() == 0)
      {
        success++;
      }
      System.out.print("\rProgress: " + (int)(((double)i/testcases)*100.0) + "%");
    }
    System.out.print("\rProgress: 100%\n\n");
    double average = total/testcases;
    double averageTime = totalTime/testcases;
    double percent = (success/testcases)*100.0;
    System.out.println("Success rate: " + percent + "%");
    System.out.println("Average search cost: " + (int)average);
    System.out.println("Average run time (seconds): " + averageTime + "\n");
    cost = 0;
  } // end optionTwo

  // Random Solution with Genetic Algorithm
  public static void optionThree()
  {
    Scanner reader = new Scanner(System.in);
    System.out.println("-- Random Solution with Genetic Algorithm --\n");
    System.out.print("Please provide the number of queens (4 or greater): ");

    int numQueen = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        numQueen = reader.nextInt();
        if(numQueen >= 4)
        {
          break;
        }
        else
        {
          System.out.println("Solution for sizes below 4 are impossible. Please provide a different size.");
          System.out.print("Number of queens: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of queens: ");
      }
    }
    System.out.println();

    System.out.println("Generating a random solution for " + numQueen + " Queen.");
    Node result = geneticAlgorithm(numQueen);

    if(result.evaluation() == 0)
    {
      System.out.println("Solution found. Displaying solution:\n");
      result.printBoard();
    }
    else
    {
      System.out.println("Solution not found. Displaying best fit state:\n");
      result.printBoard();
    }
  } // end optionThree

  // Test cases with Genetic Algorithm
  public static void optionFour()
  {
    Scanner reader = new Scanner(System.in);
    System.out.println("-- Test Cases with Genetic Algorithm --\n");
    System.out.print("Please provide the number of queens (4 or greater): ");
    int numQueen = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        numQueen = reader.nextInt();
        if(numQueen >= 4)
        {
          break;
        }
        else
        {
          System.out.println("Solution for sizes below 4 are impossible. Please provide a different size.");
          System.out.print("Number of queens: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of queens: ");
      }
    }
    System.out.println();

    System.out.print("Choose the number of test cases: ");
    int testcases = 0;
    while(true)
    {
      if(reader.hasNextInt())
      {
        testcases = reader.nextInt();
        if(testcases >= 1)
        {
          break;
        }
        else
        {
          System.out.println("Not a valid option. Please provide a number greater than 0.");
          System.out.print("Number of test cases: ");
        }
      }
      else
      {
        reader.next();
        System.out.println("Not a valid option. Please provide a number.");
        System.out.print("Number of test cases: ");
      }
    }
    System.out.println();

    System.out.println("Generating " + testcases + " test cases for " + numQueen + " Queen with Genetic Algorithm.\n");
    double success = 0;
    int total = 0;
    double totalTime = 0.0;
    long start = 0;
    long end = 0;
    long executionTime = 0;
    double seconds = 0.0;
    for(int i = 0; i < testcases; i++)
    {
      start = System.nanoTime();
      Node result = geneticAlgorithm(numQueen);
      end = System.nanoTime();
      executionTime = end - start;
      seconds = (double)executionTime/1000000000.0;
      total += cost;
      totalTime += seconds;
      cost = 0;
      if(result.evaluation() == 0)
      {
        success++;
      }
      System.out.print("\rProgress: " + (int)(((double)i/testcases)*100.0) + "%");
    }
    System.out.print("\rProgress: 100%\n\n");
    double average = total/testcases;
    double averageTime = totalTime/testcases;
    //double percent = ((double) success)/((double) testcases);
    double percent = (success/testcases)*100.0;
    System.out.println("Success rate: " + percent + "%");
    System.out.println("Average search cost: " + (int)average);
    System.out.println("Average run time (seconds): " + averageTime + "\n");
    cost = 0;
  } // end optionFour

  // ** ALGORITHM IMPLEMENTATIONS **

  public static Node simulatedAnnealing(int[] board)
  {
    Node current = new Node(board);
    double T = 10000; // Temperature, should be high at start, gets lower as loop continues
    int E = 0; // evaluation, positive if better move is found, negative if worse move is found.
    Node next = null;
    double probability = 0.0; // Based on e^(E/T)
    double chance = 0.0;
    for(int t = 0; t < 100000; t++) // Max iterations
    {
      if(current.getEvalValue() == 0)
      {
        return current;
      }
      cost++;
      T -= T * 0.01;

      if(T <= 0.0)
      {
        return current;
      }
      next = current.randomMove();
      // Evaluation depends on number of attacking queens possible.
      E = current.getEvalValue() - next.getEvalValue();
      if(E > 0) // Good move, assign next to current.
      {
        current = next;
      }
      else // Bad move, E <= 0
      {
        probability = Math.exp(E/T);
        chance = Math.random();
        if(probability >= chance) // Only assign next to current with probability e^(E/T)
        {
          //System.out.println("BAD MOVE TAKEN");
          current = next;
        }
      }
    } // end for loop
    return current;
  } // end simulatedAnnealing

  public static Node geneticAlgorithm(int numQueen)
  {
    int population = 8;
    int k = 2;
    Node[] popNodes = new Node[population];
    Node[] childNodes = new Node[population];
    // Generate random start states.
    for(int i = 0; i < population; i++)
    {
      Node newNode = new Node(generateBoard(numQueen));
      popNodes[i] = newNode;
    }

    for(int iter = 0; iter < 50000; iter++) // generate child nodes until a solution or best possible state is found.
    {
      cost++;
      int[] fitness = fitness(popNodes); // Generate fitness array for current popNodes.
      for(int i = 0; i < population; i += 2)
      {
        // Choosing parents (SELECTION), no duplicates allowed.
        int xIndex = randomSelection(fitness, k);
        int yIndex = randomSelection(fitness, k);
        while(xIndex == yIndex)
        {
          xIndex = randomSelection(fitness, k);
          yIndex = randomSelection(fitness, k);
        }
        Node x = popNodes[xIndex];
        Node y = popNodes[yIndex];
        // Generate a child node with CROSSOVER.
        Node child[] = reproduce(x, y); // Return 2 children.
        // MUTATION.
        Random rand = new Random();
        // 1st child
        double prob = Math.random();
        if(prob <= 0.25)
        {
          child[0] = child[0].randomMove();
        }

        if(child[0].getEvalValue() == 0) // If solution is found just return it.
        {
          return child[0];
        }
        // Finally, add the first child node to the childNodes array.
        childNodes[i] = child[0];

        if(i+1 <= childNodes.length-1) // If population size is odd.
        {
          // 2nd child
          prob = Math.random();
          //mutateChance = child[1].incompleteness(); // Chance to mutate.
          //if(prob <= mutateChance)
          if(prob <= 0.25)
          {
            child[1] = child[1].randomMove();
          }

          if(child[1].getEvalValue() == 0) // If solution is found just return it.
          {
            return child[1];
          }
          // Finally, add the second child node to the childNodes array.
          childNodes[i+1] = child[1];
        }
      } // child created and assigned
      // Reassign childNodes array as popNodes array.
      popNodes = childNodes.clone();
    } // end search loop

    // No solution found
    int highest = 0; // Index of best individual
    for(int i = 0; i < popNodes.length; i++)
    {
      if(popNodes[i].nonAttackingPairs() > highest) // If a fit individual is found.
      {
        highest = i;
      }
    }
    return popNodes[highest];
  } // end geneticAlgorithm

  // Create a fitness array of the population. Fitness array is represented as a "wheel".
  public static int[] fitness(Node[] population)
  {
    int[] fitnessValues = new int[population.length];
    for(int i = 0; i < population.length; i++)
    {
      fitnessValues[i] = population[i].nonAttackingPairs();
    }
    return fitnessValues;
  } // end fitness

  // Take a fitness array and return a probable index of parent node.
  public static int randomSelection(int[] fitness, int sampleSize)
  {
    Random rand = new Random();
    int indexOfHighest = -1;
    int highest = -1;
    int index = 0;
    for(int i = 0; i < sampleSize; i++)
    {
      do
      {
        index = rand.nextInt(fitness.length);
      } while(index == indexOfHighest);
      if(highest < fitness[index])
      {
        highest = fitness[index];
        indexOfHighest = index;
      }
    }
    return indexOfHighest;
  } // end randomSelection

  // Generate a new child node with crossover of parent Nodes x and y.
  public static Node[] reproduce(Node x, Node y)
  {
    Node[] twoChildren = new Node[2];
    int[] xBoard = x.getArray();
    int[] yBoard = y.getArray();
    int[] childBoard1 = new int[xBoard.length];
    int[] childBoard2 = new int[xBoard.length];

    // Get crossover point.
    Random rand = new Random();
    int crossover = rand.nextInt(xBoard.length);
    // Child Node 1
    // Copy part of X, from 0 to index before crossover point.
    for(int i = 0; i < crossover; i++)
    {
      childBoard1[i] = xBoard[i];
    }
    // Copy part of Y, from crossover point to end of array.
    for(int i = crossover; i < childBoard1.length; i++)
    {
      childBoard1[i] = yBoard[i];
    }
    twoChildren[0] = new Node(childBoard1); // Create new child node with result array.

    // Child node 2.
    // Copy part of Y, from 0 to index before crossover point.
    for(int i = 0; i < crossover; i++)
    {
      childBoard2[i] = yBoard[i];
    }
    // Copy part of X, from crossover point to end of array.
    for(int i = crossover; i < childBoard2.length; i++)
    {
      childBoard2[i] = xBoard[i];
    }
    twoChildren[1] = new Node(childBoard2); // Create new child node with result array.
    return twoChildren;
  } // end reproduce

  // Create a board of size n x n. Place queens in random positions.
  // Each column has only 1 queen.
  // Array Indexes represent column, Array Elements represents row.
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
} // end of main class
