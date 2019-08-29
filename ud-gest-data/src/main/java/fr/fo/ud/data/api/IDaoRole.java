package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Role;

public interface IDaoRole {

	public Role save(Role role);
	
	public void update(Role role);
	
	public void delete(Role role);
	
	public List<Role> findAll();
	
	public Role findById(int id);
	
	public Role findByRole(String role);
	
	
}
