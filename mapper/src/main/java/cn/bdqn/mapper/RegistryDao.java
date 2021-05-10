package cn.bdqn.mapper;

import cn.bdqn.dto.RegistryDto;
import cn.bdqn.model.Registry;
import cn.bdqn.req.RegistryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 挂号单表(Registry)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 22:55:09
 */
public interface RegistryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Registry queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Registry> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param registry 实例对象
     * @return 对象列表
     */
    List<Registry> queryAll(Registry registry);

    /**
     * 新增数据
     *
     * @param registry 实例对象
     * @return 影响行数
     */
    int insert(Registry registry);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Registry> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Registry> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Registry> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Registry> entities);

    /**
     * 修改数据
     *
     * @param registry 实例对象
     * @return 影响行数
     */
    int update(Registry registry);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<RegistryDto> registryList(@Param("userId") Long userId,
                                   @Param("departmentId") Long departmentId,
                                   @Param("status") Object status,
                                   @Param("idCard") String idCard,
                                   @Param("offset") Integer offset,
                                   @Param("pageSize") Integer pageSize);

    int registryListCount(@Param("userId") Long userId,
                          @Param("departmentId") Long departmentId,
                          @Param("status") Object status,
                          @Param("idCard") String idCard);

    List<RegistryDto> queryAllregisterList(RegistryReq registryReq);

    RegistryReq getById(@Param("id") Integer id);
}

