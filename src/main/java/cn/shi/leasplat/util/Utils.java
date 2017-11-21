package cn.shi.leasplat.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具类(加盐计算)
 */
public class Utils {
	private static final String 
		SALT="石强最帅，没办法";
	
	public static String md5salt(String pwd){
		return DigestUtils.md5Hex(pwd+SALT);
	}
}


