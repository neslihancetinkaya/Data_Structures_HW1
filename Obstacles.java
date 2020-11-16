package hw1;

public class Obstacles {
    private Position position;
    
    public Position getPos(){
        return position;
    }
    
    public void setPos(Position pos){
        this.position = position;
    }
    
    public Obstacles(Position position){
        this.position = position;
    }
}
