package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Role;
import fr.fo.ud.entity.User;

public interface IBusinessUser {

	public List<User> getAllUser();
	
	public User getUserById(int id);
	
	public Role getRoleById(int id);
	
	public User getUserByPseudo(String pseudo);
	
	public User saveUser(User user, int idRole);
	
	public void updateUser(int id, String pwd);
	
	public List<Role> getAllRole();
	
}
