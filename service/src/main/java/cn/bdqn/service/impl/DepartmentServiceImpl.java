package cn.bdqn.service.impl;

import cn.bdqn.mapper.DepartmentDao;
import cn.bdqn.model.Department;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package: cn.bdqn.service.impl
 * @Description:
 * @Author hah
 * @Create 2021年04月08日 09时50分38秒
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public Result<List<Department>> getAlldepartment() {
        List<Department> departmentList = departmentDao.getAlldepartment();
        if (ObjectUtils.isEmpty(departmentList)) {
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(departmentList);
    }
}
