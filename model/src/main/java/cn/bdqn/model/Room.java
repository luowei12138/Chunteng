package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 就诊房间表(Room)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:09
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 418630234761177469L;

    private Long id;
    /**
     * 就诊科室表主键ID
     */
    private Long departmentId;
    /**
     * 房间名称
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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
