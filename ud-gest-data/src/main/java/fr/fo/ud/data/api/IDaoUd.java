package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.UnionDepartemental;

public interface IDaoUd {

    public UnionDepartemental add(UnionDepartemental ud);
    
    public UnionDepartemental update(UnionDepartemental ud);
    
    public UnionDepartemental delete(UnionDepartemental ud);
    
    public List<UnionDepartemental> findAll();
    
    public UnionDepartemental findByLibelle(String libelle);
    
    public List<String> findAllLibelles();
    
    public UnionDepartemental findById(Integer id);
    
    public List<UnionDepartemental> findByMotCle(String motCle);
    
}
