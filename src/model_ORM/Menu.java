package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.HashSet;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;

import connector_DAO.HibernateSessionFactory;

@ManagedBean(name="menu")
@RequestScoped
@Entity
@Proxy(lazy=false)

public class Menu implements java.io.Serializable {

	private Integer idMenu;
	private Reduction reduction;
	private double prixMenu;
	private String nomMenu;
	private Set plats = new HashSet(0);

	public Menu() {
	}

	public Menu(Reduction reduction, double prixMenu) {
		this.reduction = reduction;
		this.prixMenu = prixMenu;
	}

	public Menu(Reduction reduction, double prixMenu, Set plats) {
		this.reduction = reduction;
		this.prixMenu = prixMenu;
		this.plats = plats;
	}

	public Integer getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public Reduction getReduction() {
		return this.reduction;
	}

	public void setReduction(Reduction reduction) {
		this.reduction = reduction;
	}

	public double getPrixMenu() {
		return this.prixMenu;
	}

	public void setPrixMenu(double prixMenu) {
		this.prixMenu = prixMenu;
	}
	public String getNomMenu(){
		return this.nomMenu;
	}
	public void setNomMenu(String nomMenu){
		this.nomMenu = nomMenu;
	}
	public Set getPlats() {
		return this.plats;
	}

	public void setPlats(Set plats) {
		this.plats = plats;
	}
	public void save(){
		Session session = HibernateSessionFactory.currentSession();
	    Transaction tx = session.beginTransaction();
		session.save(this);
	    tx.commit();
	}

}
