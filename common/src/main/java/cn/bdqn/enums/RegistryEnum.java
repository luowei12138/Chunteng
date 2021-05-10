package cn.bdqn.enums;

/**
 * @Package: cn.bdqn.enums
 * @Description: 用户相关的枚举
 * @Author 老黄
 * @Create 2021年03月23日 01时29分45秒
 */
public enum RegistryEnum {

    USER_TYPE_ADMIN(1,"系统管理员"),
    USER_TYPE_REGISTER(2,"挂号员"),
    USER_TYPE_DOCTER(3,"门诊医师"),
    USER_TYPE_CHECKER(4,"系统收银员"),
    USER_TYPE_PHARMACY_DOCTER(5,"药房医师"),

    STATUS_NO_CONSULTATION(1,"已挂号，未问诊"),
    STATUS_BEING_CONSULTED(2,"正在问诊"),
    STATUS_END_CONSULTATION(3,"问诊结束");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    RegistryEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
