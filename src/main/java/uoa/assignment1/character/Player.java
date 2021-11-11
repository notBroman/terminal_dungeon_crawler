package uoa.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{
    /**
     * child of GameCharacter
     * 
     * implementation of playable character
     */

	public Player(String name) {
		super(name);
	}

	
	public void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense() == false) {
            character.setHealth(character.getHealth() - 50);
        }
        else {
            // message that attack missed 
        }
	}

	
	public boolean successfulDefense() {
        Random randInt = new Random();
		int d3 = randInt.nextInt(3); // roll a 3 sided dice (0-2)
        boolean defense;
        switch(d3){
            case 0: 
                defense = true;
                break;
                
            default: 
                defense = false;
                break;
        }
        return defense;
	}

}
