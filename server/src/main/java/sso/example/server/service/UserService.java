package sso.example.server.service;


import sso.example.server.entity.SysUser;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
public interface UserService {

    SysUser getByUsername(String username);
}
