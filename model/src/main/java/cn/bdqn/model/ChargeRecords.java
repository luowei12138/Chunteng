package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 收费记录表(ChargeRecords)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:01
 */
public class ChargeRecords implements Serializable {
    private static final long serialVersionUID = 957923405931516998L;

    private Long id;
    /**
     * 收费来源ID
     */
    private Long targetId;
    /**
     * 病人表主键ID
     */
    private Long patientId;
    /**
     * 收费来源类型 1-->药方；2-->检查单
     */
    private Integer targetType;
    /**
     * 支付方式 1-->现金；2-->支付宝；3-->微信
     */
    private Integer paymentMethod;
    /**
     * 总金额(￥)
     */
    private Double money;
    /**
     * 实际支付金额(￥)
     */
    private Double payMoney;
    /**
     * 医保报销金额(￥)
     */
    private Double medicareMoney;
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

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Double getMedicareMoney() {
        return medicareMoney;
    }

    public void setMedicareMoney(Double medicareMoney) {
        this.medicareMoney = medicareMoney;
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
