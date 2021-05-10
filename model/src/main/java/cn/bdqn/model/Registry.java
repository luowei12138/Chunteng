package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 挂号单表(Registry)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:08
 */
public class Registry implements Serializable {

    private static final long serialVersionUID = 683005951724672895L;

    private Long id;
    /**
     * 病人表主键ID
     */
    private Long patientId;
    /**
     * 排期表主键ID
     */
    private Long scheduleId;
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
     * 挂号单状态 1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束
     */
    private Integer status;
    /**
     * 挂号费(￥)
     */
    private Double fee;
    /**
     * 实际支付挂号费(￥)
     */
    private Double payFee;
    /**
     * 医保报销费(￥)
     */
    private Double medicareFee;
    /**
     * 是否使用医保卡 1-->未使用，2-->使用
     */
    private Integer isMedicare;
    /**
     * 挂号时间
     */
    private Date registryTime;
    /**
     * 医生问诊时间
     */
    private Date consultationTime;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getPayFee() {
        return payFee;
    }

    public void setPayFee(Double payFee) {
        this.payFee = payFee;
    }

    public Double getMedicareFee() {
        return medicareFee;
    }

    public void setMedicareFee(Double medicareFee) {
        this.medicareFee = medicareFee;
    }

    public Integer getIsMedicare() {
        return isMedicare;
    }

    public void setIsMedicare(Integer isMedicare) {
        this.isMedicare = isMedicare;
    }

    public Date getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(Date registryTime) {
        this.registryTime = registryTime;
    }

    public Date getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Date consultationTime) {
        this.consultationTime = consultationTime;
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

    @Override
    public String toString() {
        return "Registry{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", scheduleId=" + scheduleId +
                ", userId=" + userId +
                ", departmentId=" + departmentId +
                ", roomId=" + roomId +
                ", status=" + status +
                ", fee=" + fee +
                ", payFee=" + payFee +
                ", medicareFee=" + medicareFee +
                ", isMedicare=" + isMedicare +
                ", registryTime=" + registryTime +
                ", consultationTime=" + consultationTime +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
