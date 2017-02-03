package controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import model_ORM.Utilisateur;
import connector_DAO.HibernateSessionFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;


@ManagedBean(name="restaurantController")
@RequestScoped
@ViewScoped
/* Lien entre la vue et le service*/
public class restaurantController 
{
	public void createRestaurant(){
		Utilisateur utilisateur;
		Restaurateur restaurateur;
		Tpsmoyenrepas tpsmoyen;
		Restaurant restaurant;
		restaurateur = new Restaurateur();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        //utilisateur = (Utilisateur) ec.getRequestMap().get("utilisateur");
        
        tpsmoyen = (Tpsmoyenrepas) ec.getRequestMap().get("tpsmoyenrepas");
        restaurant = (Restaurant) ec.getRequestMap().get("restaurant");
        tpsmoyen.save();
        restaurant.setRestaurateur(restaurateur.getRestaurateur(1));
        restaurant.setTpsmoyenrepas(tpsmoyen);
        restaurant.save();
        System.out.println(restaurateur.getRestaurateur(1).getUtilisateur().getPrenomUtilisateur());
	}
}