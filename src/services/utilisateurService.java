package services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import connector_DAO.HibernateSessionFactory;
import model_ORM.Utilisateur;

/* Interroge la base de donnée */

@ManagedBean(name="loginService")
@RequestScoped

public class utilisateurService 
{
	public utilisateurService() 
	{
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public boolean authentification(String login)
	{
		Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(Utilisateur.class);
    	criteria.add(Restrictions.eq("login", login));
    	Object result = criteria.uniqueResult();
        
    	if (result != null) 
        {
            Utilisateur user = (Utilisateur) result;
            System.out.println("Login user = " + user.getLogin());
            tx.commit();
            session.save(user);
        	session.close();
            return true;    
        }
        else
        {
        	return false;
        }
	}
}
