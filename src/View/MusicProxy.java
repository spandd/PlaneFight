package View;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.*;

public class MusicProxy extends TemplateView {
    private TemplateView proxyed;
    public MusicProxy(TemplateView proxyed){
        this.proxyed = proxyed;
    }
    @Override
    public void startGame() {
        new Thread(){
            @Override
            public void run() {
                try {
                    Player player=new Player(MusicProxy.class.getResourceAsStream("/mp3/background.mp3"));
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        proxyed.startGame();
    }

    @Override
    public void paintBackground(Graphics g) {

    }

    @Override
    public void paintMePlane(Graphics g) {

    }

    @Override
    public void paintBullet(Graphics g) {

    }

    @Override
    public void paintEnemyPlane(Graphics g) {

    }
}
