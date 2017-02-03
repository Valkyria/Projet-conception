package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Menu;
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
	private List<String> plats;

    @PostConstruct
    public void init() {
        plats = new ArrayList<String>();
        plats.add("");
    }

    public void submit() {
        // save values in database
    }

    public void extend() {
        plats.add("");
    }

    public void setValues(List<String> values) {
        this.plats = values;
    }

    public List<String> getValues() {
        return plats;
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