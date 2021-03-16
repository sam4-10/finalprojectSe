package edu.miu.mumschedule.demo.serviceImpl;



import edu.miu.mumschedule.demo.dao.RoleRepository;
import edu.miu.mumschedule.demo.domain.Role;
import edu.miu.mumschedule.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }


    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
