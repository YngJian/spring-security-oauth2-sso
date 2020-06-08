package sso.example.server.service;
import java.util.List;

import sso.example.server.entity.SysUser;
public interface SysUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);



	SysUser findAllByUsername(String username);


}
