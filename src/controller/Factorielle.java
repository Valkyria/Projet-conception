package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model_ORM.Utilisateur;
import connector_DAO.HibernateSessionFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="Factorielle")
@RequestScoped

public class Factorielle {
    public static String calculFactorielle (int valeur) throws Exception{
        String result = "";
        int res=1;
        if(valeur <= 0){
            throw new Exception("Chiffre negatif");
        }
        for(int i=1; i<=valeur; i++) {
            result=result+""+res+"*"+i+"="+(res*i)+"<br/>";
            res=res*i;
        }
        return result;
    }
    public static void adding_user (String nom){
    	Session session = HibernateSessionFactory.currentSession();
    	Transaction tx = session.beginTransaction();
    	Utilisateur u = new Utilisateur(nom,"soraya","0681813399","104 rue test", "mail@mail.com", "mdp0000");
    	u.setPrenomUtilisateur(nom);
    	session.save(u);
    	tx.commit();
    	session.close();
    }
}

