package uoa.assignment1.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health = 100; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		//complete
        this.name = name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
	return this.name; 
	}

	public int getHealth() {
        /**
         * returns: the current value of characters health
         */
		return this.health;
	}

	public void setHealth(int health) {
		/**
		 * takes: integer value of health 
		 * 
		 * health is initialised as 100 (not the max value)
		 * dead characters have a health of <= 0
		 */
        this.health = health;
	}
    
    public int[] getPosition() {
        /**
         * returns the position on the map of the character
         * returns integer array of length 2
         */
        int[] pos = {this.row, this.column};
        return pos;
    }
    
    public void setPosition(int row, int column) {
        /**
         * takes: 2 integers which are the indices of the of the element of the map.layout 2d array
         * sets the position of the character on the map
         */
        this.row = row;
        this.column = column;
    }
}

