package Model;



public class Bullet extends FlyObject {
    private String direction;
    public Bullet(int x,int y,int attackValue, String[] imageNames,String direction) {
        super(x,y,10,10,attackValue,imageNames);
        this.direction = direction;
    }

    @Override
    public void move() {
        if(this.direction.equals("up")){
            super.setY(super.getY() - super.getSpeed());
        }
        else if(this.direction.equals("down")){
            super.setY(super.getY() + super.getSpeed());
        }
    }

    @Override
    public void attacked(int attackValue) {
        super.setLifeValue(-1);
    }

}