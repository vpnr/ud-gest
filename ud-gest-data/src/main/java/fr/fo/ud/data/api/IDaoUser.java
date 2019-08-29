package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.User;
/**
 * Definition des services li�es a la persistance pour l'entite {@link User}.
 * @author myPC
 *
 */
public interface IDaoUser {
    
	public User save(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByPseudo(String pseudo);

}
