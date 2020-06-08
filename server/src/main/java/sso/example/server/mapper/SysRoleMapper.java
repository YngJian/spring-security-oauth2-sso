package sso.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import sso.example.server.entity.SysRole;

@Mapper
public interface SysRoleMapper {
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
    int insert(SysRole record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysRole record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysRole selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysRole record);
}