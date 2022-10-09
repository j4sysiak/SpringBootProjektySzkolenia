package pl.jaceksysiak.springsecurity.demo.dao;

import pl.jaceksysiak.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
