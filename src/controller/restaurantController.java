package controller;


import model_ORM.Plat;
import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import services.sessionService;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
		
		restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        tpsmoyen = (Tpsmoyenrepas) ec.getRequestMap().get("tpsmoyenrepas");
        restaurant = (Restaurant) ec.getRequestMap().get("restaurant");
        tpsmoyen.save();
        restaurant.setRestaurateur(restaurateur);
        restaurant.setTpsmoyenrepas(tpsmoyen);
        restaurant.save();
	}
	public List<Plat> getPlatsByRestaurant(){
		List<Plat> plats = new ArrayList <Plat>();
		sessionService session = new sessionService();
		Restaurant rest = new Restaurant();
		Restaurateur restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		List<Restaurant> restaurants = rest.getRestaurant(restaurateur);
		for(Restaurant resto:restaurants){
			List<Plat> pList = (List<Plat>) resto.getPlats();
			for(Plat p:pList){
				plats.add(p);
			}
		}
		return plats;
	}
	public List<Restaurant> getAllRestaurants(){
		sessionService session = new sessionService();
		Restaurant rest = new Restaurant();
		Restaurateur restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		return rest.getRestaurant(restaurateur);
	}
}