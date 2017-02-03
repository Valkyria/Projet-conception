package controller;

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
		System.out.println("getmethod");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        //utilisateur = (Utilisateur) ec.getRequestMap().get("utilisateur");
        //restaurateur = (Restaurateur) ec.getRequestMap().get("restaurateur");
        tpsmoyen = (Tpsmoyenrepas) ec.getRequestMap().get("tpsmoyenrepas");
        restaurant = (Restaurant) ec.getRequestMap().get("restaurant");
        tpsmoyen.save();
        restaurant.setTpsmoyenrepas(tpsmoyen);
        restaurant.save();
        System.out.println(tpsmoyen.getDureeEvenement());
	}
}