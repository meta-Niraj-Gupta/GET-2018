package OperationOnSparseMatrix;

/**
 * @author Niraj Gupta
 * Class to perform different operations on the matrix. Operations like adding and multiplying 
 * two matrices, finding the transpose of a matrix and checking if the matirx is symmetric or not.
 * This class is immutable
 */
public final class SparseMatrix{
	private final int[][] sparseMatrix;
	
	/**
	 * Parameterized Constructor for creating immutable sparse matrix.
	 * @param matrix : the user input 2-D sparse matrix
	 */
	public SparseMatrix(int[][] matrix){
		sparseMatrix = convertMatrix(matrix);
	}
	
	/**
	 * Method to count the number of non-zero elements in an matrix.
	 * @param matrix : the 2-D user input sparse matrix
	 * @return : the count of the non zero elements in an matrix
	 */
	private int getCountOfPositiveValue(int[][] matrix){
		int countNonZero = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] != 0){
					countNonZero++;
				}
			}
		}
		return countNonZero;
	}
	
	/**
	 * Method to get sparse matrix
	 * @return : the sparse matrix
	 */
	public int[][] getSparseMatrix(){
		int[][] sparseMatrix = new int[this.sparseMatrix[0][0]][this.sparseMatrix[0][1]];
		for(int i = 1; i < this.sparseMatrix.length; i++){
			sparseMatrix[this.sparseMatrix[i][0]][this.sparseMatrix[i][1]] = this.sparseMatrix[i][2];
		}
		return sparseMatrix;
	}
	
	/**
	 * Method to convert the user input sparse matrix into memory efficient sparse matrix.
	 * @param matrix : the 2-D user input sparse matrix
	 * @return : the memory efficient 2-D sparse matrix
	 */
	private int[][] convertMatrix(int[][] matrix){
		int size = getCountOfPositiveValue(matrix);
		int count = 1;
		int[][] newMatrix = new int[size+1][3];
		newMatrix[0][0] = matrix.length; 
		newMatrix[0][1] = matrix[0].length;
		newMatrix[0][2] = size;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] != 0){
					newMatrix[count][0] = i;
					newMatrix[count][1] = j;
					newMatrix[count][2] = matrix[i][j];
					count++;
				}
			}
		}
		return newMatrix;
	}
	
	/**
	 * Method to calculate the transpose of the matrix
	 * @return : the object of SparseMatrix which contains the transpose of matrix
	 */
	public SparseMatrix transposeOfMatrix(){
		if(this.sparseMatrix[0][0] != this.sparseMatrix[0][1]){
			throw new AssertionError("Invalid Input : Please input matrix with same number of rows and columns");
		}
		int[][] newArray = new int[sparseMatrix[0][0]][sparseMatrix[0][1]];
		for(int i = 1; i <= sparseMatrix[0][2]; i++){
			newArray[sparseMatrix[i][1]][sparseMatrix[i][0]] = sparseMatrix[i][2];
		}
		return new SparseMatrix(newArray);
	}
	
	/**
	 * Method to check whether the given matrix is symmetric or not.
	 * @return : true if the matrix is symmetric, false otherwise
	 */
	public boolean isSymmetric(){
		if(this.sparseMatrix[0][0] == this.sparseMatrix[0][1]){
			SparseMatrix newArray = this.transposeOfMatrix();
			for(int i = 1; i <= newArray.sparseMatrix[0][2]; i++){
				if(newArray.sparseMatrix[i][0] != this.sparseMatrix[i][0]
					&& newArray.sparseMatrix[i][1] != this.sparseMatrix[i][1]
					&& newArray.sparseMatrix[i][2] != this.sparseMatrix[i][2]){
					return false;
				}
			}
			return true;
		}else{
			throw new AssertionError("Invalid Input : Please input matrix with same number of rows and columns");
		}
	}
	
	/**
	 * Method to add two sparse matrices
	 * @param sparse : the object.sparseMatrix which is to be added with this.sparseMatrix
	 * @return : the object of SparseMatrix which contains the addition of the two sparse matrices
	 * @throws IllegalArgumentException : if the order of the matrices are not equal
	 */
	public SparseMatrix addTwoMatrix(SparseMatrix sparse) throws IllegalArgumentException{
		if(this.sparseMatrix[0][0] == sparse.sparseMatrix[0][0] 
				&& this.sparseMatrix[0][1] == sparse.sparseMatrix[0][1]){
			
			int i = 1, j = 1;
			int[][] newArray = new int[this.sparseMatrix[0][0]][this.sparseMatrix[0][1]];
			
			while(i < this.sparseMatrix.length && j < sparse.sparseMatrix.length){
				
				if(this.sparseMatrix[i][0] == sparse.sparseMatrix[j][0] 
						&& this.sparseMatrix[i][1] == sparse.sparseMatrix[j][1]){
					
					newArray[this.sparseMatrix[i][0]][sparse.sparseMatrix[i][1]] 
							= this.sparseMatrix[i++][2] + sparse.sparseMatrix[j++][2];
				}else if(this.sparseMatrix[i][0] == sparse.sparseMatrix[j][0] 
						&& this.sparseMatrix[i][1] < sparse.sparseMatrix[j][1]){
					
					newArray[this.sparseMatrix[i][0]][this.sparseMatrix[i][1]] 
							= this.sparseMatrix[i++][2];
				}else if(this.sparseMatrix[i][0] == sparse.sparseMatrix[j][0] 
						&& this.sparseMatrix[i][1] > sparse.sparseMatrix[j][1]){
					
					newArray[this.sparseMatrix[i][0]][sparse.sparseMatrix[j][1]]
							= sparse.sparseMatrix[j++][2];
				}else if(this.sparseMatrix[i][0] > sparse.sparseMatrix[j][0]){
					
					newArray[sparse.sparseMatrix[j][0]][sparse.sparseMatrix[j][1]]
							= sparse.sparseMatrix[j++][2];
				}else{
					
					newArray[sparse.sparseMatrix[i][0]][sparse.sparseMatrix[i][1]]
							= sparse.sparseMatrix[i++][2];
				}
			}
			while(i < this.sparseMatrix.length){
				newArray[this.sparseMatrix[i][0]][this.sparseMatrix[i][1]] 
						= this.sparseMatrix[i++][2];
			}
			while(j < sparse.sparseMatrix.length){
				newArray[this.sparseMatrix[j][0]][this.sparseMatrix[j][1]] 
						= this.sparseMatrix[j++][2];
			}
			
			return new SparseMatrix(newArray);
		}else{
			throw new IllegalArgumentException("Invalid Input : The order of matrix is not same. "
													+ "Enter valid matrix with same order.");
		}
	}
	
	/**
	 * Method to print the sparse matrix
	 */
	public void printSparseMatrix(){
		for(int i = 0; i < sparseMatrix.length; i++){
			for(int j = 0; j < sparseMatrix[i].length; j++){
				System.out.print(sparseMatrix[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	/**
	 * Method to multiply two matrices
	 * @param sparse : the object.sparseMatrix which is multiplied with this.sparseMatrix
	 * @return : the object of SparseMatrix which contains the multiplication of two matrices
	 * @throws	IllegalArgumentException : if the column of first matrix is not equal to row of second 
	 * 										matrix then the multiplication is not possible
	 */
	public SparseMatrix multiplyTwoMatrix(SparseMatrix sparse) throws IllegalArgumentException{
		if(this.sparseMatrix[0][1] == sparse.sparseMatrix[0][0]){
			int[][] multiplyMatrix = new int[this.sparseMatrix[0][1]][sparse.sparseMatrix[0][0]];
			sparse = sparse.transposeOfMatrix();
			int i, j;
			for(i = 1; i < sparseMatrix.length;) {
	            int row = sparseMatrix[i][0];
	            for (j = 1; j < sparse.sparseMatrix.length;) {
	                int column = sparse.sparseMatrix[j][0];
	                int rowOfThisMatrix = i;
	                int rowOfSparseMatrix = j;
	                int sum = 0;
	                while(rowOfThisMatrix < sparseMatrix.length 
	                		&& sparseMatrix[rowOfThisMatrix][0] == row
	                		&& rowOfSparseMatrix < sparse.sparseMatrix.length
	                		&& sparse.sparseMatrix[rowOfSparseMatrix][0] == column){
	 
	                    if(sparseMatrix[rowOfThisMatrix][1] < sparse.sparseMatrix[rowOfSparseMatrix][1]){
	                    	rowOfThisMatrix++;
	                    }else if(sparseMatrix[rowOfThisMatrix][1] > sparse.sparseMatrix[rowOfSparseMatrix][1]){
	                    	rowOfSparseMatrix++;
	                    }else{
	                    	sum += sparseMatrix[rowOfThisMatrix++][2] * sparse.sparseMatrix[rowOfSparseMatrix++][2];
	                	}
	                }
	                if(sum != 0){
	                	multiplyMatrix[row][column] = sum;
	                }
	 
	                while(j < sparse.sparseMatrix.length && sparse.sparseMatrix[j][0] == column){
	                	j++;
	                }
	            }
	            while(i < sparseMatrix.length && sparseMatrix[i][0] == row){
	            	i++;
	            }
	        }
			return new SparseMatrix(multiplyMatrix);
		}else{
			throw new IllegalArgumentException("Invalid Input : The row of first matrix is not same as "
					+ "column of second matrix. Matrix multiplication is not possible "
					+ "Enter valid matrix with same order.");
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{ {3, 1, 2}, {1, 3, 4}, {2, 4, 3} };
		SparseMatrix sparse = new SparseMatrix(matrix);
		System.out.println(sparse.isSymmetric());
	}
}
