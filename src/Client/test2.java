package Client;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureRenderData;
import com.google.zxing.QRCodeUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
//        String[] res = getNum("软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,软件17005,,软件17005,软件17005,软件17005");
//        for(String a : res){
//            System.out.println(a);
//        }
        File file = new File("E:/packagemodel.docx");
        System.out.println(file.getName());
    }
    public static String[] getNum(String classes){
        String[] newClasses  = {"","",""};
        int num = 0,index = -1;
        for(int i = 0;i < classes.length();i++){
            if(num <= 3){
                index = 0;
            }
            else if(num <= 7){
                index = 1;
            }
            else{
                index = 2;
            }
            if(classes.charAt(i) == ','){
                num++;
            }
            newClasses[index] += classes.charAt(i);
        }
        return newClasses;
    }
}
