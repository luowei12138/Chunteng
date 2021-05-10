package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品批次表(DrugBatch)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:04
 */
public class DrugBatch implements Serializable {
    private static final long serialVersionUID = -35844895358927583L;

    private Long id;
    /**
     * 药品表主键ID
     */
    private Long drugId;
    /**
     * 原始库存
     */
    private Integer stock;
    /**
     * 剩余库存
     */
    private Integer residueStock;
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

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getResidueStock() {
        return residueStock;
    }

    public void setResidueStock(Integer residueStock) {
        this.residueStock = residueStock;
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
