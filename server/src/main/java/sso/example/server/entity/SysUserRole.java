package sso.example.server.entity;

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
public class SysUserRole {
    private Integer id;

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 角色ID
    */
    private Integer roleId;
}