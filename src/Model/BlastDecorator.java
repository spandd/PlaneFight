package Model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class BlastDecorator extends SoundDecorator {
    public BlastDecorator(FlyObject enemy){
        this.enemy = enemy;
    }
    @Override
    public void move() {
        //.........................
    }

    @Override
    public void attacked(int attackValue) {
        super.attacked(attackValue);
        addblastDecorator();
    }
    public void addblastDecorator(){
        new Thread(){
            @Override
            public void run() {
                try {
                    Player player=new Player(BlastDecorator.class.getResourceAsStream("/mp3/blast.mp3"));
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
