package cn.smile.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Main {

    public static void main(String[] args) {
        drawImage();
    }

    public static void drawImage(){
        try {
            BufferedImage buffImg = ImageIO.read(new File("in.jpg"));
            Graphics2D g = (Graphics2D) buffImg.getGraphics();

            //设置抗锯齿，防止图片或文字模糊
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //绘制图片
            ImageIcon imgIcon = new ImageIcon("in.jpg");
            Image img = imgIcon.getImage();
            g.drawImage(img,50,50,null);

            //绘制文字
            Font f = new Font("宋体",Font.PLAIN,30);
            g.setColor(Color.RED);
            g.setFont(f);
            g.drawString("我是渣渣辉",10,100);

            ImageIO.write(buffImg,"png", new File("out.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
