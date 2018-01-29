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
	Syndicat add(Syndicat syndicat);
	
	/**
	 * Methode permettant de modifier un {@link Syndicat} dans l'unit� de persistence.
	 * @param syndicat
	 * @return
	 */
	Syndicat update(Syndicat syndicat);
	
	/**
	 * Methode permettant de supprimer un {@link Syndicat} dans l'unite de persistence.
	 * @param syndicat
	 * @return
	 */
	Syndicat delete(Syndicat syndicat);
	
	/**
	 * Methode permettant de rechercher un {@link Syndicat} selon son identifiant dans l'unite de persistence.
	 * @param id
	 * @return
	 */
	Syndicat getById(Integer id);
	
	/**
	 * Methode permettant de rchercher tous les {@link Syndicat} de l'unit� de persistence.
	 * @return
	 */
	List<Syndicat> getAll();
	
    /**
     * methode permettant de rechercher les {@link Syndicat} selon un mot cl�.
     * @param nom
     * @return
     */
    List<Syndicat> getByMotCle(String motCle);
    
    
}
