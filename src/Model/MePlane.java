package Model;


public class MePlane extends FlyObject{

    public MePlane(int fireLevel,String[] imageNames,String[] destoryImagesNames){
        super(150,500,100,fireLevel,imageNames,destoryImagesNames);
    }

    @Override
    public void move() {
        //跟着鼠标动
    }

    @Override
    public void attacked(int attackValue) {
        super.setLifeValue(super.getLifeValue() - attackValue);
    }
}
