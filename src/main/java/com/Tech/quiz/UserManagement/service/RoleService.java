package com.Tech.quiz.UserManagement.service;

import com.Tech.quiz.UserManagement.entity.Roles;
import com.Tech.quiz.UserManagement.entity.User;

import java.util.List;

public interface RoleService {
    List<Roles> getAllRoles();
    Roles removeAllUserFromRole(int roleId);

    User removeUserFromRole(int userId, int roleId);

    User assignUserToRole(int userId,int roleId);

}
