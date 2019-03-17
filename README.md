# N-Queen-Project
Project 2 for CS4200 AI Class. The program solves the N-Queen problem by using either Simulated Annealing or Genetic Algorithm.

Program only requires the "main.java" and "Node.java" files to run. In the Terminal, compile the program by typing in the command "javac main.java" in the file directory of the project. Run the program by typing the command "java main".

At the start of the program, you will be presented with 4 options:

  1. Generate a random solution with Simulated Annealing - Asks for number of queens to use, then generates a solution with that number of queens using Simulated Annealing. The solution is printed with visual of the board as well as the row locations of each queen in its respective column. The 1st row should start from the bottom row, and the n-th row is the top row. The program may have chance of not finding a solution, so it will return the best fit state.
  
  2. Test cases with Simulated Annealing - Asks for number of queens and the amount of test cases to run. The program will then run the Simulated Annealing method with the specified number of queens for specified number of times.  Once complete, the program will return the success rate, average search cost (number of iterations), and average run time in seconds.
  
  3. Generate a random solution with Genetic Algorithm - Asks for number of queens to use, then generates a solution with that number of queens using Genetic Algorithm. The solution is printed with visual of the board as well as the row locations of each queen in its respective column. The 1st row should start from the bottom row, and the n-th row is the top row. The program may have chance of not finding a solution, so it will return the best fit state.
  
  4. Test cases with Genetic Algorithm - Asks for number of queens and the amount of test cases to run. The program will then run the Genetic Algorithm method with the specified number of queens for specified number of times.  Once complete, the program will return the success rate, average search cost (number of iterations), and average run time in seconds.
