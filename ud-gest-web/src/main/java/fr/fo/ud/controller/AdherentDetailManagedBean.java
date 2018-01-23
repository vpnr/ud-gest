package fr.fo.ud.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class AdherentDetailManagedBean {

	@Autowired
	private IBusinessAdherent buAdherent;
	
	@Autowired
	private IBusinessVille buVille;
	
	private Adherent adherent = new Adherent();
	
	private List<Ville> villes;
	
	private HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	public void init(){
		Integer id;
		id = Integer.parseInt(request.getParameter("id"));
		adherent = buAdherent.getById(id);
		villes = buVille.getAll();
	}
	
	public void getVillesByCP(){
		if (adherent.getVille().getCp() == null) {
			villes = buVille.getAll();
		}
		else {
			villes = buVille.getByCodePostal(adherent.getVille().getCp());
		}
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent paramAdherent) {
		adherent = paramAdherent;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}
	
}
