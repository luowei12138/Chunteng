package cn.bdqn.service;

import cn.bdqn.common.PageUtils;
import cn.bdqn.dto.RegistryDto;
import cn.bdqn.model.Registry;
import cn.bdqn.req.RegistryReq;
import cn.bdqn.result.Result;

/**
 * @Package: cn.bdqn.service
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 15时50分13秒
 */
public interface RegistryService {

    boolean consultationEnd(Integer regiseryId);

    Result<RegistryReq> consultationAdd(Integer doctorId, Integer id) throws Exception;

    Result<Registry> createFee(String sign);

    Result<Registry> register(Registry registry, String idMedicare, Integer sign) throws Exception;

    PageUtils<RegistryDto> registerList(Registry registry, String idCard, Integer pageNo);

    Result queryAllregisterList(RegistryReq registryReq);

    RegistryReq getById(Integer id);
}
