package fr.fo.ud.business.mongo.api;

import java.util.List;

import fr.fo.ud.entity.Personne;

public interface IBusinessPersonne {

	public List<Personne> getAll();
	
	public Personne getById(int id);
	
	public Personne getByNom(String nom);
	
	
	
}
