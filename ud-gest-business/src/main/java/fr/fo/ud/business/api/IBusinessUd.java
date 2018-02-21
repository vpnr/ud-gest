package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.UnionDepartemental;

public interface IBusinessUd {

    public UnionDepartemental add(UnionDepartemental ud);
    
    public UnionDepartemental update(UnionDepartemental ud);
    
    public UnionDepartemental delete(int id);
    
    public UnionDepartemental getById(Integer id);
    
    public List<UnionDepartemental> getAll();
    
    public List<String> getAllLibelles();
    
    public List<UnionDepartemental> getByMotCle(String motCle);
}
