package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Entreprise;

/**
 * Definition des services liees a la persistence pour l'entite {@link Entreprise}.
 * @author myPC
 *
 */
public interface IDaoEntreprise {

	/**
	 * Methode permettant d'ajouter une {@link Entreprise} dans l'unite de persistence.
	 * @param entreprise
	 * @return
	 */
	public Entreprise add(Entreprise entreprise);
	
	/**
	 * Methode permettant de modifier une {@link Entreprise} dans l'unite de persistence.
	 * @param entreprise
	 * @return
	 */
	public Entreprise update(Entreprise entreprise);
	
	/**
	 * Methode permettant de supprimer une {@link Entreprise} dans l'unite de persitence.
	 * @param entreprise
	 * @return
	 */
	public Entreprise delete(Entreprise entreprise);
	
	/**
	 * methode permettant de recuperer une liste de touts les entreprises de l'unite de persistence.
	 * @return
	 */
	public List<Entreprise> findAll();
	
	/**
	 * methode permettant de rechercher une {@link Entreprise} selon son id dans l'unite de persistence.
	 * @param id
	 * @return
	 */
	public Entreprise findById(Integer id);
	
	/**
	 * methode permettant de rechercher une {@link Entreprise} selon son libelle dans l'unite de persistence.
	 * @param libelle
	 * @return
	 */
	public Entreprise findByLibelle(String libelle);
	
    /**
     * Methode permettant de rechercher des {@link Entreprise} selon un mot cle.
     * @param motCle
     * @return
     */
	public List<Entreprise> findByMotCle(String motCle);
	
	public List<String> findAllLibelles();
    
	public List<String> findAllLibelleByMotCle(String motCle);
	
	public Long count(String libelle);
    
}
