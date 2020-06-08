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
public class SysRolePermission {
    private Integer id;

    /**
    * 角色ID
    */
    private Integer roleId;

    /**
    * 权限ID
    */
    private Integer permissionId;
}