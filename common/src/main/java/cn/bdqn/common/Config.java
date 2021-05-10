package cn.bdqn.common;

/**
 * @Package: cn.bdqn.common
 * @Description: 配置存储位置
 * @Author hah
 * @Create 2021年03月22日 23时48分18秒
 */
public class Config {

    public final static String USER_SESSION = "userSession";
    public static final String SESSION_LOGIN_USER = "session_user";
    public static final String SESSION_USER_ROLES_ID = "session_user_roles_id";
    //public static final String SESSION_IMAGER_DEFAULT = "/webapp/statics/images/img1.jpg";
    public static final String SESSION_IMAGER_DEFAULT = "M:/ZZZ/SSM/Chunteng/web/src/main/webapp/statics/images/img1.jpg";

    /** 上传文件大小上限 */
    public static final Integer FILE_SIZE = 5242880;

    /** 文件格式 */
    public static final String FILE_JPG = "jpg";
    public static final String FILE_PNG = "png";
    public static final String FILE_JEPG = "jepg";
    public static final String FILE_PNEG = "pneg";
    public static final String FILE_JPEG = "jpeg";

    /** 挂号费 */
    public static final Integer REGISTRY_FEE = 50;
    /** 未使用医保-医保报销额 */
    public static final Integer REGISTRY_NO_MEDICARE_FEE = 0;
    /** 使用医保-医保报销额：报销80% */
    public static final Integer REGISTRY_MEDICARE_FEE = 40;
    /** 使用医保标识 */
    public static final String SIGN_MEDICARE = "medicare";


}
