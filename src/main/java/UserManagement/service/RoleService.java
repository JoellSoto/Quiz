package UserManagement.service;

import java.util.List;

public interface RoleService {
    List<Roles> getAllRoles();
    Roles removeAllUserFromRole(int roleId);

    User removeUserFromRole(int userId,int roleId);

    User assignUserToRole(int userId,int roleId);

}
