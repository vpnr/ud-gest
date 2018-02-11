package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.UnionDepartemental;

public interface IBusinessUd {

    UnionDepartemental add(UnionDepartemental ud);
    
    UnionDepartemental update(UnionDepartemental ud);
    
    UnionDepartemental delete(int id);
    
    UnionDepartemental getById(Integer id);
    
    List<UnionDepartemental> getAll();
    
    List<UnionDepartemental> getByMotCle(String motCle);
}
