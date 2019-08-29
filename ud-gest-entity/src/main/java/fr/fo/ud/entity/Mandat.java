package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mandat")
public class Mandat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_mandat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "libelle_mandat", nullable = false, length = 100)
    @Size(min=1, max=100, message="Le libellé de l'entreprise ne doit pas être vide.")
    @Pattern(regexp="(^[A-Za-z0-9 \\é\\à\\â\\î\\ê\\è\\ô\\û\\ö\\ï\\ë\\ä_-]*$)", message="Les caractères spéciaux ne sont pas autorisés.")
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
