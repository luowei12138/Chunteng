package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 药方表(Prescription)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:06
 */
public class Prescription implements Serializable {
    private static final long serialVersionUID = -89037941058886265L;

    private Long id;
    /**
     * 挂号单表主键ID
     */
    private Long registryId;
    /**
     * 病人表主键ID
     */
    private Long patientId;
    /**
     * 支付状态 1-->待支付；2-->支付成功；3-->支付失败；4-->超时未支付
     */
    private Integer payStatus;
    /**
     * 是否取药 1-->未取药；2-->已取药
     */
    private Integer isFetchMedicine;
    /**
     * 总金额(￥)
     */
    private Double fee;
    /**
     * 实际支付金额(￥)
     */
    private Double payFee;
    /**
     * 医保报销金额(￥)
     */
    private Double medicareFee;
    /**
     * 支付时间
     */
    private Date payTime;
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

    public Long getRegistryId() {
        return registryId;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getIsFetchMedicine() {
        return isFetchMedicine;
    }

    public void setIsFetchMedicine(Integer isFetchMedicine) {
        this.isFetchMedicine = isFetchMedicine;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
