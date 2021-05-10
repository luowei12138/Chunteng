package cn.bdqn.service.impl;

import cn.bdqn.mapper.SysRolesDao;
import cn.bdqn.model.SysRoles;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.SysRolesService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: cn.bdqn.service.impl
 * @Description:
 * @Author hah
 * @Create 2021年04月08日 09时34分02秒
 */
@Service("sysRolesService")
public class SysRolesServiceImpl implements SysRolesService {

    @Resource
    private SysRolesDao sysRolesDao;


    @Override
    public Result<List<SysRoles>> getRoleList() {
        List<SysRoles> roles = sysRolesDao.getRoleList();
        if (ObjectUtils.isEmpty(roles)) {
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(roles);
    }


}
