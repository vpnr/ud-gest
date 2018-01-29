package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adherent_mandat")
public class AdherentMandat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_adherent")
	private Adherent adherent;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "id_mandat")
    private Mandat mandat;
	
	@Column(name = "date_debut_mandat", nullable = true)
	private Date dateDebut;
	
	@Column(name = "date_fin_mandat", nullable = true)
	private Date dateFin;

    public AdherentMandat() {
        super();
    }

    public AdherentMandat(Adherent paramAdherent, Mandat paramMandat, Date paramDateDebut, Date paramDateFin) {
        super();
        adherent = paramAdherent;
        mandat = paramMandat;
        dateDebut = paramDateDebut;
        dateFin = paramDateFin;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent paramAdherent) {
        adherent = paramAdherent;
    }

    public Mandat getmandat() {
        return mandat;
    }

    public void setmandat(Mandat paramMandat) {
        mandat = paramMandat;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date paramDateDebut) {
        dateDebut = paramDateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date paramDateFin) {
        dateFin = paramDateFin;
    }

}
