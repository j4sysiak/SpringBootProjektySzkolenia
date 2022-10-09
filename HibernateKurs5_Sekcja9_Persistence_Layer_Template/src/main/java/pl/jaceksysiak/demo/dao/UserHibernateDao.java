package pl.jaceksysiak.demo.dao;

import java.util.List;

import pl.jaceksysiak.demo.dao.interfaces.UserDao;
import pl.jaceksysiak.demo.entity.User;



public class UserHibernateDao extends AbstractDao<User,Long> implements UserDao {

	public List<User> findByFirstName(String firstName) {
		//add implementation here...
		return null;
	}

}
