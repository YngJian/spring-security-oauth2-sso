package sso.example.server.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import sso.example.server.mapper.OauthClientDetailsMapper;
import sso.example.server.entity.OauthClientDetails;
import sso.example.server.service.OauthClientDetailsService;

@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    @Resource
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public int deleteByPrimaryKey(String clientId) {
        return oauthClientDetailsMapper.deleteByPrimaryKey(clientId);
    }

    @Override
    public int insert(OauthClientDetails record) {
        return oauthClientDetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(OauthClientDetails record) {
        return oauthClientDetailsMapper.insertSelective(record);
    }

    @Override
    public OauthClientDetails selectByPrimaryKey(String clientId) {
        return oauthClientDetailsMapper.selectByPrimaryKey(clientId);
    }

    @Override
    public int updateByPrimaryKeySelective(OauthClientDetails record) {
        return oauthClientDetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OauthClientDetails record) {
        return oauthClientDetailsMapper.updateByPrimaryKey(record);
    }

}
