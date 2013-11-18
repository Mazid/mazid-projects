/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnaires;

import entities.CompteBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Utilisateur
 */
@Stateless
public class CompteBancaireFacade extends AbstractFacade<CompteBancaire> {
    @PersistenceContext(unitName = "GestionBanque-ejbPU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteBancaireFacade() {
        super(CompteBancaire.class);
    }
    
    //fonction qui crée un compte
    public void creerCompte(CompteBancaire compte){
        super.create(compte);
    }
    // fonction qui retourne l'ensemble des comptes bancaires
    public List<CompteBancaire> getAllComptes(){
        return super.findAll();
    }
    // fonction qui crée les comptes de test
   
    public void creerCompteTest(){
        creerCompte(new CompteBancaire("mazid", 1000));
        creerCompte(new CompteBancaire("Marchial", 10000));
        creerCompte(new CompteBancaire("Alfonse", 9999));
        creerCompte(new CompteBancaire("Aliou", 120));
    }
    // fonction pour ajouter l'argent
    
    /**
     * 
     * @param id
     * @param montant 
     */
    public void ajouter(int id, int montant){
        CompteBancaire compteBancaire = super.find(id);
        compteBancaire.deposer(montant);
        em.persist(compteBancaire);
    }
    // fonction pour diminuer de l'argent du compte
    public void diminuer(int id, int montant){
        CompteBancaire compteBancaire = super.find(id);
        compteBancaire.retirer(montant);
        em.persist(compteBancaire);
    }
}
