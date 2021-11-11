package uoa.assignment1.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		Game game1 = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Scanner input = new Scanner(System.in);
        int roundNo = 1;
        String action = "";
        
        
        
        while (!gameOver) {
            System.out.println("\n\n Round " + roundNo + ":");
            action = input.nextLine();        
            
            
            //check if next move should be made
            gameOver = game1.nextRound(action);
            roundNo++;
            
            //print map
            game1.gameMap.printLayout();
            
            
            
			//complete the code
		}
	}
    


}
