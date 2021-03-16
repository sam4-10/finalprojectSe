package edu.miu.mumschedule.demo.serviceImpl;



import edu.miu.mumschedule.demo.dao.ICredentialRepository;
import edu.miu.mumschedule.demo.domain.Credential;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Collection;

@Component
@Transactional
public class AuctionUserDetailsService implements UserDetailsService {

    @Autowired
    private ICredentialRepository credentialRepository;
//
    @Autowired
    private HttpSession session;


    @RequestMapping
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        limitedLogIns(session.getId());
        session.setAttribute("newUser",username);
        Credential user = credentialRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        session.setAttribute("userId", user.getUser().getId());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Credential user) {
        String userRoles = user.getUser().getRole().getName();
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }



}

