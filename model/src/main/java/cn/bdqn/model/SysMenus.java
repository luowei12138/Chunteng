package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表(SysMenus)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:10
 */
public class SysMenus implements Serializable {
    private static final long serialVersionUID = -28200996191523381L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 菜单类型 1-->1级菜单；2-->2级菜单
     */
    private Integer menuType;
    /**
     * 父级菜单编号
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * @Author: hah
     * @Date: 2021-03-25 08:03:34
     * @Description: 子菜单
     * @param null
     * @return
     **/
    private List<SysMenus> subMenus;

    /**
     * @Author: hah
     * @Date: 2021-03-25 08:03:50
     * @Description: 子地址
     * @param null
     * @return
     **/
    private String subMenuUrl;

    /**
     * @Author: hah
     * @Date: 2021-03-25 08:03:39
     * @Description: 子名称
     * @param null
     * @return 
     **/
    private String subMenuName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public List<SysMenus> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SysMenus> subMenus) {
        this.subMenus = subMenus;
    }

    public String getSubMenuUrl() {
        return subMenuUrl;
    }

    public void setSubMenuUrl(String subMenuUrl) {
        this.subMenuUrl = subMenuUrl;
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }
}
