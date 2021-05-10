package cn.bdqn.service;

import cn.bdqn.model.SysMenus;
import cn.bdqn.result.Result;
import java.util.List;

/**
 * 菜单表(SysMenus)表服务接口
 *
 * @author makejava
 * @since 2021-03-19 22:55:10
 */
public interface SysMenusService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysMenus queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysMenus> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysMenus 实例对象
     * @return 实例对象
     */
    SysMenus insert(SysMenus sysMenus);

    /**
     * 修改数据
     *
     * @param sysMenus 实例对象
     * @return 实例对象
     */
    SysMenus update(SysMenus sysMenus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * @Author: hah
     * @Date: 2021-03-25 09:03:47
     * @Description: 根据rolesId，判断角色
     * @param rolesId
     * @return java.util.List<cn.bdqn.model.SysMenus>
     **/
    Result<List<SysMenus>> getMenuList(Integer rolesId);

}
