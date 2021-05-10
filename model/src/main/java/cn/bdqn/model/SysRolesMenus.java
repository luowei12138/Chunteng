package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色-菜单关联表(SysRolesMenus)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:13
 */
public class SysRolesMenus implements Serializable {
    private static final long serialVersionUID = 511161825077571437L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 角色编号
     */
    private Long roleId;
    /**
     * 菜单编号
     */
    private Long menuId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
