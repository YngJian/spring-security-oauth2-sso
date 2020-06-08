package sso.example.server.service;
import java.util.Collection;
import java.util.List;

import sso.example.server.entity.SysPermission;
public interface SysPermissionService{


    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);



	List<SysPermission> findAllByIdIn(List<Integer> idCollection);


}
