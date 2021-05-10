package cn.bdqn.service.impl;

import cn.bdqn.mapper.ScheduleDao;
import cn.bdqn.model.Schedule;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * @Package: cn.bdqn.service.impl
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 11时09分02秒
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    @Override
    public Result<List<Schedule>> getDoctorList(Schedule schedule) {
        schedule.setInquiryTime(new Date());
        List<Schedule> scheduleList = scheduleDao.getDoctorList(schedule);
        if(ObjectUtils.isEmpty(scheduleList)){
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(scheduleList);
    }

}
