package cn.shi.leasplat.util;

public class GetRand {
	public static String getRand(){
        StringBuffer rand = new StringBuffer(24);
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for(int i = 0;i<16;i++)
        {
            rand.append(chars.charAt((int)(Math.random() * chars.length())));
        }
        return rand.toString();
    }
}
