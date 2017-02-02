package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import services.utilisateurService;
import connector_DAO.HibernateSessionFactory;
import model_ORM.Utilisateur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import services.utilisateurService;

@ManagedBean(name="utilisateurController")
@RequestScoped

/* Lien entre la vue et le service*/
public class utilisateurController 
{
	public static void adding_user (String nom){
    	Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
    	Utilisateur u = new Utilisateur(nom,"fazia","0681813399","104 rue test", "mail@mail.com", "mdp0000");
    	u.setPrenomUtilisateur(nom);
    	session.save(u);
    	tx.commit();
    	session.close();
    }
	
	public void verifAuth(String login)
	{
		Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
		utilisateurService uServ = new utilisateurService();
	
		if(uServ.authentification(login)){
			System.out.println("Le login est correct");
		}
		else{
			System.out.println("Utilisateur inconnu");
			
		}
	
		tx.commit();
    	session.close();
	}	
}