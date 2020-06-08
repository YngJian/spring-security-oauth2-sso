package sso.example.server.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import sso.example.server.entity.SysUserRole;

@Mapper
public interface SysUserRoleMapper {
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
    int insert(SysUserRole record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysUserRole record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysUserRole selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysUserRole record);
    List<SysUserRole> findAllByUserId(@Param("userId")Integer userId);


}