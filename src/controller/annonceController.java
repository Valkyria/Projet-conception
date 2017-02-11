package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Annonce;
import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import model_ORM.Utilisateur;
import services.sessionService;
import connector_DAO.HibernateSessionFactory;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name="annonceController")
@RequestScoped

/* Lien entre la vue et le service*/
public class annonceController 
{
	public void createAnnonce(){
		Restaurateur restaurateur;
		
		sessionService session = new sessionService();
		
		restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Annonce annonce = (Annonce) ec.getRequestMap().get("annonce");
        annonce.setRestaurateur(restaurateur);
        List <Restaurant> restaurants = (List<Restaurant>) restaurateur.getRestaurants();
        for(Restaurant resto : restaurants){
        	annonce.setIdRestaurant(resto.getIdRestaurant());
        }
        annonce.save();
	}
}