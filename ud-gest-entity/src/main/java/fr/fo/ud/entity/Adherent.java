package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe representant la table {@link Adherent}.
 * @author myPC
 *
 */

@Entity
@Table(name = "adherent")
public class Adherent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_adherent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom_adherent", nullable = false, length = 45)
    private String nom;
    
    @Column(name = "prenom_adherent", nullable = true, length = 45)
    private String prenom;
    
    @Column(name = "dob_adherent", nullable = true)
    private Date dob;
    
    @Column(name = "numero_rue", nullable = true, length = 10)
    private String numeroRue;
    
    @Column(name = "libelle_rue", nullable = true, length = 150)
    private String libelleRue;
    
    @Column(name = "cp_adherent", nullable = true, length = 150)
    private String cp;
    
    @Column(name = "ville_adherent", nullable = true, length = 150)
    private String ville;
    
    @Column(name = "tel_adherent", nullable = true, length = 15)
    private String tel;
    
    @Column(name = "mail_adherent", nullable = true, length = 100)
    private String mail;
    
    @ManyToOne
    @JoinColumn(name = "id_syndicat_adherent", nullable = true)
    private Syndicat syndicat;
    
    @ManyToOne
    @JoinColumn(name = "id_entreprise_adherent", nullable = true)
    private Entreprise entreprise;
    
    @JsonIgnore
    @OneToMany(mappedBy = "mandat")
    private List<AdherentMandat> mandats;
    
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<AdherentFormation> formations;
    
    public Adherent() {
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param paramPrenom the prenom to set
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param paramDob the dob to set
     */
    public void setDob(Date paramDob) {
        dob = paramDob;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param paramTel the tel to set
     */
    public void setTel(String paramTel) {
        tel = paramTel;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param paramMail the mail to set
     */
    public void setMail(String paramMail) {
        mail = paramMail;
    }
    
	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getLibelleRue() {
		return libelleRue;
	}

	public void setLibelleRue(String libelleRue) {
		this.libelleRue = libelleRue;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Syndicat getSyndicat() {
		return syndicat;
	}

	public void setSyndicat(Syndicat syndicat) {
		this.syndicat = syndicat;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<AdherentMandat> getMandats() {
		return mandats;
	}

	public void setMandats(List<AdherentMandat> mandats) {
		this.mandats = mandats;
	}

	public List<AdherentFormation> getFormations() {
		return formations;
	}

	public void setFormations(List<AdherentFormation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dob=" + dob + ", numeroRue="
				+ numeroRue + ", libelleRue=" + libelleRue + ", cp=" + cp + ", ville=" + ville + ", tel=" + tel
				+ ", mail=" + mail + ", syndicat=" + syndicat + ", entreprise=" + entreprise + ", mandats="
				+ mandats + ", formations=" + formations + "]";
	}

	
	
}
