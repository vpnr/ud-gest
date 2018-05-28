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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event")
public class Event  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "title_event", nullable = false, length = 50)
    private String title;
	
    @Column(name = "description_event", nullable = false, length = 300)
    private String description;
    
    @Column(name = "start", nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date start;
    
    @Column(name = "end", nullable = true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date end;
    
    @ManyToOne
    @JoinColumn(name = "id_event_entreprise", nullable = true)
    private Entreprise entreprise;
    
    @ManyToOne
    @JoinColumn(name = "id_event_federation", nullable = true)
    private Federation federation;
    
    @ManyToOne
    @JoinColumn(name = "id_event_syndicat", nullable = true)
    private Syndicat syndicat;
    
    @ManyToOne
    @JoinColumn(name = "id_event_ud", nullable = true)
    private UnionDepartemental ud;
    
    public Event() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Federation getFederation() {
		return federation;
	}

	public void setFederation(Federation federation) {
		this.federation = federation;
	}

	public Syndicat getSyndicat() {
		return syndicat;
	}

	public void setSyndicat(Syndicat syndicat) {
		this.syndicat = syndicat;
	}

	public UnionDepartemental getUd() {
		return ud;
	}

	public void setUd(UnionDepartemental ud) {
		this.ud = ud;
	}
	
}
