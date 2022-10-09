package pl.jaceksysiak.springsecurity.demo.service;

import pl.jaceksysiak.springsecurity.demo.entity.User;
import pl.jaceksysiak.springsecurity.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
