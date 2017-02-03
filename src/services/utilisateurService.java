package services;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import connector_DAO.HibernateSessionFactory;
import model_ORM.Utilisateur;


@ManagedBean(name="utilisateurService")
@RequestScoped

public class utilisateurService 
{
	private static String login;
    private static String mdp;
    
	public utilisateurService() 
	{
		// TODO Auto-generated constructor stub
	}
}
