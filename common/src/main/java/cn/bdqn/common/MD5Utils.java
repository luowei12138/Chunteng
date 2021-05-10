package cn.bdqn.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;


/**
 * @Package: cn.bdqn.common
 * @Description: MD5加密
 * @Author hah
 * @Create 2021年03月23日 00时01分30秒
 */
public class MD5Utils {

    /**
     * @Author: hah
     * @Date: 2021-03-23 00:03:23
     * @Description: 添加 salt
     * @param password
     * @param salt
     * @return java.lang.String
     **/
    public static String encryptMD5(String password, String salt) {
        //将密码放入，加密
        String encryptStr = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        encryptStr = encryptStr.toUpperCase(); // 转换大写
        return addSalt(encryptStr, salt);
    }

    /**
     * @Author: hah
     * @Date: 2021-03-23 00:03:13
     * @Description: 获取加密后的字符串
     * @param encryptPas
     * @param salt
     * @return java.lang.String
     **/
    private static String addSalt(String encryptPas, String salt) {
        if (StringUtils.isEmpty(salt)) salt = "ff3e1b60";
        StringBuilder stringBuilder = new StringBuilder(encryptPas);
        stringBuilder.insert(18, salt); // 替换字符串
        return stringBuilder.toString();
    }





}
