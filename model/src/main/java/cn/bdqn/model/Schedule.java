package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 医生排期表(Schedule)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:09
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 795695262329785875L;

    private Long id;
    /**
     * 用户表主键ID
     */
    private Long userId;
    /**
     * 就诊科室表主键ID
     */
    private Long departmentId;
    /**
     * 就诊房间表主键ID
     */
    private Long roomId;
    /**
     * 值班时间段 1-->上午，2-->下午
     */
    private Integer sign;
    /**
     * 诊断病人数量
     */
    private Integer quantity;
    /**
     * 剩余诊断病人数量
     */
    private Integer remainingQuantity;
    /**
     * 问诊时间
     */
    private Object inquiryTime;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;

    private String doctorName;
    private String roomName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Object getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(Object inquiryTime) {
        this.inquiryTime = inquiryTime;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
