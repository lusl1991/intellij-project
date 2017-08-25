package com.softel.model.utils;

import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * 邮政编码
     * @param code
     * @return
     */
    public static Boolean isPostCode(String code){
        return Pattern.compile("^[1-9]\\d{5}$").matcher(code).find();
    }

    /**
     * 邮箱
     * @param email
     * @return
     */
    public static Boolean isEmail(String email){
        return Pattern.compile("^[a-zA-Z]+[0-9]*@(([a-zA-z0-9]-*)+.){1,3}[a-zA-z-]+$").matcher(email).find();
    }

    /**
     * 身份证
     * @param id
     * @return
     */
    public static Boolean isIDCard(String id){
        return Pattern.compile("^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$").matcher(id).find();
    }

    /**
     * 密码强度校验（8-10位大小写字母和数字）
     * @param password
     * @return
     */
    public static Boolean passwordStrength(String password){
        return Pattern.compile("^(?=.\\d)(?=.[a-z](?=.*[A-Z]).{8,10}$)").matcher(password).find();
    }

}
