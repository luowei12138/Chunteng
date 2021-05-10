package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品表(Drug)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:03
 */
public class Drug implements Serializable {
    private static final long serialVersionUID = 310080558983633827L;

    private Long id;
    /**
     * 药品名称
     */
    private String name;
    /**
     * 生产厂家
     */
    private String company;
    /**
     * 单价
     */
    private Double price;
    /**
     * 药品图片URL
     */
    private String image;
    /**
     * 药品类型 1-->甲类；2-->乙类；3-->丙类
     */
    private Integer type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
