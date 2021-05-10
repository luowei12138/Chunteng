package cn.bdqn.mapper;

import cn.bdqn.model.MedicalAdvice;
import cn.bdqn.req.MedicalAdviceReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医嘱表(MedicalAdvice)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:05
 */
public interface MedicalAdviceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MedicalAdvice queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MedicalAdvice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param medicalAdvice 实例对象
     * @return 对象列表
     */
    List<MedicalAdvice> queryAll(MedicalAdvice medicalAdvice);

    /**
     * 新增数据
     *
     * @param medicalAdvice 实例对象
     * @return 影响行数
     */
    int insert(MedicalAdvice medicalAdvice);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MedicalAdvice> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MedicalAdvice> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MedicalAdvice> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<MedicalAdvice> entities);

    /**
     * 修改数据
     *
     * @param medicalAdvice 实例对象
     * @return 影响行数
     */
    int update(MedicalAdvice medicalAdvice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    MedicalAdviceReq queryByRegistryId(@Param("registryId")Integer registryId);
}

