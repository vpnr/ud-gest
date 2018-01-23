package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class EntrepriseDetailManagedBean {

	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	@Autowired
	private IBusinessVille buVille;
	
	private List<Ville> villes;
	
	private Entreprise entreprise = new Entreprise();
	
	private HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	@PostConstruct
	public void init(){
		Integer id;
		id = Integer.parseInt(request.getParameter("id"));
		entreprise = buEntreprise.getById(id);
		villes = buVille.getAll();
	}

	public void getVillesByCP(){
		if (entreprise.getVille().getCp() == null) {
			villes = buVille.getAll();
		}
		else {
			villes = buVille.getByCodePostal(entreprise.getVille().getCp());
		}
	}
	
	 public void getCpByVille() {
	        entreprise.setVille(buVille.getById(entreprise.getVille().getId()));
	    }
	
	public void updateEntreprise(){
		buEntreprise.update(entreprise);
	}
	

	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise paramEntreprise) {
		entreprise = paramEntreprise;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest paramRequest) {
		request = paramRequest;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}
	
}
