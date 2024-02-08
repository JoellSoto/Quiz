package com.Tech.quiz.UserManagement.Controller;

import com.Tech.quiz.UserManagement.entity.Roles;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.service.RoleService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/roles")
@RestController
@CrossOrigin(origins="*")
@AllArgsConstructor
public class RolesController {

    private final RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Roles>> getAllRoles(){
        return  ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping("/remove-all-users-from-role/{id}")
    public Roles removeAllUsersFromRole(@PathVariable("id") int roleId) {
        return roleService.removeAllUserFromRole(roleId);
    }

    @PostMapping("/remove-user-from-role")
    public ResponseEntity<User>removeUserToRole(@PathParam("userId") int userId, @PathParam("roleId") int roleId){
        return ResponseEntity.ok(roleService.removeUserFromRole(userId, roleId));
    }

    @PostMapping("/assign-user-to-role")
    public ResponseEntity<User>assignUserToRole(@PathParam("userId") int userId, @PathParam("roleId") int roleId){
        return ResponseEntity.ok(roleService.assignUserToRole(userId, roleId));
    }
}
