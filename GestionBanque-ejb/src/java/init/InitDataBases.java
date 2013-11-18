/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import gestionnaires.CompteBancaireFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author Utilisateur
 */
@Startup
@Singleton
@LocalBean
public class InitDataBases {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private CompteBancaireFacade compteBancaireFacade;
    
    @PostConstruct
    public void init(){
        System.out.println("##########ICI init");
        compteBancaireFacade.creerCompteTest();
        
        System.out.println("ICI out init");
        
    }

}
