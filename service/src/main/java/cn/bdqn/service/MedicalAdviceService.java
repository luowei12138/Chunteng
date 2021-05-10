package cn.bdqn.service;

import cn.bdqn.model.MedicalAdvice;
import cn.bdqn.req.MedicalAdviceReq;
import cn.bdqn.result.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医嘱表(MedicalAdvice)表服务接口
 *
 * @author makejava
 * @since 2021-03-19 22:55:05
 */
public interface MedicalAdviceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MedicalAdvice queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MedicalAdvice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param medicalAdvice 实例对象
     * @return 实例对象
     */
    MedicalAdvice insert(MedicalAdvice medicalAdvice);

    /**
     * 修改数据
     *
     * @param medicalAdvice 实例对象
     * @return 实例对象
     */
    MedicalAdvice update(MedicalAdvice medicalAdvice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    MedicalAdviceReq queryByRegistryId(@Param("registryId")Integer registryId);

    Result<MedicalAdvice> medicalAdviceAdd(MedicalAdvice medicalAdvice);

}
