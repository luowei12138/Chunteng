package cn.bdqn.mapper;

import cn.bdqn.model.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 病人表(Patient)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:06
 */
public interface PatientDao {

    /**
     * @Author: hah
     * @Date: 2021-04-13 09:04:51
     * @Description: 查询医保卡是否存在
     * @param idMedicare
     * @return cn.bdqn.model.Patient
     **/
    Patient isNotIdMedicare(@Param("idMedicare")String idMedicare);

    Patient isNotIdCare(@Param("idCard")String idCard);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Patient queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Patient> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param patient 实例对象
     * @return 对象列表
     */
    List<Patient> queryAll(Patient patient);

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int insert(Patient patient);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Patient> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Patient> entities);

    /**
     * 修改数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int update(Patient patient);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

