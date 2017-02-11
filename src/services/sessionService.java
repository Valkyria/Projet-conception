package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model_ORM.Utilisateur;
import model_ORM.Reservation;

@ManagedBean(name="sessionservice")
@RequestScoped
public class sessionService {
	private HttpSession session;
	
	public void newSession(Utilisateur u){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("id", u.getIdUtilisateur());
		session.setAttribute("mail", u.getLogin());
		session.setAttribute("mdp", u.getMotdePasse());
		session.setAttribute("nom", u.getNomUtilisateur());
		session.setAttribute("prenom", u.getPrenomUtilisateur());
		session.setAttribute("tel", u.getTelephoneUtilisateur());
		session.setAttribute("panier", new ArrayList<Reservation>());
		if(u.getRestaurateur() != null){
			session.setAttribute("pro", u.getRestaurateur());
			session.setAttribute("type", "pro");
		}
		else{
			session.setAttribute("pro", null);
			session.setAttribute("type", "cli");
		}
	}
	public HttpSession getSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (HttpSession) facesContext.getExternalContext().getSession(false);
	}
	
	public void endSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.session = (HttpSession) facesContext.getExternalContext().getSession(false);
		this.session.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Projet-conception/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addCartItem(Reservation item){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.session = (HttpSession) facesContext.getExternalContext().getSession(false);
		List<Reservation> panier = (List<Reservation>)this.session.getAttribute("panier");
		panier.add(item);
		session.setAttribute("panier", panier);
	}
	public void removeCartItem(Reservation item){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.session = (HttpSession) facesContext.getExternalContext().getSession(false);
		List<Reservation> panier = (List<Reservation>)this.session.getAttribute("panier");
		panier.remove(item);
		session.setAttribute("panier", panier);
	}
}
