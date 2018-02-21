package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;

public interface IBusinessFederation {

    public Federation add(Federation federation);
    
    public Federation update(Federation federation);
    
    public Federation delete(int id);
    
    public Federation getById(Integer id);
    
    public List<Federation> getAll();
    
    public List<String> getAllLibelles();
        
    public List<Federation> getByMotCle(String motCle);
    
}
