package cn.bdqn.mapper;

import cn.bdqn.model.ChargeRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收费记录表(ChargeRecords)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:01
 */
public interface ChargeRecordsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChargeRecords queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ChargeRecords> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param chargeRecords 实例对象
     * @return 对象列表
     */
    List<ChargeRecords> queryAll(ChargeRecords chargeRecords);

    /**
     * 新增数据
     *
     * @param chargeRecords 实例对象
     * @return 影响行数
     */
    int insert(ChargeRecords chargeRecords);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChargeRecords> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ChargeRecords> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ChargeRecords> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ChargeRecords> entities);

    /**
     * 修改数据
     *
     * @param chargeRecords 实例对象
     * @return 影响行数
     */
    int update(ChargeRecords chargeRecords);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

