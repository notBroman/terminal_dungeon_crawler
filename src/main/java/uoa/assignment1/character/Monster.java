package uoa.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}


	public void hurtCharacter(GameCharacter character) {
		if (character.successfulDefense() == false) {
            character.setHealth(character.getHealth() - 20);
        }
        else {
            // message that attack missed 
        }
	}
   

	
	public boolean successfulDefense() {
        Random randInt = new Random();
        int d3 = randInt.nextInt(2); // roll a 2 sided dice (0-1)
        boolean defense;
        switch(d3){
            case 0: defense = true;
                break;
            default: defense = false;
                break;
        }
        return defense;
	}


	
	public String decideMove () {
		Random randInt = new Random();
        int d4 = randInt.nextInt(4); // roll a 4 sided dice (0-3 one per possible move)
        String move = "";
        switch(d4){
            case 0: 
                move = "up";
                break;
            case 1:
                move = "right";
                break;
            case 2:
                move = "down";
                break;
            case 3:
                move = "left";
                break;
            default:
                break;
        }
        return move;
	}

}
