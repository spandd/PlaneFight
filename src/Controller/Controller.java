package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private FlyObject mePlane;
    private Sky sky = new Sky();
    private List<FlyObject[]> myBulletsList = new ArrayList<>();
    private List<FlyObject> enemiesList = new ArrayList<>();
    public int makeEnemySpeed = 10;
    public int makeBulletSpeed = 5;
    public String[] enemyImageNames = {"/img/enemy1.png"};
    public String[] enemyDestroyImageNames = {"/img/enemy1_down1.png","/img/enemy1_down2.png","/img/enemy1_down3.png","/img/enemy1_down4.png"};
    public String[] meImageNames = {"/img/me1.png","/img/me2.png"};
    public String[] meDestroyImageNames = {"/img/me_destroy_1.png","/img/me_destroy_2.png","/img/me_destroy_3.png","/img/me_destroy_4.png"};
    public String[] bulletImageNames = {"/img/bullet1.png"};
    public Controller(){
        mePlane = new MePlane(3,meImageNames,meDestroyImageNames);
    }

    public void changeMePlaneBA(int index){
        chageBullitArray(index,myBulletsList,mePlane);
    }
    public void chageBullitArray(int index,List<FlyObject[]> bulletsList,FlyObject flyObject){
        if(index % makeBulletSpeed == 0){
            FlyObject[] bullets = new FlyObject[flyObject.getFireLevel()];
            for(int i = 0;i < flyObject.getFireLevel();i++){
                bullets[i] = new Bullet(flyObject.getX() + (flyObject.getImages()[0].getWidth() / (flyObject.getFireLevel() + 1) * (i + 1)),
                        flyObject.getY(),10,bulletImageNames,"up");
            }
            bulletsList.add(bullets);
        }
        for(int i = 0;i < bulletsList.size();i++){
            for(int j = 0;j < flyObject.getFireLevel();j++){
                bulletsList.get(i)[j].move();
                if(bulletsList.get(i)[j].getLifeValue() < 0){
                    bulletsList.get(i)[0].setLifeValue(-1);
                }
            }
            if (bulletsList.get(i)[0].getY() < 0 || bulletsList.get(i)[0].getLifeValue() < 0){
                bulletsList.remove(i);
            }
        }
    }
    public void chageMyPlane(){
        for(int i = 0;i < enemiesList.size();i++){
            if(isCollision(enemiesList.get(i),mePlane) && mePlane.getStatus() == 1){
                mePlane.attacked(1000);
                mePlane.setStatus(0);
            }
        }
    }
    public void chageEnemyArr(int index){
        //创建敌机
        if(index % makeEnemySpeed == 0){
            FlyObject enemies = new Enemy(1,enemyImageNames,enemyDestroyImageNames);
            enemiesList.add(enemies);
        }
        for(int i = 0;i < enemiesList.size();i++){
            if (enemiesList.get(i).getY() > Constants.windowHeight || enemiesList.get(i).getStatus() == -1){
                enemiesList.remove(i);
            }
            else {
                if(enemiesList.get(i).getLifeValue() > 0) {
                    enemiesList.get(i).move();
                }
                for(int j = 0;j < myBulletsList.size();j++){
                    for(int k = 0;k < myBulletsList.get(j).length;k++){
                        if(isCollision(enemiesList.get(i),myBulletsList.get(j)[k])){
                            new BlastDecorator(enemiesList.get(i)).attacked(myBulletsList.get(j)[k].getAttackValue());
                            myBulletsList.get(j)[k].attacked(0);
                            if(enemiesList.get(i).getLifeValue() <= 0){
                                enemiesList.get(i).setStatus(0);
                            }
                        }
                    }
                }
            }

        }
    }

    public boolean isCollision(FlyObject upFO,FlyObject downFO){
        int upFOWidth = upFO.getImages()[0].getWidth();
        int upFOHeight = upFO.getImages()[0].getHeight();
        int downFOWidth = downFO.getImages()[0].getWidth();
        int downFOHeight = downFO.getImages()[0].getHeight();
        if(upFOWidth > downFOWidth){
            if (downFO.getY() >= upFO.getY() && downFO.getY() <= upFO.getY() + upFOHeight) {
                if (downFO.getX() >= upFO.getX() && downFO.getX() + downFOWidth <= upFO.getX() + upFOWidth) {
                    return true;
                }
            }
        }
        else {
            if (upFO.getY() + upFOHeight >= downFO.getY() && upFO.getY() + upFOHeight <= downFO.getY() + downFOHeight) {
                if (upFO.getX() >= downFO.getX() && upFO.getX() + upFOWidth <= downFO.getX() + downFOWidth) {
                    return true;
                }
            }
        }
        return false;
    }
    public Sky getSky() {
        return sky;
    }

    public List<FlyObject[]> getBulletsList() {
        return myBulletsList;
    }

    public List<FlyObject> getEnemiesList() {
        return enemiesList;
    }
    public FlyObject getMePlane() {
        return mePlane;
    }

    public void setMePlane(FlyObject mePlane) {
        this.mePlane = mePlane;
    }

    public void setEnemiesList(List<FlyObject> enemiesList) {
        this.enemiesList = enemiesList;
    }

    public void setSky(Sky sky) {
        this.sky = sky;
    }

    public void setMyBulletsList(List<FlyObject[]> myBulletsList) {
        this.myBulletsList = myBulletsList;
    }

    /////////////////////////////////////////////////////////////





}
