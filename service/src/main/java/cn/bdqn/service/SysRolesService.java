package cn.bdqn.service;

import cn.bdqn.model.SysRoles;
import cn.bdqn.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: cn.bdqn.service
 * @Description:
 * @Author hah
 * @Create 2021年04月08日 09时33分21秒
 */
public interface SysRolesService {

    Result<List<SysRoles>> getRoleList();
}
