package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;

public interface IDaoBranche {

    public Branche add(Branche branche);
    
    public Branche update(Branche branche);
    
    public Branche delete(Branche branche);
    
    public Branche getById(Integer id);
    
    public List<Branche> getAll();
    
    public List<Branche> getByMotCle(String motCle);
}
