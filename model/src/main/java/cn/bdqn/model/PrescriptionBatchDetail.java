package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 开药批次明细表(PrescriptionBatchDetail)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:07
 */
public class PrescriptionBatchDetail implements Serializable {
    private static final long serialVersionUID = 804791884112088900L;

    private Long id;
    /**
     * 开药明细表主键ID
     */
    private Long prescriptionDetailId;
    /**
     * 药品批次表主键ID
     */
    private Long drugBatchId;
    /**
     * 用药数量
     */
    private Integer usedAmount;
    /**
     * 生产日期
     */
    private Object productionDate;
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

    public Long getPrescriptionDetailId() {
        return prescriptionDetailId;
    }

    public void setPrescriptionDetailId(Long prescriptionDetailId) {
        this.prescriptionDetailId = prescriptionDetailId;
    }

    public Long getDrugBatchId() {
        return drugBatchId;
    }

    public void setDrugBatchId(Long drugBatchId) {
        this.drugBatchId = drugBatchId;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Object getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Object productionDate) {
        this.productionDate = productionDate;
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
