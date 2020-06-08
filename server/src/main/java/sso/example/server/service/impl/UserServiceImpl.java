package sso.example.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sso.example.server.entity.SysUser;
import sso.example.server.mapper.SysUserMapper;
import sso.example.server.service.UserService;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserRepository;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findAllByUsername(username);
    }
}
