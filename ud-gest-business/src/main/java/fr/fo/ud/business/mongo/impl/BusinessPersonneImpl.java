package fr.fo.ud.business.mongo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.mongo.api.IBusinessPersonne;
import fr.fo.ud.entity.Personne;
import fr.fo.ud.repository.api.IPersonneRepository;

@Service
public class BusinessPersonneImpl implements IBusinessPersonne {

	@Autowired
	IPersonneRepository repo;
	
	@Override
	public List<Personne> getAll() {
		return repo.findAll();
	}

	@Override
	public Personne getById(int id) {
		return repo.findById(id);
	}

	@Override
	public Personne getByNom(String nom) {
		
		return repo.findByNom(nom);
	}

}
