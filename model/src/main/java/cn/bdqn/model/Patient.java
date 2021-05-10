package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 病人表(Patient)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:06
 */
public class Patient implements Serializable {
    private static final long serialVersionUID = -86228594477735991L;

    private Long id;
    /**
     * 病人姓名
     */
    private String name;
    /**
     * 出生日期
     */
    private Object birthday;
    /**
     * 性别 1-->女性，2-->男性
     */
    private Integer sex;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 是否有医保卡 1-->没有，2-->有
     */
    private Integer isMedicare;
    /**
     * 医保卡号
     */
    private String idMedicare;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getIsMedicare() {
        return isMedicare;
    }

    public void setIsMedicare(Integer isMedicare) {
        this.isMedicare = isMedicare;
    }

    public String getIdMedicare() {
        return idMedicare;
    }

    public void setIdMedicare(String idMedicare) {
        this.idMedicare = idMedicare;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}
