package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Syndicat;

/**
 * Definition des services li�es a la persiste pour l'entite {@link Synidcat};
 * @author myPC
 *
 */
public interface IDaoSyndicat {

	/**
	 * Methode permettant d'ajouter un {@link Syndicat} dans l'unite de persistence.
	 * @param syndicat
	 * @return
	 */
	public Syndicat add(Syndicat syndicat);
	
	/**
	 * Methode permettant de modifier un {@link Syndicat} dans l'unit� de persistence.
	 * @param syndicat
	 * @return
	 */
	public Syndicat update(Syndicat syndicat);
	
	/**
	 * Methode permettant de supprimer un {@link Syndicat} dans l'unite de persistence.
	 * @param syndicat
	 * @return
	 */
	public Syndicat delete(Syndicat syndicat);
	
	/**
	 * Methode permettant de rechercher un {@link Syndicat} selon son identifiant dans l'unite de persistence.
	 * @param id
	 * @return
	 */
	public Syndicat findById(Integer id);
	
	/**
	 * Methode permettant de rchercher tous les {@link Syndicat} de l'unit� de persistence.
	 * @return
	 */
	public List<Syndicat> findAll();
	
	public List<String> findAllLibelles();
	
    /**
     * methode permettant de rechercher les {@link Syndicat} selon un mot cl�.
     * @param nom
     * @return
     */
	public List<Syndicat> findByMotCle(String motCle);
    
    
}
