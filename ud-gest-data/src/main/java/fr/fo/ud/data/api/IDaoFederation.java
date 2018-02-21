package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Federation;

public interface IDaoFederation {

    public Federation add(Federation federation);
    
    public Federation update(Federation federation);
    
    public Federation delete(Federation federation);
    
    public List<Federation> findAll();
    
    public List<String> findAllLibelles();
    
    public Federation findById(Integer id);
    
    public List<Federation> findByMotCle(String motCle);
}
