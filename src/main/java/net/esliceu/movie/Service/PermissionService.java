package net.esliceu.movie.Service;

import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    FindService findService;
    @Autowired
    FindAllService findAllService;

    public Boolean checkPermission(String type, String table, User user) throws ObjectNotFoundException {
        Boolean result = false;
        List<Authorization> adminRoles = findAllService.getAllAdminRolesByUser(user.getId());
        for(Authorization authorization : adminRoles){
            List<RolePermission> rolePermissions = findAllService.getAllPermissionsByAdminRole(authorization.getId().getAdminRole().getId());
            for(RolePermission permission : rolePermissions){
                if (permission.getId().getPermission().getName().equals(type + "_" + table)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
