package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Branche;

public interface IBusinessBranche {

    public Branche add(Branche branche);
    
    public Branche update(Branche branche);
    
    public Branche delete(Branche branche);
    
    public Branche getById(Integer id);
    
    public List<Branche> getAll();
    
    public List<Branche> getByMotCle(String motCle);
    
    public List<String> getAllLibellesBranche();
}
