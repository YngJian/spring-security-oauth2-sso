package sso.example.server.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import sso.example.server.entity.SysPermission;

@Mapper
public interface SysPermissionMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(SysPermission record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysPermission record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysPermission selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> findAllByIdIn(@Param("idCollection")List<Integer> idCollection);


}