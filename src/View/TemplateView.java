package View;

import Controller.Controller;
import Model.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class TemplateView extends JPanel  {
    public Controller controller;
    private boolean mouseStatus;
    public int GameStatus = 1;
    public void templateMethod(TemplateView mainView){
        listen();
        MusicProxy musicProxy = new MusicProxy(mainView);
        musicProxy.startGame();
    }
    abstract void startGame();
    abstract void paintBackground(Graphics g); //画背景
    abstract void paintMePlane(Graphics g);    //画我方飞机
    abstract void paintBullet(Graphics g);    //画子弹
    abstract void paintEnemyPlane(Graphics g); //画敌机
    void paintGameOver(Graphics g){
        try {
            BufferedImage image = ImageIO.read(TemplateView.class.getResourceAsStream("/img/gameover.png"));
            g.drawImage(image,(Constants.windowWidth - image.getWidth()) / 2, Constants.windowHeight / 3,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void paint(Graphics g) {
        if(controller != null){
            if(GameStatus == 0){
                paintBackground(g);
            }
            else if(GameStatus == 1){
                paintBackground(g);
                paintMePlane(g);
                paintBullet(g);
                paintEnemyPlane(g);
            }
            else if(GameStatus == 3){
                paintBackground(g);
                paintGameOver(g);
            }

        }


    }
    public void listen(){
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseStatus = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseStatus = false;
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                if(mouseStatus && controller != null){
                    controller.getMePlane().setX(e.getX() - 51);
                    controller.getMePlane().setY(e.getY() - 63);
                }
            }
        };
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
    }

}
