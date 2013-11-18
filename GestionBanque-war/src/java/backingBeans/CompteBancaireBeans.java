/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import entities.CompteBancaire;
import gestionnaires.CompteBancaireFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Utilisateur
 */
@Named(value = "compteBeans")
@RequestScoped
public class CompteBancaireBeans  implements Serializable{
    @EJB
    private CompteBancaireFacade compteBancaireFacade;
    private CompteBancaire compte;
    private int id;
    private int montant;
    private int typeOpera;
    private int idDebiteur, idCrediteur;
    
    
    /**
     * Creates a new instance of CompteBancaireBeans
     */
    public CompteBancaireBeans() {
        
    }

    public int getIdDebiteur() {
        return idDebiteur;
    }

    public void setIdDebiteur(int idDebiteur) {
        this.idDebiteur = idDebiteur;
    }

    public int getIdCrediteur() {
        return idCrediteur;
    }

    public void setIdCrediteur(int idCrediteur) {
        this.idCrediteur = idCrediteur;
    }

    public int getTypeOpera() {
        return typeOpera;
    }

    public void setTypeOpera(int typeOpera) {
        this.typeOpera = typeOpera;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    // fonction qui recupere la liste des comptes bancaires
    public List<CompteBancaire> getAllComptes(){
        System.out.println("##################### all");
        return compteBancaireFacade.getAllComptes();
        
    }
    // fonction pour ajouter les sous
    public String ajouterMontant(){
        System.out.println("ghhhhhhhhhh");
        compteBancaireFacade.ajouter(id, montant);
        System.out.println("Le montant est : "+montant);
        return "index?faces-redirect=true";
        
    }
    // fonction pour diminuer le solde
    public String soustraireMontant(){
        compteBancaireFacade.diminuer(id, montant);
        return "index?faces-redirect=true";
    }
    /**
     * 
     */
    public String afficheCompte(int id){
        this.id = id;
        System.out.println("Je suis degouté vrement  "+id);
        return "formulaire-operation?faces-redirect=true&amp;includeViewParams=true&amp;";
    }
    /**
     * 
     */
    public String executerOperation(){
        
        if(typeOpera==1){
            compteBancaireFacade.ajouter(id, montant);
        }
        if(typeOpera==2){
            compteBancaireFacade.diminuer(id, montant);
        }
        System.out.println("Le montant est  "+montant + "  est type est "+typeOpera);
        return "index?faces-redirect=true";
    }
    
}
