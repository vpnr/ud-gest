package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mandat")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mandat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_mandat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "libelle_mandat", nullable = false, length = 100)
    private String libelle;
    
    @OneToMany(mappedBy = "adherent")
    private List<AdherentMandat> adherentmandats;
    
    public Mandat() {
		super();
	}
    
	public Mandat(Integer paramId, String paramLibelle) {
        super();
        id = paramId;
        libelle = paramLibelle;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

	public List<AdherentMandat> getAdherents() {
		return adherentmandats;
	}

	public void setAdherents(List<AdherentMandat> paramAdherents) {
		adherentmandats = paramAdherents;
	}
	
	

}
