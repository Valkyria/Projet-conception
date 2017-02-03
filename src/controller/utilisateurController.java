package controller;

import model_ORM.Utilisateur;

import java.io.IOException;

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
				System.out.println("ok boss");
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				System.out.println("ok client");
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("login invalide");
		}
		return "gtfo";
	}
}