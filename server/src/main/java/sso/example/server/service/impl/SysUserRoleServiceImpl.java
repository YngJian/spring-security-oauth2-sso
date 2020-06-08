package sso.example.server.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import sso.example.server.mapper.SysUserRoleMapper;
import sso.example.server.entity.SysUserRole;
import sso.example.server.service.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return sysUserRoleMapper.insertSelective(record);
    }

    @Override
    public SysUserRole selectByPrimaryKey(Integer id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<SysUserRole> findAllByUserId(Integer userId){
		 return sysUserRoleMapper.findAllByUserId(userId);
	}




}
