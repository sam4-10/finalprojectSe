package edu.miu.mumschedule.demo.service;




import edu.miu.mumschedule.demo.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void saveRole(Role role);
    void deleteRole(Long id);
    Optional<Role> findRoleById(Long id);
    List<Role> findAllRoles();
}
