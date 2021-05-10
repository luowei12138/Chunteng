package cn.bdqn.mapper;

import cn.bdqn.model.DrugBatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 药品批次表(DrugBatch)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:04
 */
public interface DrugBatchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DrugBatch queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DrugBatch> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param drugBatch 实例对象
     * @return 对象列表
     */
    List<DrugBatch> queryAll(DrugBatch drugBatch);

    /**
     * 新增数据
     *
     * @param drugBatch 实例对象
     * @return 影响行数
     */
    int insert(DrugBatch drugBatch);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DrugBatch> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DrugBatch> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DrugBatch> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DrugBatch> entities);

    /**
     * 修改数据
     *
     * @param drugBatch 实例对象
     * @return 影响行数
     */
    int update(DrugBatch drugBatch);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

