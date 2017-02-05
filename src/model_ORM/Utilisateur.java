package model_ORM;

// Generated 29 janv. 2017 01:16:12 by Hibernate Tools 5.2.0.CR1
import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import connector_DAO.HibernateSessionFactory;
import controller.utilisateurController;
import services.sessionService;
import services.utilityService;

import java.io.IOException;
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
@Proxy(lazy=false)

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

	public Utilisateur(String login, String password)
	{
		this.login = login;
		this.motdePasse = password;
	}
	
	public Utilisateur(String login)
	{
		this.login = login;
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

	public Utilisateur getUtilisateur(String mail, String mdp)
	{
		String encrypted_pw;
		
		utilityService util = new utilityService();
		try {
				encrypted_pw = util.stringHash(mdp);
				Session session = HibernateSessionFactory.currentSession();
				Transaction tx = session.beginTransaction();
				Criteria cr = session.createCriteria(Utilisateur.class);
				cr.add(Restrictions.eq("login",mail));
				cr.add(Restrictions.eq("motdePasse", encrypted_pw));
				Utilisateur u = (Utilisateur) cr.uniqueResult();
				
				tx.commit();
				
				return u;
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public Utilisateur getUtilisateur(String mail)
	{
				
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Utilisateur.class);
		cr.add(Restrictions.eq("login", mail));
		Utilisateur u = (Utilisateur) cr.uniqueResult();
		tx.commit();
				
		return u;

	}
	public void addUtilisateur(ActionEvent e){
		utilityService util = new utilityService();
    	Session session = HibernateSessionFactory.currentSession();
    	Utilisateur u;
    	sessionService userSession = new sessionService();

    	if(this.getUtilisateur(login) == null){
    		try 
    		{
    			u = new Utilisateur(nomUtilisateur,prenomUtilisateur,telephoneUtilisateur,adresseUtilisateur, login, util.stringHash(motdePasse));
    			Transaction tx = session.beginTransaction();
    			session.save(u);
    			tx.commit();
    			userSession.newSession(u);
    			if(userSession.getSession().getAttribute("type") == "pro"){
    				FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
    			}
    			else{
    				FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
    			}
    			

    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
    	}
    	else{
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "mail deja utilisé."));
    	}
    	
    }
	
	public void updateUtilisateur(ActionEvent e)
	{
		
		String encrypted_pw;
		utilityService util = new utilityService();
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		sessionService userSession = new sessionService();
		Utilisateur u = this.getUtilisateur((String)userSession.getSession().getAttribute("mail"));
		try 
		{
			encrypted_pw = util.stringHash(motdePasse);
			session.update(u);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		tx.commit();	
	}
	
	public void deleteUtilisateur(ActionEvent e)
	{
		sessionService userSession = new sessionService();
		Utilisateur u1 = this.getUtilisateur(login);
		Utilisateur u2 = this.getUtilisateur((String)userSession.getSession().getAttribute("mail"));
		Session session = HibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction();
		if(u1.equals(u2)){
			session.delete(u1);
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "mail de confirmation incorrect."));
		}
		tx.commit();
	}
	
	
}
