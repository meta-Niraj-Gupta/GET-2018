package Queens;

/**
 * @author Niraj Gupta
 * class to implement the famous N-Queens problem.
 * The N-Queen problems is solved using recursion.
 */
public class NQueensProblem {
	
	/**
	 * Method to solve the N-Queens problem. 
	 * @param sizeOfBoard : the size of the board or the number of queens which is to be placed on the board
	 * @return : true if there is any solution available, false otherwise
	 */
	public boolean nQueens(int sizeOfBoard){
		int[][] board = new int[sizeOfBoard][sizeOfBoard];
		if(sizeOfBoard < 4){	//The N-Queen of size 2 and 3 dosen't have any solution.
			throw new AssertionError("The solution is not possible");
		}else if(sizeOfBoard < 0){
			throw new NegativeArraySizeException("The array size cannot be negative");
		}
		if(solveNQueensUntilEnd(board, 0, sizeOfBoard) == false){
			return false;
		}
		printSolutionOfNQueens(board, sizeOfBoard);
		return true;
	}
	
	/**
	 * Method to print the N-Queens board after successfully finding the solution.
	 * @param board : on which the queen is placed and is represented by 1.
	 * @param sizeOfBoard : is the size of the board on which the queens are placed
	 */
	private void printSolutionOfNQueens(int[][] board, int sizeOfBoard) {
		for (int i = 0; i < sizeOfBoard; i++){
            for (int j = 0; j < sizeOfBoard; j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
	}
	
	/**
	 * Method to check if a queen can be placed on board[row][col]. Note that this
       function is called when "col" queens are already placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens
	 * @param board : is the 2-D board at which the queen is placed and is represented by 1.
	 * @param column : is the position at which the queen has been placed
	 * @param sizeOfBoard : is the size of the board on which the queens are placed
	 * @return : true if all the queens are placed successfully, false otherwise
	 */
	private boolean solveNQueensUntilEnd(int[][] board, int column, int sizeOfBoard){
		if(column >= sizeOfBoard){
			return true;
		}
		for(int i = 0; i < sizeOfBoard; i++){
			if(isSafeToPlaceQueen(board, i, column, sizeOfBoard)){
				board[i][column] = 1;
				if(solveNQueensUntilEnd(board, column+1, sizeOfBoard)){
					return true;
				}
				board[i][column] = 0;
			}
		}
		return false;
	}
	
	/**
	 * Method to checks if the queen can be placed on the board such that they should not attack each other.
	 * @param board : on which the queen is placed and is represented by 1.
	 * @param row : the number of row 
	 * @param column : the number of column
	 * @param sizeOfBoard : the size of the board on which the Queens has to be placed.
	 * @return : returns true if the queens are not attacking each other, false otherwise.
	 */
	private boolean isSafeToPlaceQueen(int[][] board, int row, int column, int sizeOfBoard){
		for(int i = 0; i < column; i++){
			if(board[row][i] == 1){
				return false;
			}
		}
		for(int i = row, j = column; i >= 0 && j >= 0; i--, j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		for(int i = row, j = column; j >= 0 && i < sizeOfBoard; i++, j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		return true;
	}
}
