package sso.example.server.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class TinyLogoutController {
    @Autowired
    private TokenStore redisTokenStore;

    /**
     * 退出登录
     * */
    @PostMapping("/user/logout.tml")
    public JSONObject logout(HttpServletRequest request){
        log.info("start -------/user/logout------");
        String a=request.getHeader("Authorization");
        log.info("Authorization:{}",a);
        String token=a.substring(DefaultOAuth2AccessToken.BEARER_TYPE.length()+1);
        DefaultOAuth2AccessToken defaultOAuth2AccessToken=new DefaultOAuth2AccessToken(token);
        redisTokenStore.removeAccessToken(defaultOAuth2AccessToken);

        JSONObject result=new JSONObject();
        result.put("code","YW20000");
        result.put("msg","success");
        return result;
    }
}
