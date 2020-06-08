package sso.example.server.service;
import java.util.List;

import sso.example.server.entity.SysUserRole;
public interface SysUserRoleService{


    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);



	List<SysUserRole> findAllByUserId(Integer userId);


}
