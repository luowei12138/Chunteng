package cn.bdqn.mapper;

import cn.bdqn.model.PrescriptionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 开药明细表(PrescriptionDetail)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:08
 */
public interface PrescriptionDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PrescriptionDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PrescriptionDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param prescriptionDetail 实例对象
     * @return 对象列表
     */
    List<PrescriptionDetail> queryAll(PrescriptionDetail prescriptionDetail);

    /**
     * 新增数据
     *
     * @param prescriptionDetail 实例对象
     * @return 影响行数
     */
    int insert(PrescriptionDetail prescriptionDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PrescriptionDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PrescriptionDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PrescriptionDetail> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PrescriptionDetail> entities);

    /**
     * 修改数据
     *
     * @param prescriptionDetail 实例对象
     * @return 影响行数
     */
    int update(PrescriptionDetail prescriptionDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

