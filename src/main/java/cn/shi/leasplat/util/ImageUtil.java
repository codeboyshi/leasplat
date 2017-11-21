package cn.shi.leasplat.util;

/**
 * Created by shiqiang on 2017/2/7.
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.*;

//TODO:此处留在网站最后处理，，这里是头像的工具类，后期如果有时间加头像时可以用
public class ImageUtil {

    public static BufferedImage resize(BufferedImage image,int newWidth,int newHeight){
        Image resizedImage = image.getScaledInstance( newWidth, newHeight, Image.SCALE_SMOOTH);
        Image temp = new ImageIcon(resizedImage).getImage();
        BufferedImage bufferedImage = new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, newWidth, newHeight);
        g.drawImage(temp, 0, 0, null);
        g.dispose();
        float softenFactor = 0.05f;
        float[] softenArray = { 0, softenFactor, 0, softenFactor,
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);
        return bufferedImage;
    }

    //缂╂斁鍥剧墖
    public static BufferedImage resize(InputStream is, OutputStream os,int newWidth,int newHeight)throws IOException{
        BufferedImage image = ImageIO.read(is);
        return resize(image,newWidth,newHeight);
    }
    public static BufferedImage resize(File fileImage,int newWidth,int newHeight) throws IOException{
       BufferedImage bufferedImage = ImageIO.read(fileImage);
       return resize(bufferedImage,newWidth,newHeight);
    }

    public static void roundCorner(BufferedImage image, OutputStream os, int radius) throws IOException{
//        BufferedImage image = bufferedImage;
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();

        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, radius, radius));

        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        ImageIO.write(output, "PNG", os);
    }

    //鍦嗗舰鍥剧墖
    public static void roundCorner(InputStream is, OutputStream os, int radius) throws IOException
    {
        BufferedImage image = ImageIO.read(is);
        roundCorner(image,os,radius);
    }

    //鎴彇
    public static BufferedImage crop(InputStream is,int left,int top,int width,int height) throws IOException
    {
        return crop(ImageIO.read(is), left, top, width, height);
    }

    public static void crop(InputStream is, OutputStream os, int left, int top, int width, int height) throws IOException
    {
        BufferedImage out = crop(is, left, top, width, height);
        ImageIO.write(out, "PNG", os);
    }

    public static BufferedImage crop(BufferedImage source, int left, int top, int width, int height)
    {
        return source.getSubimage(left, top, width, height);
    }



    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("D:\\abc.png"));
        FileOutputStream fos = new FileOutputStream(new File("D:\\abczq.png"));
//        roundCorner(fis,fos,8000);
        // roundCorner(fis,fos,0,0,100,100);
//        crop(fis,fos,0,0,30,30);
        resize(fis,fos,800,800);
    }
}