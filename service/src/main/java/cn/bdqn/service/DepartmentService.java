package cn.bdqn.service;

import cn.bdqn.model.Department;
import cn.bdqn.result.Result;
import java.util.List;

/**
 * @Package: cn.bdqn.service
 * @Description:
 * @Author hah
 * @Create 2021年04月08日 09时50分20秒
 */
public interface DepartmentService {

    Result<List<Department>> getAlldepartment();

}
