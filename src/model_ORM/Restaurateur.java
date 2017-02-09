package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;
import services.utilityService;

@ManagedBean(name="restaurateur")
@RequestScoped
@Entity
@Proxy(lazy = false)
public class Restaurateur extends Utilisateur implements java.io.Serializable {

	private Integer idRestaurateur;
	private Utilisateur utilisateur;
	private Set annonces = new HashSet(0);
	private Set restaurants = new HashSet(0);

	public Restaurateur() {
	}

	public Restaurateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Restaurateur(Utilisateur utilisateur, Set annonces, Set restaurants) {
		this.utilisateur = utilisateur;
		this.annonces = annonces;
		this.restaurants = restaurants;
	}

	public Integer getIdRestaurateur() {
		return this.idRestaurateur;
	}

	public void setIdRestaurateur(Integer idRestaurateur) {
		this.idRestaurateur = idRestaurateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(Set annonces) {
		this.annonces = annonces;
	}

	public Set getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Set restaurants) {
		this.restaurants = restaurants;
	}
	public Restaurateur getRestaurateur( int idRestaurateur){
		
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Restaurateur.class);
		cr.add(Restrictions.eq("idRestaurateur", idRestaurateur));
		Restaurateur rest = (Restaurateur) cr.uniqueResult();
		tx.commit();
		//session.close();
		
		return rest;
	}

}
