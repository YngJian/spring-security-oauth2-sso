package sso.example.server.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录方法
 * */
@RestController
@RequestMapping("/user")
public class TinyLoginController {

    private static final Logger log= LoggerFactory.getLogger(TinyLoginController.class);

//    private

    @Value("${security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login.tml")
    public JSONObject login(HttpServletRequest request, @RequestBody JSONObject param){
        log.info(">>>>>>>>>>>>login start<<<<<<<<<<<<<<<<<<<<");
        if (param.isEmpty()){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",4444);
            jsonObject.put("msg","miss param");
            return jsonObject;
        }

        String userName=param.getString("username");
        String password=param.getString("password");
        String grantType="password";
        String scope="all";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("grant_type", grantType);
        params.add("username", userName);
        params.add("password", password);
        params.add("scope", scope);
        params.add("client_id", clientId);
        params.add("client_secret",clientSecret);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        JSONObject jsonResult=new JSONObject();
        try {
            ResponseEntity<String> result=restTemplate.postForEntity(accessTokenUri,requestEntity,String.class);
            log.info("result:{}",result.getBody());
            jsonResult= JSON.parseObject(result.getBody());
        }catch (Exception e){
            jsonResult.put("code",4444);
            jsonResult.put("msg","login failed");
            jsonResult.put("desc",e.getMessage());
        }

        return jsonResult;
    }
}
