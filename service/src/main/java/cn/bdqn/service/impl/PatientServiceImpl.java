package cn.bdqn.service.impl;

import cn.bdqn.mapper.PatientDao;
import cn.bdqn.model.Patient;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Package: cn.bdqn.service.impl
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 09时41分34秒
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;

    @Override
    public Result<Patient> isNotIdMedicare(String idMedicare) {
        Patient patient = patientDao.isNotIdMedicare(idMedicare);
        if(ObjectUtils.isEmpty(patient)){
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(patient);
    }


    @Override
    public Result<Patient> isNotIdCare(String idCard) {
        Patient patient = patientDao.isNotIdCare(idCard);
        if(ObjectUtils.isEmpty(patient)){
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(patient);
    }


    @Override
    public int insert(Patient patient) {
        patient.setIsMedicare(StringUtils.isEmpty(patient.getIdMedicare()) ? 1 : 2);
        Date date = new Date();
        patient.setCreatedTime(date);
        patient.setUpdatedTime(date);
        return patientDao.insert(patient);
    }


}
