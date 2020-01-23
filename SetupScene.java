

public class SetupScene {
	

	private char[][] board = { {' ', ' ', ' ', 'A', ' ', 'B', ' ', 'C'},
	                           {'1', '|', ' ', '|', ' ', '|', ' ', '|'},
	                           {'2', '|', ' ', '|', ' ', '|', ' ', '|'},
	                           {'3', '|', ' ', '|', ' ', '|', ' ', '|'},
	};
	
	private boolean found;
	private char whoWon = 'N';
    private int tied = 0;
	private char end;
	
	public SetupScene(){
		
		
		  for(int i = 0; i < 4; i++)
		  { 
			  found = true;
			    for(int j = 0; j < 8; j++)
			    {
 				
				    if(board[i][j] == '|' && found)
				    {
					     System.out.print(" "+ board[i][j]);
					     found = false;
				    }
				    else
					    System.out.print(board[i][j]);
				  
				    if(j == 7)
					    System.out.println();
				  

			   }
		
		  }
		
		
	}
	
	public void drawChoice(char row, char col, char who){
		
		
		
		 int row2 = Character.getNumericValue(row);
		 
		 if(who == 'P'){
			 
			 if(col == 'A')
				 board[row2][3-1] = 'X';
			 else if(col == 'B')
				 board[row2][5-1] = 'X';
			 else
				 board[row2][7-1] = 'X';
			 
			 printBoardScene();
			  
		 }
		 else
		 {
			 
			 if(col == 'A')
				 board[row2][3-1] = 'O';
			 else if(col == 'B')
				 board[row2][5-1] = 'O';
			 else
				board[row2][7-1] = 'O';
			 
			 printBoardScene();
			  
		 }
		
		
	}
	
	
	public void printBoardScene(){
		
		
		end = checkIfWon();
		
		for(int i = 0; i < 4; i++)
		  { 
			  found = true;
			    for(int j = 0; j < 8; j++)
			    {
				
				    if(board[i][j] == '|' && found)
				    {
					     System.out.print(" "+ board[i][j]);
					     found = false;
				    }
				    else
					    System.out.print(board[i][j]);
				  
				    if(j == 7)
					    System.out.println();
				    
			   }
		
		  }	
		
		if(end == 'X')
		  {
			 System.out.println("You Win!");
			 System.exit(0);
		  }
		else if(end == 'O')
		{  
			System.out.println("You Lost!");
			System.exit(0);
		}
		else if(end == 'T'){
		  
			System.out.println("Tied!");
			System.exit(0);
		}
	}
	
	
	public char checkIfWon(){
		
		
		 
		 if(board[1][1] == board[1][2] && board[1][2] == board[1][3])
			   whoWon = board[1][3]; 
		
		 for(int i = 1; i <= 3; i++)
			if(board[i][2] == board[i][4] && board[i][4] == board[i][6])
			     whoWon = board[i][6];
				 
			 
		 for(int j = 2; j <=6; j+=2)
		   if(board[1][j] == board[2][j] && board[2][j] == board[3][j])
			   whoWon = board[3][j];
		 
		 if(board[1][2] == board[2][4] && board[2][4] == board[3][6])
			   whoWon = board[3][6]; 
		 
		 if(board[3][2] == board[2][4] && board[2][4] == board[1][6])
			   whoWon = board[1][6]; 
		 
		 tied ++;
		
		 
		
		 
		 if(whoWon == 'X')
		 {
			  
			   return 'X';
		 }
		 else if(whoWon == 'O'){
			 
			 
			 return 'O';
		 }
		 else if(tied == 9){
			 
			
			 return 'T';
		 }
			 
		 
		 return 'N';
		
	}
	 
     
}
