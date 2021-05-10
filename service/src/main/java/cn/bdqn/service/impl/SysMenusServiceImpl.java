package cn.bdqn.service.impl;

import cn.bdqn.mapper.SysMenusDao;
import cn.bdqn.model.SysMenus;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.SysMenusService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单表(SysMenus)表服务实现类
 *
 * @author makejava
 * @since 2021-03-19 22:55:11
 */
@Service("sysMenusService")
public class SysMenusServiceImpl implements SysMenusService {


    @Resource
    private SysMenusDao sysMenusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysMenus queryById(Long id) {
        return this.sysMenusDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysMenus> queryAllByLimit(int offset, int limit) {
        return this.sysMenusDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysMenus 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenus insert(SysMenus sysMenus) {
        this.sysMenusDao.insert(sysMenus);
        return sysMenus;
    }

    /**
     * 修改数据
     *
     * @param sysMenus 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenus update(SysMenus sysMenus) {
        this.sysMenusDao.update(sysMenus);
        return this.queryById(sysMenus.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysMenusDao.deleteById(id) > 0;
    }

    /**
     * @Author: hah
     * @Date: 2021-03-25 09:03:02
     * @Description: 根据rolesId，判断角色
     * @param rolesId
     * @return java.util.List<cn.bdqn.model.SysMenus>
     **/
    @Override
    public Result<List<SysMenus>> getMenuList(Integer rolesId) {
        Result<List<SysMenus>> result = null;
        List<SysMenus> sysMenus = sysMenusDao.getMenuList(rolesId);
        if (ObjectUtils.isEmpty(sysMenus)) {
            result = ResultUtils.returnFail(sysMenus);
        } else {
            result = ResultUtils.returnDataSuccess(sysMenus);
        }
        return result;
    }
    
}
