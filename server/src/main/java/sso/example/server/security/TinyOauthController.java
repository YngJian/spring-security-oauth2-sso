package sso.example.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth")
public class TinyOauthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     *
     * 描   述 : 自定义返回信息添加基本信息
     */
    @PostMapping("/token")
    public Map<String, Object> postAccessTokenWithUserInfo(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Map<String, Object> data = new LinkedHashMap<>();
        assert accessToken != null;
        data.put("accessToken", accessToken.getValue());
        if (accessToken.getRefreshToken() != null) {
            data.put("refreshToken", accessToken.getRefreshToken().getValue());
        }
        data.put("expiration",accessToken.getExpiration());
        data.put("scope",accessToken.getScope());
        data.put("tokenType",accessToken.getTokenType());
        //添加基本信息

        return data;
    }
}
