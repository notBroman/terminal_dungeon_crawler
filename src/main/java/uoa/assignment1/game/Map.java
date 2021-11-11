package uoa.assignment1.game;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Monster;
import uoa.assignment1.character.Player;

public class Map {

  public String[][] layout;
  public GameCharacter[] characters;
 
  Map (int height, int width) {
      this.characters = new GameCharacter[4];
      this.layout = new String[height][width];
      initialiseCharacters(height, width);
      initialiseArray();
      
  }
  
  private void initialiseArray() {
      updateLayout();
  }
    
  private void initialiseCharacters(int height, int width) {
      /**
       * sets the starting point of all characters
       * there are always 4 game characters, they are saved in this.characters[]
       * Player: 
       * index 0 in characters[]
       * starts in bottom right corner
       * 
       * Enemies:
       * indices 1-3 in characters[]
       * index 1: starts in top right corner
       * index 2: starts in bottom left corner
       * index 3: starts in top left corner
       */
      this.characters[0] = new Player("Player1");
      this.characters[0].setPosition(height - 1, width - 1);
      
      this.characters[1] = new Monster("Monster1");
      this.characters[1].setPosition(0, width - 1);
      
      this.characters[2] = new Monster("Monster2");
      this.characters[2].setPosition(height - 1 , 0);
      
      this.characters[3] = new Monster("Monster3");
      this.characters[3].setPosition(0, 0);
      
      System.out.print(this.characters[0].row);
  }
    
  public void printLayout() {
      for(int i = 0; i < this.layout.length; i++){
          for(int j = 0; j < this.layout[i].length ; j++){
              System.out.print(this.layout[i][j]);
          }
          System.out.print("\n");
      }
   }
    
   public int[] getSize() {
       /**
        * returns the maximum index of both dimension
        */
       int[] size = {this.layout.length - 1, this.layout[0].length - 1};
       return size;
   }
    
   public void updateLayout() {
       for (int k = 0; k < 4; k++){
          int[] pos = this.characters[k].getPosition();
          switch(k){
              case 0:
                  
                  this.layout[pos[0]][pos[1]] = "*";
                  break;
              default:
                  if( characters[k].getHealth() <= 0 ){
                      this.layout[pos[0]][pos[1]] = "x";
                  } else {
                      this.layout[pos[0]][pos[1]] = "%";
                  }
                  break;
          }
          
      }
      for(int i = 0; i < this.layout.length; i++){
          for(int j = 0; j < this.layout[i].length ; j++){
              if (this.layout[i][j] != "*" && this.layout[i][j] != "%" && this.layout[i][j] != "x"){
                  this.layout[i][j] = ".";
              }
          }
      }
   }
    
   public GameCharacter getCharacterAtLocation(int row, int column) {
       for(GameCharacter c1 : this.characters) {
           int[] pos = {row, column};
           if(c1.getPosition()[0] == pos[0] && c1.getPosition()[1] == pos[1]) {
               return c1;
           } else {
               continue;
           }
       }
       return null;
   }
}
