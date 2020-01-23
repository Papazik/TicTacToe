import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StartGame {
    
     private Random rand = new Random();
     private int randomChar;
     private int randomInt;
     private char playersRow;
     private char playersCol;
     private String randomChoice;
     private boolean stop = true;
     private boolean taken;
     private SetupScene scene;
     private boolean computerTaken = false;
     public static boolean notWin = true;
     private char randomChar2;
     private char randomInt2;
     
     private ArrayList<String> playerMoves = new ArrayList<>();
     private ArrayList<String> computerMoves = new ArrayList<>();
     private ArrayList<Integer> allMoves = new ArrayList<>();
	 
	 public StartGame(){
		    
		  Scanner keyboard = new Scanner(System.in);
		  
		  scene = new  SetupScene();
	 while(notWin){
		 
		  do{
			    
			    taken = false;
			    System.out.println();
			    System.out.println("Player Move (X): ");
                String input = keyboard.nextLine();
                
                
                if(input.startsWith("A") || input.startsWith("B") || input.startsWith("C"))
                  if(input.endsWith("1") || input.endsWith("2") || input.endsWith("3"))
                	   stop = false;
                
                if(stop)
                	System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
                
                for(String s : playerMoves)
                	if(s.equals(input))
                	{
                		System.out.println("The space entered is already taken.");
                		taken = true;
                		break;
                	}
                
                
                
                playersCol = input.charAt(0);
                playersRow = input.charAt(1);
                
                playerMoves.add(input);
               
                
               
			  
		  }while(stop || taken);
		  
		  
     
		 scene.drawChoice(playersRow, playersCol, 'P');
		 
	  do{ 
		  
		  computerTaken = false;
		  randomChar = rand.nextInt(3);
		  randomInt = rand.nextInt(3);
		  
		  
		  
		if(randomChar == 0)
		   randomChoice = "A" + Integer.toString(randomInt+1);
		else if(randomChar == 1)
		   randomChoice = "B" + Integer.toString(randomInt+1);
		else
		   randomChoice = "C" + Integer.toString(randomInt+1);
		
		
		  for(String s : playerMoves)
			 if(s.equals(randomChoice))
			 {
				 computerTaken = true;
				 break;
			 }
		  
		  for(String s : computerMoves)
			if(s.equals(randomChoice))
			{
				computerTaken = true;
				break;
			 }
		  
		
		  
		  computerMoves.add(randomChoice);
		
	  }while(computerTaken);
		
	  
	  System.out.println("Computer Move (O): " + randomChoice);
	  
	  if(randomChar == 0)
		  randomChar2 = 'A';
	  else if(randomChar == 1)
		  randomChar2 = 'B';
	  else
		  randomChar2 = 'C';
	  
	  if(randomInt == 0)
		 randomInt2 = '1';
	  else if(randomInt == 1)
		 randomInt2 = '2';
	  else
		 randomInt2 = '3';
	  
	  scene.drawChoice(randomInt2,randomChar2,'O');
		 
	
	 } 
	 
  } 
	 
}
