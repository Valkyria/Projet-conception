package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;

import connector_DAO.HibernateSessionFactory;

@ManagedBean(name="annonce")
@RequestScoped
@Entity
@Proxy(lazy=false)

public class Annonce implements java.io.Serializable {

	private Integer idAnnonce;
	private Restaurateur restaurateur;
	private Date dateDebutAnnonce;
	private Date dateFinAnnonce;
	private int nbPlaces;
	private int idRestaurant;
	private String nomAnnonce;
	private Set reservations = new HashSet(0);
	private Set creneaus = new HashSet(0);

	public Annonce() {
	}

	public Annonce(Restaurateur restaurateur, Date dateDebutAnnonce, Date dateFinAnnonce, int nbPlaces,
			int idRestaurant, String nomAnnonce) {
		this.restaurateur = restaurateur;
		this.dateDebutAnnonce = dateDebutAnnonce;
		this.dateFinAnnonce = dateFinAnnonce;
		this.nbPlaces = nbPlaces;
		this.idRestaurant = idRestaurant;
	}

	public Annonce(Restaurateur restaurateur, Date dateDebutAnnonce, Date dateFinAnnonce, int nbPlaces,
			int idRestaurant, String nomAnnonce, Set reservations, Set creneaus) {
		this.restaurateur = restaurateur;
		this.dateDebutAnnonce = dateDebutAnnonce;
		this.dateFinAnnonce = dateFinAnnonce;
		this.nbPlaces = nbPlaces;
		this.idRestaurant = idRestaurant;
		this.reservations = reservations;
		this.creneaus = creneaus;
	}

	public Integer getIdAnnonce() {
		return this.idAnnonce;
	}

	public void setIdAnnonce(Integer idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public Restaurateur getRestaurateur() {
		return this.restaurateur;
	}

	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}

	public Date getDateDebutAnnonce() {
		return this.dateDebutAnnonce;
	}

	public void setDateDebutAnnonce(Date dateDebutAnnonce) {
		this.dateDebutAnnonce = dateDebutAnnonce;
	}

	public Date getDateFinAnnonce() {
		return this.dateFinAnnonce;
	}

	public void setDateFinAnnonce(Date dateFinAnnonce) {
		this.dateFinAnnonce = dateFinAnnonce;
	}

	public int getNbPlaces() {
		return this.nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getNomAnnonce(){
		return this.nomAnnonce;
	}
	public String setNomAnnonce(String nomAnnonce){
		return this.nomAnnonce = nomAnnonce;
	}
	public Set getReservations() {
		return this.reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

	public Set getCreneaus() {
		return this.creneaus;
	}

	public void setCreneaus(Set creneaus) {
		this.creneaus = creneaus;
	}
	public List<Annonce> getAll(){
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Annonce.class);
		List <Annonce> r = (List<Annonce>) cr.list();
		tx.commit();
		//session.close();
		return r;
	}
	public void save(){
		Session session = HibernateSessionFactory.currentSession();
	    Transaction tx = session.beginTransaction();
		session.save(this);
	    tx.commit();
	}
}
