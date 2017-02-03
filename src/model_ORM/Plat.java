package model_ORM;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;

@ManagedBean(name="plat")
@RequestScoped
@Entity

public class Plat implements java.io.Serializable {
	
	private Integer idPlat;
	private Menu menu;
	private Restaurant restaurant;
	private String nomPlat;

	public Plat() {
	}

	public Plat(Menu menu, Restaurant restaurant, String nomPlat) {
		this.menu = menu;
		this.restaurant = restaurant;
		this.nomPlat = nomPlat;
	}

	public Integer getIdPlat() {
		return this.idPlat;
	}

	public void setIdPlat(Integer idPlat) {
		this.idPlat = idPlat;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getNomPlat() {
		return this.nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public List<Plat> getAll(){
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Restaurant.class);
		List<Plat> plat_array = (List<Plat>) cr.list();
		tx.commit();
		return plat_array;
	}
}
