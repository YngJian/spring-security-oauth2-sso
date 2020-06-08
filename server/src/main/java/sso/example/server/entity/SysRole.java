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
public class SysRole {
    private Integer id;

    /**
    * 角色名称
    */
    private String roleName;

    private String roleCode;

    /**
    * 角色描述
    */
    private String roleDescription;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}