package hw1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Terrain {
      
    static int height;
    static int width;
    static String [][] board;
    static ArrayList<People> people; 
    static Position f;
    
    public static void createMap() throws FileNotFoundException, IOException{
        Config.readConfig();
        
        height = Config.height;
        width = Config.width;
        int randomHeight;
        int randomWidth;
        int numberofpeople = Config.numberofpeople;
        int numberofobstacles = Config.numberofobstacles;
        
        Position pos;
        People p;
        Random rand = new Random();
        board = new String[height][width];             
        people = new ArrayList<>();
        // Create empty map
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = "0";
            }
        }    
                
        // Add finish point to map
        randomHeight = rand.nextInt(height);
        randomWidth = rand.nextInt(width);   
        board[randomHeight][randomWidth] = "f";  
        f = new Position(randomHeight,randomWidth);
        
        
        // Add people to map
        while(numberofpeople > 0){
            randomHeight = rand.nextInt(height);
            randomWidth = rand.nextInt(width);
            if(board[randomHeight][randomWidth] == "0"){
                pos = new Position(randomHeight,randomWidth);
                board[randomHeight][randomWidth] = "p";
                p = new People(pos);
                people.add(p);
                //System.out.println("POS: " + p.getPos().getX());
                numberofpeople--;
            }
        }
        
        // Add obstacles to map
        while(numberofobstacles > 0){
            randomHeight = rand.nextInt(height);
            randomWidth = rand.nextInt(width);
            if(board[randomHeight][randomWidth] == "0"){
                pos = new Position(randomHeight,randomWidth);
                board[randomHeight][randomWidth] = "1";
                Obstacles o = new Obstacles(pos); 
                numberofobstacles--;
            }
        }     
       
    }
    
    public static void updateMap(){
        for(People p : people){
            p.move(height, width);
        }
    }
    
    public static boolean checkWin(){
        for(People p : people){
            if(p.getPos().getX() == f.getX() && p.getPos().getY() == f.getY()){
                System.out.println("P won!");
                return true;
            }
        }
        return false;
    }
}
