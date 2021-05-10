package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 就诊科室表(Department)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:02
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -87551627550106644L;

    private Long id;
    /**
     * 科室名称
     */
    private String name;
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
