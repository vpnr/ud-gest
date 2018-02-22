package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;

public interface IDaoBranche {

    public Branche add(Branche branche);
    
    public Branche update(Branche branche);
    
    public Branche delete(Branche branche);
    
    public Branche findById(Integer id);
    
    public List<Branche> findAll();
    
    public List<Branche> findByMotCle(String motCle);
    
    public Branche findByLibelle(String libelle);
    
    public List<String> findAllLibelles();
}
