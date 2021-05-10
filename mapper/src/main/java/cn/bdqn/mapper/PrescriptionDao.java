package cn.bdqn.mapper;

import cn.bdqn.model.Prescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 药方表(Prescription)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:06
 */
public interface PrescriptionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Prescription queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Prescription> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param prescription 实例对象
     * @return 对象列表
     */
    List<Prescription> queryAll(Prescription prescription);

    /**
     * 新增数据
     *
     * @param prescription 实例对象
     * @return 影响行数
     */
    int insert(Prescription prescription);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Prescription> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Prescription> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Prescription> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Prescription> entities);

    /**
     * 修改数据
     *
     * @param prescription 实例对象
     * @return 影响行数
     */
    int update(Prescription prescription);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

