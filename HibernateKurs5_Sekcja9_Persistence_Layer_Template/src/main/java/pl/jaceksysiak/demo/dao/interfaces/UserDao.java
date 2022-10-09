package pl.jaceksysiak.demo.dao.interfaces;

import java.util.List;

import pl.jaceksysiak.demo.entity.User;

public interface UserDao extends Dao<User,Long>{

	public List<User> findByFirstName(String firstName);
}
