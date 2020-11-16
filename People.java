package hw1;

import java.util.Random;


public class People {
    
    
    private Position position;
    String[][] board = Terrain.board;
    
    public Position getPos(){
        return position;
    }
    
    public void setPos(Position pos){
        this.position = position;
    }
    
    /*
    public void updatePosition(Position pos, String e){
        Terrain.board[getPos().getX()][getPos().getY()] = e;
    }
    */
    
    public People(Position position){
        this.position = position;
    }
    
    public void move(int height, int width){
        Random rand = new Random();
        boolean isOk = true;
        
        do {
            int direction = rand.nextInt(4);
            switch(direction){
                case 0: // North
                    if(position.getX() != 0){
                        if(board[position.getX() - 1][position.getY()] == "0" || board[position.getX() - 1][position.getY()] == "f"){
                            Terrain.board[position.getX()][position.getY()] = "0";
                            position.setX(position.getX() - 1);
                            Terrain.board[position.getX()][position.getY()] = "p";
                        }
                        isOk = false;
                    }
                    break;
                case 1: // South
                    if(position.getX() != height - 1){
                        if(board[position.getX() + 1][position.getY()] == "0" || board[position.getX() + 1][position.getY()] == "f"){
                            Terrain.board[position.getX()][position.getY()] = "0";
                            position.setX(position.getX() + 1);
                            Terrain.board[position.getX()][position.getY()] = "p";
                        }
                        isOk = false;
                    }
                    break;
                case 2: // West
                    if(position.getY() != 0){
                        if(board[position.getX()][position.getY() - 1] == "0" || board[position.getX()][position.getY() - 1] == "f"){
                            Terrain.board[position.getX()][position.getY()] = "0";
                            position.setY(position.getY() - 1);
                            Terrain.board[position.getX()][position.getY()] = "p";
                        }
                        isOk = false;
                    }
                    break;
                case 3: // East
                    if(position.getY() != width - 1){
                        if(board[position.getX()][position.getY() + 1] == "0" || board[position.getX()][position.getY() + 1] == "f"){
                            Terrain.board[position.getX()][position.getY()] = "0";
                            position.setY(position.getY() + 1);
                            Terrain.board[position.getX()][position.getY()] = "p";
                        }
                        isOk = false;
                    }
                    break;
            }
        } while (isOk);
    }    
    
}
