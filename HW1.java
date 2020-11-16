package hw1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HW1 {
    
    public static void main(String[] args) throws IOException{           
       
        Terrain.createMap();        
        
        
        boolean onGame = true;
        int turn = 1;
        String turnStr;
        File fout = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
        
        for (int i = 0; i < Config.height; i++) {
            for (int j = 0; j < Config.width; j++) {
                bw.write(Terrain.board[i][j]);
            }
            bw.write("\n");
        }          
	bw.close();         
        
        while(onGame){            
            
            if(Terrain.checkWin()){
                
                turnStr = Integer.toString(turn - 1);
                fout = new File("out" + turnStr + ".txt");
                //fout = new File("final.txt");
                fos = new FileOutputStream(fout);
                bw = new BufferedWriter(new OutputStreamWriter(fos));
                for (int i = 0; i < Config.height; i++) {
                    for (int j = 0; j < Config.width; j++) {
                        bw.write(Terrain.board[i][j]);
                    }
                    bw.write("\n");
                }
                bw.write("Game Over. " + "P " + "won the game");
                bw.close();
                onGame = false;      
                
            }
            else{
                Terrain.updateMap();
                turnStr = Integer.toString(turn);
                fout = new File("out" + turnStr + ".txt");
                fos = new FileOutputStream(fout);
                bw = new BufferedWriter(new OutputStreamWriter(fos));
                for (int i = 0; i < Config.height; i++) {
                    for (int j = 0; j < Config.width; j++) {
                        bw.write(Terrain.board[i][j]);
                    }
                    bw.write("\n");
                }
                turn++;
                bw.close();
            }
        }
    }
}