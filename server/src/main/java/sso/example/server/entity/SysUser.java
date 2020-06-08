package sso.example.server.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer id;

    /**
    * 账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 状态（0：锁定，1：解锁）
    */
    private Integer status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}