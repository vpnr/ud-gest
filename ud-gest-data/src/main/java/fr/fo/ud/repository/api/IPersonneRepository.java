package fr.fo.ud.repository.api;

import java.util.List;

import fr.fo.ud.entity.Personne;

public interface IPersonneRepository  {

	public List<Personne> findAll();
	
	public Personne findById(int id);
	
	public Personne findByNom(String nom);
	
	public void save(Personne p);
	
	public void delete(Personne p);
	
}
