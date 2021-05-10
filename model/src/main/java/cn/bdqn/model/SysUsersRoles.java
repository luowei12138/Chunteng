package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户-角色关联表(SysUsersRoles)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:14
 */
public class SysUsersRoles implements Serializable {
    private static final long serialVersionUID = 745307477692258832L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 角色编号
     */
    private Long roleId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
