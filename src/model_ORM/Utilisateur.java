package model_ORM;

// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import connector_DAO.HibernateSessionFactory;
import services.utilityService;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import services.utilityService;


@ManagedBean(name="utilisateur")
@RequestScoped
@Entity
public class Utilisateur implements java.io.Serializable {

	private Integer idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String telephoneUtilisateur;
	private String adresseUtilisateur;
	private String login;
	private String motdePasse;
	private Restaurateur restaurateur;
	private Client client;

	public Utilisateur() {
	}

	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String telephoneUtilisateur,
			String adresseUtilisateur, String login, String motdePasse) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.telephoneUtilisateur = telephoneUtilisateur;
		this.adresseUtilisateur = adresseUtilisateur;
		this.login = login;
		this.motdePasse = motdePasse;
	}

	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String telephoneUtilisateur,
			String adresseUtilisateur, String login, String motdePasse, Restaurateur restaurateur, Client client) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.telephoneUtilisateur = telephoneUtilisateur;
		this.adresseUtilisateur = adresseUtilisateur;
		this.login = login;
		this.motdePasse = motdePasse;
		this.restaurateur = restaurateur;
		this.client = client;
	}

	public Integer getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return this.prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getTelephoneUtilisateur() {
		return this.telephoneUtilisateur;
	}

	public void setTelephoneUtilisateur(String telephoneUtilisateur) {
		this.telephoneUtilisateur = telephoneUtilisateur;
	}

	public String getAdresseUtilisateur() {
		return this.adresseUtilisateur;
	}

	public void setAdresseUtilisateur(String adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdePasse() {
		return this.motdePasse;
	}

	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}

	public Restaurateur getRestaurateur() {
		return this.restaurateur;
	}

	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void getUtilisateur(ActionEvent event)
	{
		String encrypted_pw;
		
		utilityService util = new utilityService();
		try {
			encrypted_pw = util.stringHash(motdePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Utilisateur.class);
		cr.add(Restrictions.eq("login", login));
		cr.add(Restrictions.eq("motdePasse", motdePasse));
		Utilisateur u = (Utilisateur) cr.uniqueResult();
		System.out.println("Utilisateur = "+ u.getNomUtilisateur());
		tx.commit();
		session.close();
	}
}
