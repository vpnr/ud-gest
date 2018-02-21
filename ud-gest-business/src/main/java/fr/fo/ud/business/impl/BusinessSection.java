package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessSection;
import fr.fo.ud.data.api.IDaoSection;
import fr.fo.ud.entity.Section;

@Service
public class BusinessSection implements IBusinessSection{

	@Autowired
    private IDaoSection daoSection;

    public Section add(Section paramSection) {
        return daoSection.add(paramSection);
    }

    public Section update(Section paramSection) {
        return daoSection.update(paramSection);
    }

    public Section delete(Section paramSection) {
        return daoSection.delete(paramSection);
    }

    public Section getById(Integer paramId) {
        return daoSection.findById(paramId);
    }

    public List<Section> getAll() {
        return daoSection.findAll();
    }
    
    public List<String> getAllLibelles() {
        return daoSection.findAllLibelles();
    }

    public List<Section> getByMotCle(String paramMotCle) {
        return daoSection.findByMotCle(paramMotCle);
    }
    
}
