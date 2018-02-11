package fr.fo.ud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "event")
public class Event {

	@Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "description_event", nullable = false, length = 2)
    private String description;
    
    @Column(name = "date_debut", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;
    
    @Column(name = "date_fin", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateFin;
    
    public Event() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", description=" + description + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ "]";
	}
	
}
