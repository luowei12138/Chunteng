package cn.bdqn.service;

import cn.bdqn.model.SysUsers;
import cn.bdqn.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 用户表(SysUsers)表服务接口
 *
 * @author makejava
 * @since 2021-03-19 22:55:14
 */
public interface SysUsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUsers queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUsers> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUsers 实例对象
     * @return 实例对象
     */
    SysUsers insert(SysUsers sysUsers);

    /**
     * 修改数据
     *
     * @param sysUsers 实例对象
     * @return 实例对象
     */
    SysUsers update(SysUsers sysUsers);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * @Author: hah
     * @Date: 2021-03-25 13:03:20
     * @Description: 查询用户列表
     * @return java.util.List<cn.bdqn.model.SysUsers>
     **/
    List<SysUsers> getUsersList();

    /**
     * @Author: hah
     * @Date: 2021-03-30 11:03:41
     * @Description: 登入方法
     * @param sysUsers
     * @return cn.bdqn.result.Result<java.util.List<cn.bdqn.model.SysUsers>>
     **/
    Result<SysUsers> dologin(SysUsers sysUsers);

    /**
     * @Author: hah
     * @Date: 2021-04-08 10:04:31
     * @Description: 验证用户名，是否，存在
     * @param account
     * @return cn.bdqn.result.Result<cn.bdqn.model.SysUsers>
     **/
    Result<SysUsers> accountExist(String account);

    /**
     * @Author: hah
     * @Date: 2021-04-08 10:04:07
     * @Description: 添加用户
     * @param sysUsers
     * @param multipartFile
     * @return cn.bdqn.result.Result<cn.bdqn.model.SysUsers>
     **/
    Result<SysUsers> addUser(SysUsers sysUsers, MultipartFile multipartFile);

    Result<List<SysUsers>> getDoctorListByDepartmentId(Integer departmentId);
}
