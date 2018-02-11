package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Section;

public interface IBusinessSection {

    public Section add(Section section);
    
    public Section update(Section section);
    
    public Section delete(Section section);
    
    public Section getById(Integer id);
    
    public List<Section> getAll();
    
    public List<Section> getByMotCle(String motCle);
}
