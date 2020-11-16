package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Config {   
    
    static int height;
    static int width;
    static int numberofpeople;
    static int numberofobstacles;
    
    public static void readConfig(){
                
        height = 0;
        width = 0;
        numberofpeople = 0;
        numberofobstacles = 0;
        
        File file = new File("var.cfg");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[1]);
            line = br.readLine();
            width = Integer.parseInt(line.split(" ")[1]);
            line = br.readLine();
            numberofpeople = Integer.parseInt(line.split(" ")[1]);
            line = br.readLine();
            numberofobstacles = Integer.parseInt(line.split(" ")[1]);
            br.close();
            
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
