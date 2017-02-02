package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model_ORM.Utilisateur;
import connector_DAO.HibernateSessionFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="menuController")
@RequestScoped

/* Lien entre la vue et le service*/
public class menuController 
{
	public static void get_user (String nom){
    	Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
    	Utilisateur u = new Utilisateur(nom,"fazia","0681813399","104 rue test", "mail@mail.com", "mdp0000");
    	u.setPrenomUtilisateur(nom);
    	session.save(u);
    	tx.commit();
    	session.close();
    }
}