package cn.bdqn.service;

import cn.bdqn.model.Patient;
import cn.bdqn.result.Result;

/**
 * @Package: cn.bdqn.service
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 09时41分20秒
 */
public interface PatientService {

    /**
     * @Author: hah
     * @Date: 2021-04-13 09:04:54
     * @Description: 查询医保卡是否存在
     * @param idMedicare
     * @return cn.bdqn.result.Result<cn.bdqn.model.Patient>
     **/
    Result<Patient> isNotIdMedicare(String idMedicare);

    /**
     * @Author: hah
     * @Date: 2021-04-13 10:04:41
     * @Description: 查询身份证
     * @param idCard
     * @return cn.bdqn.result.Result<cn.bdqn.model.Patient>
     **/
    Result<Patient> isNotIdCare(String idCard);

    int insert(Patient patient);
}
