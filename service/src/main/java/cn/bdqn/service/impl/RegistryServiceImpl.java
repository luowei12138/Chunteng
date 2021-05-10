package cn.bdqn.service.impl;

import cn.bdqn.common.Config;
import cn.bdqn.common.PageUtils;
import cn.bdqn.dto.RegistryDto;
import cn.bdqn.mapper.MedicalAdviceDao;
import cn.bdqn.mapper.PatientDao;
import cn.bdqn.mapper.RegistryDao;
import cn.bdqn.mapper.ScheduleDao;
import cn.bdqn.model.Patient;
import cn.bdqn.model.Registry;
import cn.bdqn.model.Schedule;
import cn.bdqn.req.RegistryReq;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.RegistryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: cn.bdqn.service.impl
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 15时50分28秒
 */
@Service("registryService")
public class RegistryServiceImpl implements RegistryService {

    @Autowired
    RegistryDao registryDao;
    @Autowired
    PatientDao patientDao;
    @Autowired
    ScheduleDao scheduleDao;
    @Autowired
    MedicalAdviceDao medicalAdviceDao;

    @Override
    public Result<Registry> createFee(String sign) {
        Registry registry = new Registry();
        registry.setFee(Config.REGISTRY_FEE.doubleValue());
        if(StringUtils.isEmpty(sign)){
            registry.setPayFee(Config.REGISTRY_FEE.doubleValue());
            registry.setMedicareFee(Config.REGISTRY_NO_MEDICARE_FEE.doubleValue());
        }else{
            registry.setMedicareFee(Config.REGISTRY_MEDICARE_FEE.doubleValue());
            registry.setPayFee(registry.getFee() - registry.getMedicareFee());
        }
        return ResultUtils.returnDataSuccess(registry);
    }

    @Override
    public Result<Registry> register(Registry registry, String idMedicare, Integer sign) throws Exception {

        /// 1. 判断是否 填写医保卡
        // 获取 就诊卡信息
        final Date date = new Date();
        // 作业上也没有说要搞挂号了之后还能不能重心挂号 本来可以再加的 那就算了
        // 是否用了医保卡
        if (registry.getIsMedicare() == 2) {
            Patient patient = patientDao.queryById(registry.getPatientId());
            // 判断是否已保存医保卡 如果没有添加医保卡
            if (patient.getIsMedicare() == 1) {
                // 保存 医保卡信息
                patient.setUpdatedTime(date);
                patient.setIsMedicare(2);
                patient.setIdMedicare(idMedicare);
                patientDao.update(patient);
            }
        }

        // 修改排期表数据 查询条件: 当天时间 时间段 诊科室 主治医师 房间id
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("date", date);
                put("sign", sign);
                put("departmentId", registry.getDepartmentId());
                put("userId", registry.getUserId());
                put("roomId", registry.getRoomId());
            }
        };
        Schedule schedule = scheduleDao.queryByMap(map);
        if (ObjectUtils.isEmpty(schedule)) {
            throw new Exception("获取排期表失败");
        }
        // 修改 排期表
        // 添加人数 修改时间
        schedule.setRemainingQuantity(schedule.getRemainingQuantity() + 1);
        schedule.setUpdatedTime(date);
        int update = scheduleDao.update(schedule);
        if (update <= 0) {
            throw new Exception("修改排期表失败！");
        }

        // 添加数据
        registry.setRegistryTime(date);
        registry.setCreatedTime(date);
        registry.setUpdatedTime(date);
        registry.setStatus(1);
        int insert = registryDao.insert(registry);
        if (insert >= 1) {
            return ResultUtils.returnDataSuccess(registry);
        } else {
            return ResultUtils.returnFail(registry);
        }
    }


    @Override
    public PageUtils<RegistryDto> registerList(Registry registry, String idCard, Integer pageNo) {
        PageUtils<RegistryDto> registryPageUtils = new PageUtils<>();
        pageNo = ObjectUtils.isEmpty(pageNo) ? 1 : pageNo;
        int offset = (pageNo - 1) * 10;
        if (ObjectUtils.isEmpty(registry.getStatus()) || Integer.parseInt(registry.getStatus().toString()) == 0) {
            registry.setStatus(null);
        }

        List<RegistryDto> registryList = registryDao.registryList(registry.getUserId(), registry.getDepartmentId(), registry.getStatus(), idCard, offset, 10);

        int listCount = registryDao.registryListCount(registry.getUserId(), registry.getDepartmentId(), registry.getStatus(), idCard);
        registryPageUtils.setPageNo(pageNo);
        registryPageUtils.setMaxPageSize(10);
        registryPageUtils.setTotal(listCount);
        registryPageUtils.setDatas(registryList);

        return registryPageUtils;
    }

    @Override
    public Result queryAllregisterList(RegistryReq registryReq) {
        System.out.println("registryReq.getPageNo()为："+registryReq.getPageNo());
        PageHelper.startPage(registryReq.getPageNo(),5);
        List<RegistryDto> registryDtoList = registryDao.queryAllregisterList(registryReq);
        PageInfo<RegistryDto> info = new PageInfo<>(registryDtoList, 3);
        return ResultUtils.returnDataSuccess(info);
    }

    @Override
    public RegistryReq getById(Integer id) {
        return registryDao.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<RegistryReq> consultationAdd(Integer doctorId, Integer id) throws Exception {
        // 修改 挂号信息 正在问诊
        Registry registry = registryDao.queryById(id.longValue());
        // 2 ： 正在问诊
        registry.setStatus(2);
        Date date = new Date();
        // 问诊时间
        registry.setConsultationTime(date);
        // 修改时间
        registry.setUpdatedTime(date);
        // 修改并返回修改行数
        int update = registryDao.update(registry);
        if (update <= 0){
            throw new Exception("修改状态失败");
        }
        System.out.println("========= 状态已修改 正在问诊 =========");
        // 查询数据
        RegistryReq registryReq = registryDao.getById(id);
        if (ObjectUtils.isEmpty(registryReq)) {
            throw new Exception("查询失败！");
        }
        // 返回数据
        return ResultUtils.returnDataSuccess(registryReq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean consultationEnd(Integer regiseryId) {
        Date date = new Date();
        // 查询数据
        Registry registry = registryDao.queryById(regiseryId.longValue());
        // 修改时间
        registry.setUpdatedTime(date);
        // 3: 结束问诊
        registry.setStatus(3);
        int update = registryDao.update(registry);
        return update > 0;
    }

}
