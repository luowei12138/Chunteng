package cn.bdqn.mapper;

import cn.bdqn.model.SysMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单表(SysMenus)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:10
 */
public interface SysMenusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysMenus queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysMenus> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysMenus 实例对象
     * @return 对象列表
     */
    List<SysMenus> queryAll(SysMenus sysMenus);

    /**
     * 新增数据
     *
     * @param sysMenus 实例对象
     * @return 影响行数
     */
    int insert(SysMenus sysMenus);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenus> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysMenus> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenus> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysMenus> entities);

    /**
     * 修改数据
     *
     * @param sysMenus 实例对象
     * @return 影响行数
     */
    int update(SysMenus sysMenus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    
    /**
     * @Author: hah
     * @Date: 2021-03-25 08:03:56
     * @Description: 加载菜单
     * @param rolesId
     * @return java.util.List<cn.bdqn.model.SysMenus>
     **/
    List<SysMenus> getMenuList(@Param("rolesId")Integer rolesId);

}

