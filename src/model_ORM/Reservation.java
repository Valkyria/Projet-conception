package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;
import services.sessionService;

@ManagedBean(name="reservation")
@RequestScoped
@Entity
@Proxy(lazy=false)

public class Reservation implements java.io.Serializable {

	private Integer idReservation;
	private Annonce annonce;
	private Client client;
	private Date dateReservation;
	private Date heureReservation;
	private Date heureReservationE;
	private String evenementReservation;

	public Reservation() {
	}

	public Reservation(Annonce annonce, Client client, Date dateReservation) {
		this.annonce = annonce;
		this.client = client;
		this.dateReservation = dateReservation;
	}

	public Reservation(Annonce annonce, Client client, Date dateReservation, Date heureReservation,
			Date heureReservationE, String evenementReservation) {
		this.annonce = annonce;
		this.client = client;
		this.dateReservation = dateReservation;
		this.heureReservation = heureReservation;
		this.heureReservationE = heureReservationE;
		this.evenementReservation = evenementReservation;
	}

	public Integer getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Annonce getAnnonce() {
		return this.annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateReservation() {
		return this.dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getHeureReservation() {
		return this.heureReservation;
	}

	public void setHeureReservation(Date heureReservation) {
		this.heureReservation = heureReservation;
	}

	public Date getHeureReservationE() {
		return this.heureReservationE;
	}

	public void setHeureReservationE(Date heureReservationE) {
		this.heureReservationE = heureReservationE;
	}

	public String getEvenementReservation() {
		return this.evenementReservation;
	}

	public void setEvenementReservation(String evenementReservation) {
		this.evenementReservation = evenementReservation;
	}
	public void save(){
		Session session = HibernateSessionFactory.currentSession();
	    Transaction tx = session.beginTransaction();
		session.save(this);
	    tx.commit();
	}
	public void delete()
	{
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		session.delete(this);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Projet-conception/index.xhtml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "erreur lors de la suppression."));
		tx.commit();
	}
	public List <Reservation> getAll(){

		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Reservation.class);
		List <Reservation> r = cr.list();
		tx.commit();
		//session.close();
		return r;
	}
	public List <Reservation> getAllbyClient(Client client){
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Reservation.class);
		cr.add(Restrictions.eq("client", client));
		List <Reservation> r = cr.list();
		tx.commit();
		//session.close();
		return r;
	}
}
