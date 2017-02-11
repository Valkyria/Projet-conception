package controller;

import model_ORM.Annonce;
import model_ORM.Reservation;
import model_ORM.Restaurant;
import model_ORM.Utilisateur;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import services.sessionService;

@ManagedBean(name="utilisateurController")
@RequestScoped

/* Lien entre la vue et le service*/
public class utilisateurController 
{
	private List<Restaurant> restaurants;
	private List<Annonce> annonces;
	private List<Reservation> reservations;
	
	@PostConstruct
    public void init() {
		annonces = this.getAllAnnonces();
		restaurants = this.getAllRestaurants();
    }
	
	public void login(){
		Utilisateur u;
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		u = (Utilisateur) ec.getRequestMap().get("utilisateur");
		u = u.getUtilisateur(u.getLogin(), u.getMotdePasse());
		if(u != null){
			sessionService session = new sessionService();
			session.newSession(u);
			if(session.getSession().getAttribute("pro") != null){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/Projet-conception/Views/utilisateur/restaurateur/restaurateur_index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("/Projet-conception/Views/utilisateur/client/client_index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Login/password incorrects."));
		}
	}
	public void logout(){
		sessionService session = new sessionService();
		session.endSession();
	}
	public List<Annonce> getAnnonces(){
		return this.annonces;
	}
	public List<Restaurant> getRestaurants(){
		return this.restaurants;
	}
	public List<Restaurant> getAllRestaurants(){
		Restaurant resto = new Restaurant();
		return resto.getAll();
	}
	public List<Annonce> getAllAnnonces(){
		Annonce anno = new Annonce();
		return anno.getAll();
	}
}