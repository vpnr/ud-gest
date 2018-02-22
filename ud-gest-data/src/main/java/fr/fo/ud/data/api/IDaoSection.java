package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Section;

public interface IDaoSection {

    public Section add(Section section);
    
    public Section update(Section section);

    public Section delete(Section section);
    
    public Section findById(Integer id);
    
    public List<Section> findAll();
    
    public Section findByLibelle(String libelle);
    
    public List<String> findAllLibelles();
    
    public List<Section> findByMotCle(String motCle);
}
