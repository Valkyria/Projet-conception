package controller;

import model_ORM.Utilisateur;

import java.io.IOException;

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
	public String login(){
		Utilisateur u;
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		u = (Utilisateur) ec.getRequestMap().get("utilisateur");
		u = u.getUtilisateur(u.getLogin(), u.getMotdePasse());
		if(u != null){
			sessionService session = new sessionService();
			session.newSession(u);
			if(session.getSession().getAttribute("pro") != null){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("Views/utilisateur/view_restaurateur.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("Views/utilisateur/view_client.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Login/password incorrects."));
		}
		return "gtfo";
	}
	public void logout(){
		sessionService session = new sessionService();
		session.endSession();
	}
}