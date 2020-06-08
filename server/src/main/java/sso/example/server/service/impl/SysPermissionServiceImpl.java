package sso.example.server.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import sso.example.server.entity.SysPermission;
import sso.example.server.mapper.SysPermissionMapper;
import sso.example.server.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermission record) {
        return sysPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionMapper.insertSelective(record);
    }

    @Override
    public SysPermission selectByPrimaryKey(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<SysPermission> findAllByIdIn(List<Integer> idCollection){
		 return sysPermissionMapper.findAllByIdIn(idCollection);
	}




}
