package cn.bdqn.service.impl;

import cn.bdqn.mapper.MedicalAdviceDao;
import cn.bdqn.model.MedicalAdvice;
import cn.bdqn.req.MedicalAdviceReq;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.MedicalAdviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 医嘱表(MedicalAdvice)表服务实现类
 *
 * @author makejava
 * @since 2021-03-19 22:55:05
 */
@Service("medicalAdviceService")
public class MedicalAdviceServiceImpl implements MedicalAdviceService {
    @Resource
    private MedicalAdviceDao medicalAdviceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MedicalAdvice queryById(Long id) {
        return this.medicalAdviceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MedicalAdvice> queryAllByLimit(int offset, int limit) {
        return this.medicalAdviceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param medicalAdvice 实例对象
     * @return 实例对象
     */
    @Override
    public MedicalAdvice insert(MedicalAdvice medicalAdvice) {
        this.medicalAdviceDao.insert(medicalAdvice);
        return medicalAdvice;
    }

    /**
     * 修改数据
     *
     * @param medicalAdvice 实例对象
     * @return 实例对象
     */
    @Override
    public MedicalAdvice update(MedicalAdvice medicalAdvice) {
        this.medicalAdviceDao.update(medicalAdvice);
        return this.queryById(medicalAdvice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.medicalAdviceDao.deleteById(id) > 0;
    }


    @Override
    public MedicalAdviceReq queryByRegistryId(Integer registryId) {
        return medicalAdviceDao.queryByRegistryId(registryId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<MedicalAdvice> medicalAdviceAdd(MedicalAdvice medicalAdvice) {
        Date date = new Date();
        MedicalAdviceReq medicalAdviceReq = medicalAdviceDao.queryByRegistryId(medicalAdvice.getRegistryId().intValue());
        int index = -1;
        medicalAdvice.setCreatedTime(date);
        medicalAdvice.setUpdatedTime(date);
        if (ObjectUtils.isEmpty(medicalAdviceReq)) {
            index = medicalAdviceDao.insert(medicalAdvice);
        } else {
            medicalAdvice.setId(medicalAdviceReq.getId());
            index = medicalAdviceDao.update(medicalAdvice);
        }
        if (index <= 0) {
            return ResultUtils.returnFail(medicalAdvice);
        } else {
            return ResultUtils.returnDataSuccess(medicalAdvice);
        }
    }

}
