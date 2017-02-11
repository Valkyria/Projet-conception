package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Menu;
import model_ORM.Plat;
import model_ORM.Reduction;
import model_ORM.Restaurant;
import model_ORM.Restaurateur;
import model_ORM.Tpsmoyenrepas;
import model_ORM.Utilisateur;
import services.sessionService;
import connector_DAO.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name="menuController")
@RequestScoped

/* Lien entre la vue et le service*/
public class menuController 
{
	private static final List <String> plats = new ArrayList<String>();
	String platName;
	List<Restaurant> restaus;
	Restaurant resto;
	
	@PostConstruct
    public void init() {
		sessionService session = new sessionService();
		Restaurant resto = new Restaurant();
		Restaurateur r = (Restaurateur)session.getSession().getAttribute("pro");
		restaus = resto.getRestaurant(r);
    }
	
	public Restaurant getResto(){
		return this.resto;
	}
	public void setResto(Restaurant r){
		resto = r;
	}
	public List<Restaurant> getRestaus(){
		return this.restaus;
	}
	public void setRestaus(List<Restaurant> restaus){
		this.restaus = restaus;
	}
	public void addPlat() {
		System.out.println("ajout de " + platName);
		System.out.println(plats.size());
		plats.add(platName);
	}
	public void deletePlat(String plat) {
		plats.remove(plat);
	}
	public void clearPlat() {
		plats.clear();
	}
	public List<String> getPlats() {
		return plats;
	}
	public String getPlatName(){
		return this.platName;
	}
	public void setPlatName(String platName){
		this.platName = platName;
	}
	public void createMenu(){
		sessionService session = new sessionService();
		resto = new Restaurant();
		Restaurateur r = (Restaurateur)session.getSession().getAttribute("pro");
		restaus = resto.getRestaurant(r);
		for(Restaurant rest : restaus){
			resto = rest;
		}
		Reduction reduction = new Reduction();
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Menu menu = (Menu) ec.getRequestMap().get("menu");

        reduction = reduction.getReduction(1);
        menu.setReduction(reduction);
        menu.save();
        System.out.println(resto.getEmailRestaurant());
        for(String plat:plats){
        	Plat p = new Plat(menu, resto, plat);
        	p.save();
        }
	}
}