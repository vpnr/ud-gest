package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Mandat;

public interface IBusinessMandat{

    public Mandat add(Mandat mandat);
    
    public Mandat update(Mandat mandat);
    
    public Mandat delete(Mandat mandat);
    
    public List<Mandat> getAll();
    
    public List<Mandat> getByMotCle(String motCle);
    
    public Mandat getById(Integer id);
    
}
