package cn.bdqn.mapper;

import cn.bdqn.model.SysRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(SysRoles)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:11
 */
public interface SysRolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoles queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRoles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoles 实例对象
     * @return 对象列表
     */
    List<SysRoles> queryAll(SysRoles sysRoles);

    /**
     * 新增数据
     *
     * @param sysRoles 实例对象
     * @return 影响行数
     */
    int insert(SysRoles sysRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoles> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysRoles> entities);

    /**
     * 修改数据
     *
     * @param sysRoles 实例对象
     * @return 影响行数
     */
    int update(SysRoles sysRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     * @Author: hah
     * @Date: 2021-03-25 23:03:03
     * @Description: 查询所有角色
     * @return java.util.List<cn.bdqn.model.SysRoles>
     **/
    List<SysRoles> getRoleList();



}

