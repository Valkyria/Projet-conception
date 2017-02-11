package controller;


import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import services.sessionService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


@ManagedBean(name="restaurantController")
@RequestScoped
@ViewScoped
/* Lien entre la vue et le service*/
public class restaurantController 
{
	public void createRestaurant(){
		Restaurateur restaurateur;
		Tpsmoyenrepas tpsmoyen;
		Restaurant restaurant;
		sessionService session = new sessionService();
		System.out.println(session.getSession().getAttribute("nom"));
		restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		System.out.println(restaurateur.getUtilisateur().getLogin());
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        tpsmoyen = (Tpsmoyenrepas) ec.getRequestMap().get("tpsmoyenrepas");
        restaurant = (Restaurant) ec.getRequestMap().get("restaurant");
        tpsmoyen.save();
        restaurant.setRestaurateur(restaurateur);
        restaurant.setTpsmoyenrepas(tpsmoyen);
        restaurant.save();
	}
}