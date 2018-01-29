package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Mandat;

public interface IBusinessFonction {

    Mandat add(Mandat fonction);
    Mandat update(Mandat fonction);
    Mandat delete(Mandat fonction);
    List<Mandat> getAll();
    List<Mandat> getByMotCle(String motCle);
    Mandat getById(Integer id);
    
}
