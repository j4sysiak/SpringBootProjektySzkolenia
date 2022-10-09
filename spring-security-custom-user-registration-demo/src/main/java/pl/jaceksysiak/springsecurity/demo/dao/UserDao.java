package pl.jaceksysiak.springsecurity.demo.dao;

import pl.jaceksysiak.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
