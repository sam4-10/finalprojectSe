package edu.miu.mumschedule.demo.dao;


import edu.miu.mumschedule.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
