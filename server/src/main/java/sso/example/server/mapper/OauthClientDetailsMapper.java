package sso.example.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import sso.example.server.entity.OauthClientDetails;

@Mapper
public interface OauthClientDetailsMapper {
    /**
     * delete by primary key
     * @param clientId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String clientId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OauthClientDetails record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OauthClientDetails record);

    /**
     * select by primary key
     * @param clientId primary key
     * @return object by primary key
     */
    OauthClientDetails selectByPrimaryKey(String clientId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OauthClientDetails record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OauthClientDetails record);
}