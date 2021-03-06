package controller;


import model_ORM.Annonce;
import model_ORM.Plat;
import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import services.sessionService;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
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
	private List<Plat> plats;
	List<Restaurant> restaurants;
	List<Annonce> annonces;
	
	@PostConstruct
    public void init() {
		plats = this.getPlatsByRestaurant();
		restaurants = this.getAllRestaurants();
		annonces = this.getAllAnnonces();
    }
	
	public List<Plat> getPlats(){
		return this.plats;
	}
	public List<Restaurant> getRestaurants(){
		return this.restaurants;
	}
	public List<Annonce> getAnnonces(){
		return this.annonces;
	}
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
			Set<Plat> pList = resto.getPlats();
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
	public List<Annonce> getAllAnnonces(){
		sessionService session = new sessionService();
		Restaurant rest = new Restaurant();
		Restaurateur restaurateur = (Restaurateur) session.getSession().getAttribute("pro");
		//List <Annonce> annonces = (List<Annonce>) restaurateur.getAnnonces();
		return annonces;
	}
}