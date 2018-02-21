package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Syndicat;

public interface IBusinessSyndicat {

	public Syndicat add(Syndicat syndicat);
	
	public Syndicat update(Syndicat syndicat);
	
	public Syndicat delete(Syndicat syndicat);
	
	public List<Syndicat> getAll();
	
	public List<String> getAllLibelles();
	
	public Syndicat getById(Integer id);
	
	public List<Syndicat> getByMotCle(String motCle);
	
	
}
