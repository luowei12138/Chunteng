package cn.bdqn.service;

import cn.bdqn.model.Schedule;
import cn.bdqn.result.Result;

import java.util.List;

/**
 * @Package: cn.bdqn.service
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 11时08分48秒
 */
public interface ScheduleService {

    Result<List<Schedule>> getDoctorList(Schedule schedule);

}
