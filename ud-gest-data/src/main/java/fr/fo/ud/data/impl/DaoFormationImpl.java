package fr.fo.ud.data.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoFormation;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Formation;

@Repository
@Transactional
public class DaoFormationImpl implements IDaoFormation{

    public Formation add(Formation paramFormation) {
        // TODO Auto-generated method stub
        return null;
    }

    public Formation update(Formation paramFormation) {
        // TODO Auto-generated method stub
        return null;
    }

    public Formation delete(Formation paramFormation) {
        // TODO Auto-generated method stub
        return null;
    }

    public Formation findById(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Formation> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Formation> findByMotCle(String paramMotCle) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Formation> findByAdherent(Adherent paramAdherent) {
        // TODO Auto-generated method stub
        return null;
    }

}
