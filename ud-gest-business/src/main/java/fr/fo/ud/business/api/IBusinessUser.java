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
	
	public void updateUser(User user, int idRole);
	
	public void deleteUser(User user);
	
	public List<Role> getAllRole();
	
	public void activeUser(int id);
	
	public void desactiveUser(int id);
	
}
