package Model;


public class Enemy extends FlyObject{
    private int enemyDestroyIndex = 0;
    public Enemy(int fireLevel,String[] imageNames,String[] destroyImagesNames){
        super(10,100,fireLevel,imageNames,destroyImagesNames);
    }

    @Override
    public void move() {
        super.setY(super.getY() + super.getSpeed());
    }

    @Override
    public void attacked(int attackValue) {
        super.setLifeValue(super.getLifeValue() - attackValue * 10);
    }


}
