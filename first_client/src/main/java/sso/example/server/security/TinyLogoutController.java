package sso.example.server.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 退出登录方法
 * */
@RestController
@RequestMapping("/user")
@Slf4j
public class TinyLogoutController {

    @Value("${security.oauth2.logout.uri}")
    private String logoutUri;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/logout.tml")
    public JSONObject logout(HttpServletRequest request){
        String header_authorization=request.getHeader("Authorization");
        String token=header_authorization.substring(DefaultOAuth2AccessToken.BEARER_TYPE.length()+1);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        log.info("Authorization:{}",httpHeaders.get("Authorization"));

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(null, httpHeaders);
        JSONObject jsonResult=new JSONObject();
        try {
            log.info("logoutUri:{}",logoutUri);
            ResponseEntity<JSONObject> result=restTemplate.postForEntity(logoutUri,requestEntity, JSONObject.class);
            log.info("result:{}",result.getBody());
            jsonResult= result.getBody();
        }catch (Exception e){
            log.error("logout error:{}",e.getMessage());
            log.error(e.getMessage(),e);
            jsonResult.put("code",200000);
            jsonResult.put("msg","success");
//            jsonResult.put("desc",e.getMessage());
        }
        return jsonResult;
    }
}
