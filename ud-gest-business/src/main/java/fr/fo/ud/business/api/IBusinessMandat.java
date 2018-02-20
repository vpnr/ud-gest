package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Mandat;

public interface IBusinessMandat{

    public Mandat add(Mandat fonction);
    
    public Mandat update(Mandat fonction);
    
    public Mandat delete(Mandat fonction);
    
    public List<Mandat> getAll();
    
    public List<Mandat> getByMotCle(String motCle);
    
    public Mandat getById(Integer id);
    
}
