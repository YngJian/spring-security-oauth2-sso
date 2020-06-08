package sso.example.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sso.example.server.entity.SysPermission;
import sso.example.server.entity.SysRolePermission;
import sso.example.server.entity.SysUserRole;
import sso.example.server.mapper.SysPermissionMapper;
import sso.example.server.mapper.SysRolePermissionMapper;
import sso.example.server.mapper.SysUserRoleMapper;
import sso.example.server.service.PermissionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    /**
     * 偷懒少写两个Service
     */
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleMapper.findAllByUserId(userId);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> rolePermissionList = sysRolePermissionMapper.findAllByIdIn(roleIdList);
        if (CollectionUtils.isEmpty(rolePermissionList)) {
            return null;
        }
        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        List<SysPermission> sysPermissionList = sysPermissionMapper.findAllByIdIn(permissionIdList);
        if (CollectionUtils.isEmpty(sysPermissionList)) {
            return null;
        }
        return sysPermissionList;
    }
}
