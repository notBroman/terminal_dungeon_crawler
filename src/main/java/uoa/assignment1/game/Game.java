package uoa.assignment1.game;

import uoa.assignment1.character.Monster;
import uoa.assignment1.character.GameCharacter;


public class Game {
    
    Map gameMap;
    GameLogic logic;
    
    Game (int height, int width) {
        this.gameMap = new Map(height, width);
        this.gameMap.printLayout();
        this.logic = new GameLogic();
    }
    			
    public Map getMap() {
        return this.gameMap;
    }
    
    public boolean nextRound (String input) {
        boolean cont =  false;
        Monster mob1 =(Monster) this.gameMap.characters[1];
        Monster mob2 = (Monster) this.gameMap.characters[2];
        Monster mob3 = (Monster) this.gameMap.characters[3];
        
        if (this.gameMap.characters[1].getHealth() <= 0 && this.gameMap.characters[2].getHealth() <= 0 && this.gameMap.characters[3].getHealth() <= 0) {
            cont = true;
            System.out.println("YOU HAVE WON!");
        }
        else if (this.gameMap.characters[0].getHealth() <= 0){
            cont = true;
            System.out.println("YOU HAVE DIED!");
        }
        else{
            // move player
            this.logic.moveCharacter(input, this.gameMap, this.gameMap.characters[0]);
            System.out.println(this.gameMap.characters[0].sayName() + " is moving " + input);
            // move mobs
            String mob1Move = mob1.decideMove();
            String mob2Move = mob2.decideMove();
            String mob3Move = mob3.decideMove();
            if ( mob1.getHealth() > 0){
                System.out.println(this.gameMap.characters[1].sayName() + " is moving " + mob1Move);
                this.logic.moveCharacter(mob1Move, this.gameMap, this.gameMap.characters[1]);
            }
            if (mob2.getHealth() > 0){
                System.out.println(this.gameMap.characters[2].sayName() + " is moving " + mob2Move);
                this.logic.moveCharacter(mob2Move, this.gameMap, this.gameMap.characters[2]);
            }
            if (mob3.getHealth() > 0){
                System.out.println(this.gameMap.characters[3].sayName() + " is moving " + mob3Move);
                this.logic.moveCharacter(mob3Move, this.gameMap, this.gameMap.characters[3]);
            }
        }
        
        for(GameCharacter character : this.gameMap.characters ) {
            System.out.println("Health " + character.sayName() + ": " + character.getHealth());
        }
        
        return cont;
    }
   
}