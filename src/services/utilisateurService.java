package services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connector_DAO.HibernateSessionFactory;
import model_ORM.Utilisateur;

/* Interroge la base de donnée */

@ManagedBean(name="loginService")
@RequestScoped

public class utilisateurService 
{
	public void authentification()
	{
		Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
    	
    	
    	
    	
    	/*Utilisateur u = new Utilisateur(nom,"fazia","0681813399","104 rue test", "mail@mail.com", "mdp0000");
    	u.setPrenomUtilisateur(nom);
    	session.save(u);
    	tx.commit();*/
    	session.close();
	}
}
