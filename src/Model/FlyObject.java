package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public abstract class FlyObject{
    private int x;
    private int y;
    private int speed;
    private int lifeValue;
    private int fireLevel;
    private int attackValue;
    private int status;
    private int DestroyIndex;
    private BufferedImage[] images;
    private BufferedImage[] destroyImages;
    FlyObject(){

    }
    //我机的构造方法
    FlyObject(int x,int y,int lifeValue,int fireLevel,String[] imageNames,String[] destroyImagesNames){
        status = 1;
        this.x = x;
        this.y = y;
        this.lifeValue = lifeValue;
        this.fireLevel = fireLevel;
        this.images = new BufferedImage[imageNames.length];
        this.destroyImages = new BufferedImage[destroyImagesNames.length];
        try {
            for(int i = 0;i < imageNames.length;i++){
                this.images[i] = ImageIO.read(this.getClass().getResourceAsStream(imageNames[i]));
            }
            for(int i = 0;i < destroyImagesNames.length;i++){
                this.destroyImages[i] = ImageIO.read(this.getClass().getResourceAsStream(destroyImagesNames[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //敌机的构造方法
    FlyObject(int speed,int lifeValue,int fireLevel,String[] imageNames,String[] destroyImagesNames){
        status = 1;
        DestroyIndex = 0;
        this.speed = speed;
        this.lifeValue = lifeValue;
        this.fireLevel = fireLevel;
        this.images = new BufferedImage[imageNames.length];
        this.destroyImages = new BufferedImage[destroyImagesNames.length];
        try {
            for(int i = 0;i < imageNames.length;i++){
                this.images[i] = ImageIO.read(this.getClass().getResourceAsStream(imageNames[i]));
            }
            for(int i = 0;i < destroyImagesNames.length;i++){
                this.destroyImages[i] = ImageIO.read(this.getClass().getResourceAsStream(destroyImagesNames[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = new Random().nextInt(Constants.windowWidth - this.images[0].getWidth());
        this.y = -this.images[0].getHeight();
    }
    //子弹的构造方法
    FlyObject(int x,int y,int speed,int lifeValue,int attackValue,String[] imageNames){
        status = 1;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.images = new BufferedImage[imageNames.length];
        try {
            for(int i = 0;i < imageNames.length;i++){
                this.images[i] = ImageIO.read(this.getClass().getResourceAsStream(imageNames[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //不同的移动方法
    public abstract void move();
    public abstract void attacked(int attackValue);
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFireLevel() {
        return fireLevel;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStatus() {
        return status;
    }

    public BufferedImage[] getImages() {
        return images;
    }

    public BufferedImage[] getDestroyImages() {
        return destroyImages;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAttackValue(int aggressivity) {
        this.attackValue = aggressivity;
    }

    public void setFireLevel(int fireLevel) {
        this.fireLevel = fireLevel;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDestroyIndex() {
        return DestroyIndex;
    }

    public void setDestroyIndex(int destroyIndex) {
        DestroyIndex = destroyIndex;
    }
}
