package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(name="restaurant")
@RequestScoped
@Entity
@Proxy(lazy=false)

public class Restaurant implements java.io.Serializable {

	private Integer idRestaurant;
	private Restaurateur restaurateur;
	private Tpsmoyenrepas tpsmoyenrepas;
	private String nomRestaurant;
	private String adresseRestaurant;
	private String telephoneRestaurant;
	private String emailRestaurant;
	private Date heureOuvertureRestaurant;
	private Date heureFermetureRestaurant;
	private Set plats = new HashSet(0);
	private Set plagefermetures = new HashSet(0);
	private Set villes = new HashSet(0);
	private Set categories = new HashSet(0);

	public Restaurant() {
	}

	public Restaurant(Restaurateur restaurateur, Tpsmoyenrepas tpsmoyenrepas, String nomRestaurant,
			String adresseRestaurant, String telephoneRestaurant, String emailRestaurant, Date heureOuvertureRestaurant,
			Date heureFermetureRestaurant) {
		this.restaurateur = restaurateur;
		this.tpsmoyenrepas = tpsmoyenrepas;
		this.nomRestaurant = nomRestaurant;
		this.adresseRestaurant = adresseRestaurant;
		this.telephoneRestaurant = telephoneRestaurant;
		this.emailRestaurant = emailRestaurant;
		this.heureOuvertureRestaurant = heureOuvertureRestaurant;
		this.heureFermetureRestaurant = heureFermetureRestaurant;
	}

	public Restaurant(Restaurateur restaurateur, Tpsmoyenrepas tpsmoyenrepas, String nomRestaurant,
			String adresseRestaurant, String telephoneRestaurant, String emailRestaurant, Date heureOuvertureRestaurant,
			Date heureFermetureRestaurant, Set plats, Set plagefermetures, Set villes, Set categories) {
		this.restaurateur = restaurateur;
		this.tpsmoyenrepas = tpsmoyenrepas;
		this.nomRestaurant = nomRestaurant;
		this.adresseRestaurant = adresseRestaurant;
		this.telephoneRestaurant = telephoneRestaurant;
		this.emailRestaurant = emailRestaurant;
		this.heureOuvertureRestaurant = heureOuvertureRestaurant;
		this.heureFermetureRestaurant = heureFermetureRestaurant;
		this.plats = plats;
		this.plagefermetures = plagefermetures;
		this.villes = villes;
		this.categories = categories;
	}

	public Integer getIdRestaurant() {
		return this.idRestaurant;
	}

	public void setIdRestaurant(Integer idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public Restaurateur getRestaurateur() {
		return this.restaurateur;
	}

	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}

	public Tpsmoyenrepas getTpsmoyenrepas() {
		return this.tpsmoyenrepas;
	}

	public void setTpsmoyenrepas(Tpsmoyenrepas tpsmoyenrepas) {
		this.tpsmoyenrepas = tpsmoyenrepas;
	}

	public String getNomRestaurant() {
		return this.nomRestaurant;
	}

	public void setNomRestaurant(String nomRestaurant) {
		this.nomRestaurant = nomRestaurant;
	}

	public String getAdresseRestaurant() {
		return this.adresseRestaurant;
	}

	public void setAdresseRestaurant(String adresseRestaurant) {
		this.adresseRestaurant = adresseRestaurant;
	}

	public String getTelephoneRestaurant() {
		return this.telephoneRestaurant;
	}

	public void setTelephoneRestaurant(String telephoneRestaurant) {
		this.telephoneRestaurant = telephoneRestaurant;
	}

	public String getEmailRestaurant() {
		return this.emailRestaurant;
	}

	public void setEmailRestaurant(String emailRestaurant) {
		this.emailRestaurant = emailRestaurant;
	}

	public Date getHeureOuvertureRestaurant() {
		return this.heureOuvertureRestaurant;
	}

	public void setHeureOuvertureRestaurant(Date heureOuvertureRestaurant) {
		this.heureOuvertureRestaurant = heureOuvertureRestaurant;
	}

	public Date getHeureFermetureRestaurant() {
		return this.heureFermetureRestaurant;
	}

	public void setHeureFermetureRestaurant(Date heureFermetureRestaurant) {
		this.heureFermetureRestaurant = heureFermetureRestaurant;
	}

	public Set getPlats() {
		return this.plats;
	}

	public void setPlats(Set plats) {
		this.plats = plats;
	}

	public Set getPlagefermetures() {
		return this.plagefermetures;
	}

	public void setPlagefermetures(Set plagefermetures) {
		this.plagefermetures = plagefermetures;
	}

	public Set getVilles() {
		return this.villes;
	}

	public void setVilles(Set villes) {
		this.villes = villes;
	}

	public Set getCategories() {
		return this.categories;
	}

	public void setCategories(Set categories) {
		this.categories = categories;
	}
	public List <Restaurant> getAll(){

		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Restaurant.class);
		List <Restaurant> r = cr.list();
		tx.commit();
		//session.close();
		return r;
	}
	public List <Restaurant> getRestaurant(Restaurateur restaura){

		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Restaurant.class);
		cr.add(Restrictions.eq("restaurateur", restaura));
		List <Restaurant> r = cr.list();
		tx.commit();
		//session.close();
		return r;
	}
	
	public List <Restaurant> getRestaurant(ActionEvent event){

		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Restaurant.class);
		
		if(tpsmoyenrepas != null){
			cr.add(Restrictions.eq("idTpsMoyenRepas", tpsmoyenrepas));
		}
		if(nomRestaurant != null){
			cr.add(Restrictions.eq("nomRestaurant", nomRestaurant));
		}
		if(adresseRestaurant != null){
			cr.add(Restrictions.eq("adresseRestaurant", adresseRestaurant));
		}
		if(telephoneRestaurant != null){
			cr.add(Restrictions.eq("telephoneRestaurant", telephoneRestaurant));
		}
		if(emailRestaurant != null){
			cr.add(Restrictions.eq("emailRestaurant", emailRestaurant));
		}
		if(heureOuvertureRestaurant != null){
			cr.add(Restrictions.eq("heureOuvertureRestaurant", heureOuvertureRestaurant));
		}
		if(heureFermetureRestaurant != null){
			cr.add(Restrictions.eq("heureFermetureRestaurant", heureFermetureRestaurant));
		}
		List <Restaurant> r = cr.list();
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
