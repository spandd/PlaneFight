package View;

import Controller.Controller;
import Model.Constants;
import Model.FlyObject;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainView extends TemplateView {
    private int index = 0;
    public MainView(){
        controller = new Controller();
    }

    @Override
    public void startGame() {
        listen();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                controller.getSky().move();
                if (controller.getMePlane().getStatus() == 1){
                    index++;
                    controller.chageEnemyArr(index);
                    controller.changeMePlaneBA(index);
                    controller.chageMyPlane();
                }
                else if(controller.getMePlane().getStatus() == -1){
                    controller.getMePlane().setStatus(1);
                    controller.getMePlane().setLifeValue(100);
                    GameStatus = 3;
                }
                repaint();
            }
        }, Constants.delay, Constants.period);
    }

    @Override
    public void paintBackground(Graphics g) {
        g.drawImage(controller.getSky().getBackground()[0],controller.getSky().getX(),controller.getSky().getY1(),null);
        g.drawImage(controller.getSky().getBackground()[1],controller.getSky().getX(),controller.getSky().getY2(),null);

    }

    @Override
    public void paintMePlane(Graphics g) {
        if (controller.getMePlane().getStatus() == 0) {
            g.drawImage(controller.getMePlane().getDestroyImages()[controller.getMePlane().getDestroyIndex()], controller.getMePlane().getX(), controller.getMePlane().getY(), null);
            controller.getMePlane().setDestroyIndex(controller.getMePlane().getDestroyIndex() + 1);
            if (controller.getMePlane().getDestroyIndex() == 4) {
                controller.getMePlane().setStatus(-1);
            }
        }
        else if(controller.getMePlane().getStatus() == 1){
            g.drawImage(controller.getMePlane().getImages()[new Random().nextInt(2)],controller.getMePlane().getX(),controller.getMePlane().getY(),null);
        }

    }

    @Override
    public void paintBullet(Graphics g) {
        List<FlyObject[]> blist = controller.getBulletsList();
        for(int i = 0;i < blist.size();i++){
            FlyObject[] bullets = blist.get(i);
            for(int j = 0;j < controller.getMePlane().getFireLevel();j++){
                if(bullets[j].getY() == controller.getMePlane().getY()){
                    bullets[j].setX(controller.getMePlane().getX() + (50 * j));
                }
                g.drawImage(bullets[j].getImages()[0],bullets[j].getX(),bullets[j].getY(),null);
            }
        }
    }

    @Override
    public void paintEnemyPlane(Graphics g) {
        List<FlyObject> enemiesList = controller.getEnemiesList();
        for(int i = 0;i < enemiesList.size();i++) {
            if (enemiesList.get(i).getStatus() == 0) {
                g.drawImage(enemiesList.get(i).getDestroyImages()[enemiesList.get(i).getDestroyIndex()], enemiesList.get(i).getX(), enemiesList.get(i).getY(), null);
                enemiesList.get(i).setDestroyIndex(enemiesList.get(i).getDestroyIndex() + 1);
                if (enemiesList.get(i).getDestroyIndex() == 4) {
                    enemiesList.get(i).setStatus(-1);
                }
            }
            else {
                g.drawImage(enemiesList.get(i).getImages()[0], enemiesList.get(i).getX(), enemiesList.get(i).getY(), null);
            }
        }
    }
}
