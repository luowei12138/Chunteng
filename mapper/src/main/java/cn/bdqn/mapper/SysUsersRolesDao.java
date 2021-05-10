package cn.bdqn.mapper;

import cn.bdqn.model.SysUsersRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户-角色关联表(SysUsersRoles)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:14
 */
public interface SysUsersRolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUsersRoles queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUsersRoles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUsersRoles 实例对象
     * @return 对象列表
     */
    List<SysUsersRoles> queryAll(SysUsersRoles sysUsersRoles);

    /**
     * 新增数据
     *
     * @param sysUsersRoles 实例对象
     * @return 影响行数
     */
    int insert(SysUsersRoles sysUsersRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUsersRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUsersRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUsersRoles> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUsersRoles> entities);

    /**
     * 修改数据
     *
     * @param sysUsersRoles 实例对象
     * @return 影响行数
     */
    int update(SysUsersRoles sysUsersRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

