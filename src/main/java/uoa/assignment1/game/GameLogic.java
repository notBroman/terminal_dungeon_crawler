package uoa.assignment1.game;

import java.util.Scanner;
import java.io.*;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		int[] charPos = character.getPosition();
        int[] mapSize = gameMap.getSize();
        
        switch(input.toLowerCase()){
            case "up":
                if (charPos[0] > 0) {
                    moveUp(gameMap, character);
                }
                else{
                    System.out.println("You can't go up. You lose a move.");
                }
                break;

            case "down":
                if (charPos[0] < mapSize[0]) {
                    moveDown(gameMap, character);
                }
                else{
                    System.out.println("You can't go down. You lose a move.");
                }
                break;

            case "left":
                if (charPos[1] > 0) {
                    moveLeft(gameMap, character);
                }
                else{
                    System.out.println("You can't go left. You lose a move.");
                }
                break;

            case "right":
                if (charPos[1] < mapSize[1]) {
                    moveRight(gameMap, character);
                }
                else{
                    System.out.println("You can't go right. You lose a move.");
                }
                break;

            default:
                System.out.println("Use only keywords up, down, left, right");
        }

        
	}
    
    private static void moveUp(Map gameMap, GameCharacter character){
        int[] charPos = character.getPosition();
        
        if(gameMap.layout[charPos[0] - 1][charPos[1]] != ".") {
            if (gameMap.layout[charPos[0]][charPos[1]] == "*" && gameMap.layout[charPos[0] - 1][charPos[1]] == "%") {
                // hurt monster above player
                GameCharacter enemy = gameMap.getCharacterAtLocation(charPos[0] - 1, charPos[1]);
                if (enemy != null){
                    character.hurtCharacter(enemy);
                    if(enemy.getHealth() <= 0){
                        gameMap.layout[enemy.getPosition()[0]][enemy.getPosition()[1]] = "x";
                    } else {
                        // nothing to do
                    }
                }
            } 
            else if (gameMap.layout[charPos[0] - 1][charPos[1]] == "x"){
                System.out.println("Character already dead");
            }
            else if (gameMap.layout[charPos[0]][charPos[1]] == "%" && gameMap.layout[charPos[0] - 1][charPos[1]] == "*") {
                // hurt player above monster
                character.hurtCharacter(gameMap.characters[0]);
            }
            else {
                System.out.println("Monster already there so can't move");
            }
        }
        else {
            int[] playerPos = character.getPosition();
            gameMap.layout[playerPos[0]][playerPos[1]] = ".";

            character.setPosition(playerPos[0] - 1, playerPos[1]);
            playerPos = character.getPosition();
            gameMap.updateLayout();
        }
    }
	
    private static void moveDown(Map gameMap, GameCharacter character){
        int[] charPos = character.getPosition();
        
        if(gameMap.layout[charPos[0] + 1][charPos[1]] != ".") {
            if (gameMap.layout[charPos[0]][charPos[1]] == "*" && gameMap.layout[charPos[0] + 1][charPos[1]] == "%") {
                // hurt monster below player
                GameCharacter enemy = gameMap.getCharacterAtLocation(charPos[0] + 1, charPos[1]);
                if (enemy != null){
                    character.hurtCharacter(enemy);
                    if(enemy.getHealth() <= 0){
                        gameMap.layout[enemy.getPosition()[0]][enemy.getPosition()[1]] = "x";
                    } else {
                        // nothing to do
                    }
                }
            }
            else if (gameMap.layout[charPos[0] + 1][charPos[1]] == "x"){
                System.out.println("Character already dead");
            }
            else if (gameMap.layout[charPos[0]][charPos[1]] == "%" && gameMap.layout[charPos[0] + 1][charPos[1]] == "*") {
                // hurt player below monster
                character.hurtCharacter(gameMap.characters[0]);
            }
            else {
                System.out.println("Monster already there so can't move");
            }
        }
        else {
            int[] playerPos = character.getPosition();
            gameMap.layout[playerPos[0]][playerPos[1]] = ".";

            character.setPosition(playerPos[0] + 1, playerPos[1]);
            playerPos = character.getPosition();
            gameMap.updateLayout();
        }
    }
    
    private static void moveLeft(Map gameMap, GameCharacter character){
        int[] charPos = character.getPosition();
        
        if(gameMap.layout[charPos[0]][charPos[1] - 1] != ".") {
            if (gameMap.layout[charPos[0]][charPos[1]] == "*" && gameMap.layout[charPos[0]][charPos[1] - 1] == "%") {
                // hurt monster to left of player
                GameCharacter enemy = gameMap.getCharacterAtLocation(charPos[0], charPos[1] - 1);
                if (enemy != null){
                    character.hurtCharacter(enemy);
                    if(enemy.getHealth() <= 0){
                        gameMap.layout[enemy.getPosition()[0]][enemy.getPosition()[1]] = "x";
                    } else {
                        // nothing to do
                    }
                }
            } 
            else if (gameMap.layout[charPos[0]][charPos[1]] == "%" && gameMap.layout[charPos[0]][charPos[1] - 1] == "*") {
                // hurt player to left of monster
                character.hurtCharacter(gameMap.characters[0]);
            }
            else if (gameMap.layout[charPos[0]][charPos[1] - 1] == "x"){
                System.out.println("Character already dead");
            }
            else {
                System.out.println("Monster already there so can't move");
            }
        }
        else {
            int[] playerPos = character.getPosition();
            gameMap.layout[playerPos[0]][playerPos[1]] = ".";

            character.setPosition(playerPos[0], playerPos[1] - 1);
            playerPos = character.getPosition();
            gameMap.updateLayout();
        }
    }
    
    private static void moveRight(Map gameMap, GameCharacter character){
        int[] charPos = character.getPosition();
        
        if(gameMap.layout[charPos[0]][charPos[1] + 1] != ".") {
            if (gameMap.layout[charPos[0]][charPos[1]] == "*" && gameMap.layout[charPos[0]][charPos[1] + 1] == "%") {
                // hurt monster to right of player
                GameCharacter enemy = gameMap.getCharacterAtLocation(charPos[0], charPos[1] + 1);
                if (enemy != null){
                    character.hurtCharacter(enemy);
                    if(enemy.getHealth() <= 0){
                        gameMap.layout[enemy.getPosition()[0]][enemy.getPosition()[1]] = "x";
                    } else {
                        // nothing to do
                    }
                }
            } 
            else if (gameMap.layout[charPos[0]][charPos[1]] == "%" && gameMap.layout[charPos[0]][charPos[1] + 1] == "*") {
                // hurt player to right of monster
                character.hurtCharacter(gameMap.characters[0]);
            }
            else if (gameMap.layout[charPos[0]][charPos[1] + 1] == "x"){
                System.out.println("Character already dead");
            }
            else {
                System.out.println("Monster already there so can't move");
            }
        }
        else {
            int[] playerPos = character.getPosition();
            gameMap.layout[playerPos[0]][playerPos[1]] = ".";

            character.setPosition(playerPos[0], playerPos[1] + 1);
            playerPos = character.getPosition();
            gameMap.updateLayout();
        }
    }
}
