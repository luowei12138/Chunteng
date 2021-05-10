package cn.bdqn.mapper;

import cn.bdqn.model.SysUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(SysUsers)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:14
 */
public interface SysUsersDao {

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    SysUsers queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUsers> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUsers 实例对象
     * @return 对象列表
     */
    List<SysUsers> queryAll(SysUsers sysUsers);

    /**
     * 新增数据
     *
     * @param sysUsers 实例对象
     * @return 影响行数
     */
    int insert(SysUsers sysUsers);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUsers> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUsers> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUsers> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUsers> entities);

    /**
     * 修改数据
     *
     * @param sysUsers 实例对象
     * @return 影响行数
     */
    int update(SysUsers sysUsers);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    
    /**
     * @Author: hah
     * @Date: 2021-03-23 01:03:55
     * @Description: 登入方法
     * @param account
     * @return cn.bdqn.model.SysUsers
     **/
    SysUsers dologin(@Param("account")String account);

    /**
     * @Author: hah
     * @Date: 2021-03-25 13:03:24
     * @Description:  查询用户列表
     * @return java.util.List<cn.bdqn.model.SysUsers>
     **/
    List<SysUsers> getUsersList();

    List<SysUsers> getDoctorList(@Param("departmentId")Integer departmentId);





}

