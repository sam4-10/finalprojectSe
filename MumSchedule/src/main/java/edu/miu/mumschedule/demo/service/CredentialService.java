package edu.miu.mumschedule.demo.service;




import edu.miu.mumschedule.demo.domain.Credential;

import java.util.List;
import java.util.Optional;

public interface CredentialService {
    List<Credential> findAll();
    Credential save(Credential credential);
    Credential findById(Long cId);
    void delete(Long cId);
    Optional<Credential> findByUserName(String name);
}
