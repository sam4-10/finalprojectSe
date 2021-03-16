package edu.miu.mumschedule.demo.dao;


import edu.miu.mumschedule.demo.domain.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("credentialRepository")
public interface ICredentialRepository extends JpaRepository<Credential, Long> {

    @Query("select c from Credential c where  c.userName= :username")
    Optional<Credential> findByUserName(String username);


}
