package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sky {
    private BufferedImage[] background;
    private int x;  //横坐标
    private int y1; //第一张图片的纵坐标
    private int y2; //第二张图片的纵坐标
    private int speed; //移动速度
    private int height; //移动速度
    public Sky(){
        height = 700;
        speed = 2;
        x = 0;
        y1 = 0;
        y2 = -height;
        background = new BufferedImage[2];
        for(int i = 0;i < 2;i++){
            try {
                background[i] = ImageIO.read(Sky.class.getResourceAsStream("/img/background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void move(){
        this.y1 += this.speed;
        this.y2 += this.speed;
        if (this.y1 > this.height){
            //如果第一张图片起始y大于高度
            this.y1 = -this.height + 2;
        }
        if (this.y2 > this.height){
            //如果第一张图片起始y大于高度
            this.y2 = -this.height + 2;
        }
    }

    public BufferedImage[] getBackground() {
        return background;
    }

    public int getX() {
        return x;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
