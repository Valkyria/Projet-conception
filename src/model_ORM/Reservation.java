package model_ORM;
// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1

import java.util.Date;

/**
 * Reservation    generated by hbm2java
 */
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

}
