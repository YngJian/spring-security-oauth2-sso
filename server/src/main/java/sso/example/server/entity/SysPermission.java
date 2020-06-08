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
public class SysPermission {
    private Integer id;

    /**
    * 父ID
    */
    private Integer pid;

    /**
    * 资源类型（1：菜单，2：按钮，3：操作）
    */
    private Integer type;

    /**
    * 资源名称
    */
    private String name;

    /**
    * 资源标识（或者叫权限字符串）
    */
    private String code;

    /**
    * 资源URI
    */
    private String uri;

    /**
    * 序号
    */
    private Integer seq;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
}