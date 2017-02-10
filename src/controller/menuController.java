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
import connector_DAO.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

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
	private List<Plat> plats;

    public void listPlats() {
        plats = new ArrayList<Plat>();
        addItem();
    }
    public void setListPlats(List<Plat> plats){
    	this.plats = plats;
    }
    public List<Plat> getListPlats(){
    	return this.plats;
    }
    public void addItem() {
        plats.add(new Plat());
    }

	public void createMenu(){
		Menu menu;
		Reduction reduction = new Reduction();
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		menu = (Menu) ec.getRequestMap().get("menu");
        reduction = reduction.getReduction(1);
        System.out.println(reduction.getIdReduction());
        menu.setReduction(reduction);
        menu.save();
	}
}