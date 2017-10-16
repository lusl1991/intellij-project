package com.softel.model.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import sun.misc.BASE64Encoder;

/**
 * 
 * @Project  : elog
 * @ClassName   TokenProcessor
 * @Description   Create Token Util
 * @author   Administrator
 * @date   2016年11月10日
 * @Copyright: 2016 Softel Inc. All rights reserved.
 */
public class TokenProcessor {
	private TokenProcessor(){}  
    private static TokenProcessor instance = new TokenProcessor();  
    private static final SecureRandom random=new SecureRandom();
    public static TokenProcessor getInstance(){  
        return instance;  
    }

    public String generateTokeCode(){  
        String value = System.currentTimeMillis()+random.nextInt()+"";  
      //获取数据指纹，指纹是唯一的  
        try {  
            MessageDigest md = MessageDigest.getInstance("md5");  
            byte[] b = md.digest(value.getBytes());//产生数据的指纹  
            //Base64编码  
            BASE64Encoder be = new BASE64Encoder();  
            be.encode(b);  
            return be.encode(b);//制定一个编码  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
          
        return null;  
    }

}
