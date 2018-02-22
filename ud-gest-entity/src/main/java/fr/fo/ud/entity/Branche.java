package fr.fo.ud.entity;

import java.io.Serializable;
import java.util.List;

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

@Entity
@Table(name = "branche")
public class Branche implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_branche")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "libelle_branche", nullable = false, length = 45)
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_federation_branche", nullable = true)
    private Federation federation;
    
    @JsonIgnore
    @OneToMany(mappedBy = "branche")
    private List<Syndicat> syndicats;
    
    @JsonIgnore
    @OneToMany(mappedBy = "branche")
    private List<Event> events;

	public Branche() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer paramId) {
		id = paramId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Federation getFederation() {
		return federation;
	}

	public void setFederation(Federation paramFederation) {
		federation = paramFederation;
	}

	public List<Syndicat> getSyndicats() {
		return syndicats;
	}

	public void setSyndicats(List<Syndicat> paramSyndicats) {
		syndicats = paramSyndicats;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
    
}
