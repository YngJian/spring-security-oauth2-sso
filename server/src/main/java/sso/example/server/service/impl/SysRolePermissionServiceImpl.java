package sso.example.server.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import sso.example.server.entity.SysRolePermission;
import sso.example.server.mapper.SysRolePermissionMapper;
import sso.example.server.service.SysRolePermissionService;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        return sysRolePermissionMapper.insertSelective(record);
    }

    @Override
    public SysRolePermission selectByPrimaryKey(Integer id) {
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<SysRolePermission> findAllByIdIn(List<Integer> idCollection){
		 return sysRolePermissionMapper.findAllByIdIn(idCollection);
	}




}
