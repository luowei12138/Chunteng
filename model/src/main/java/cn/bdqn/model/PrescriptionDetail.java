package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 开药明细表(PrescriptionDetail)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:08
 */
public class PrescriptionDetail implements Serializable {
    private static final long serialVersionUID = -63849793642115261L;

    private Long id;
    /**
     * 药方表主键ID
     */
    private Long prescriptionId;
    /**
     * 挂号单表主键ID
     */
    private Long registryId;
    /**
     * 药品表主键ID
     */
    private Long drugId;
    /**
     * 病人表主键ID
     */
    private Long patientId;
    /**
     * 药品数量
     */
    private Integer amount;
    /**
     * 是否是医保用药 1-->不是医保用药，2-->是医保用药
     */
    private Integer isMedicare;
    /**
     * 药品原始价格
     */
    private Double price;
    /**
     * 实际支付价格
     */
    private Double payPrice;
    /**
     * 医保报销金额
     */
    private Double medicarePrice;
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

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getRegistryId() {
        return registryId;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIsMedicare() {
        return isMedicare;
    }

    public void setIsMedicare(Integer isMedicare) {
        this.isMedicare = isMedicare;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Double getMedicarePrice() {
        return medicarePrice;
    }

    public void setMedicarePrice(Double medicarePrice) {
        this.medicarePrice = medicarePrice;
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
