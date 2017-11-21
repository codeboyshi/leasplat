package cn.shi.leasplat.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

public final class Captcha
{
    //浣跨敤鍒癆lgerian瀛椾綋锛岀郴缁熼噷娌℃湁鐨勮瘽闇�瑕佸畨瑁呭瓧浣擄紝瀛椾綋鍙樉绀哄ぇ鍐欙紝鍘绘帀浜�1,0,i,o鍑犱釜瀹规槗娣锋穯鐨勫瓧绗�
    private static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
    private static Random random = new Random();


    /**
     * 浣跨敤绯荤粺榛樿瀛楃婧愮敓鎴愰獙璇佺爜
     * @param verifySize	楠岃瘉鐮侀暱搴�
     * @return
     */
    public static String generateVerifyCode(int verifySize)
    {
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }
    /**
     * 浣跨敤鎸囧畾婧愮敓鎴愰獙璇佺爜
     * @param verifySize	楠岃瘉鐮侀暱搴�
     * @param sources	楠岃瘉鐮佸瓧绗︽簮
     * @return
     */
    private static String generateVerifyCode(int verifySize, String sources)
    {
        if(sources == null || sources.length() == 0)
        {
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++)
        {
            verifyCode.append(sources.charAt((int)(Math.random() * sources.length())));
        }
        return verifyCode.toString();
    }

    /**
     * 鐢熸垚闅忔満楠岃瘉鐮佹枃浠�,骞惰繑鍥為獙璇佺爜鍊�
     * @param w
     * @param h
     * @param outputFile
     * @param verifySize
     * @return
     * @throws IOException
     */
    private static String outputVerifyImage(int w, int h, File outputFile, int verifySize) throws Exception
    {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, outputFile, verifyCode);
        return verifyCode;
    }

    /**
     * 杈撳嚭闅忔満楠岃瘉鐮佸浘鐗囨祦,骞惰繑鍥為獙璇佺爜鍊�
     * @param w
     * @param h
     * @param os
     * @param verifySize
     * @return
     * @throws IOException
     */
    private static String outputVerifyImage(int w, int h, OutputStream os, int verifySize) throws Exception
    {
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(w, h, os, verifyCode);
        return verifyCode;
    }

    /**
     * 鐢熸垚鎸囧畾楠岃瘉鐮佸浘鍍忔枃浠�
     * @param w
     * @param h
     * @param outputFile
     * @param code
     * @throws IOException
     */
    private static void outputImage(int w, int h, File outputFile, String code) throws Exception
    {
        if(outputFile == null)
        {
            return;
        }
        File dir = outputFile.getParentFile();
        if(!dir.exists())
        {
            dir.mkdirs();
        }
        try
        {
            outputFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(outputFile);
            outputImage(w, h, fos, code);
            fos.close();
        }
        catch(IOException e)
        {
            throw e;
        }
    }

    /**
     * 杈撳嚭鎸囧畾楠岃瘉鐮佸浘鐗囨祦
     * @param w
     * @param h
     * @param os
     * @param code
     * @throws IOException
     */
    private static void outputImage(int w, int h, OutputStream os, String code) throws Exception
    {
        int verifySize = code.length();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Random rand = new Random();
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Color[] colors = new Color[5];
        Color[] colorSpaces = new Color[]
                {
                        Color.WHITE, Color.CYAN,
                        Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
                        Color.PINK, Color.YELLOW
                };
        float[] fractions = new float[colors.length];
        for(int i = 0; i < colors.length; i++)
        {
            colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];
            fractions[i] = rand.nextFloat();
        }
        Arrays.sort(fractions);

        g2.setColor(Color.GRAY);// 璁剧疆杈规鑹�
        g2.fillRect(0, 0, w, h);

        Color c = getRandColor(200, 250);
        g2.setColor(c);// 璁剧疆鑳屾櫙鑹�
        g2.fillRect(0, 2, w, h-4);

        //缁樺埗骞叉壈绾�
        Random random = new Random();
        g2.setColor(getRandColor(160, 200));// 璁剧疆绾挎潯鐨勯鑹�
        for (int i = 0; i < 20; i++)
        {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g2.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        // 娣诲姞鍣偣
        float yawpRate = 0.05f;// 鍣０鐜�
        int area = (int) (yawpRate * w * h);
        for (int i = 0; i < area; i++)
        {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        shear(g2, w, h, c);// 浣垮浘鐗囨壄鏇�

        g2.setColor(getRandColor(100, 160));
        int fontSize = h - 4;
        Font font = new Font("Algerian", Font.ITALIC, fontSize);
        g2.setFont(font);
        char[] chars = code.toCharArray();
        for(int i = 0; i < verifySize; i++)
        {
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);
            g2.setTransform(affine);
            int x = ((w-10) / verifySize) * i + 5;
            int y = h/2 + fontSize/2 - 10;
            g2.drawChars(chars, i, 1, x, y);
        }

        g2.dispose();
        ImageIO.write(image, "jpg", os);
    }

    private static Color getRandColor(int fc, int bc)
    {
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static int getRandomIntColor()
    {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb)
        {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb()
    {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++)
        {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    private static void shear(Graphics g, int w1, int h1, Color color)
    {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color)
    {
        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++)
        {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap)
            {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }
    }

    private static void shearY(Graphics g, int w1, int h1, Color color)
    {
        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++)
        {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap)
            {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }
        }
    }

    public static String generate(OutputStream os) throws Exception
    {
        String code = generateVerifyCode(4);
        outputImage(100, 35, os, code);
        return code;
    }

    public static void generate(int width, int height, String code, OutputStream os) throws Exception
    {
        outputImage(width, height, os, code);
    }

    public static String generate(int width, int height, OutputStream os) throws Exception
    {
        String code = generateVerifyCode(4);
        outputImage(width, height, os, code);
        return code;
    }

    public static void main(String[] args) throws Exception
    {
        File dir = new File("d:\\test\\");
        int w = 100, h = 35;
        for(int i = 0; i < 10; i++)
        {
            String verifyCode = Captcha.generateVerifyCode(4);
            File file = new File(dir, verifyCode + ".jpg");
            System.out.println(verifyCode);
            outputImage(w, h, file, verifyCode);

            // String code = Captcha.generate(100, 30, response.getOutputStream());
        }
    }
}
