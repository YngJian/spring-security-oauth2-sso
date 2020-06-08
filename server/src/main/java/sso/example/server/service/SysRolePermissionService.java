package sso.example.server.service;
import java.util.Collection;
import java.util.List;

import sso.example.server.entity.SysRolePermission;
public interface SysRolePermissionService{


    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);



	List<SysRolePermission> findAllByIdIn(List<Integer> idCollection);


}
