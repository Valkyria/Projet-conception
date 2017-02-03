package controller;

import model_ORM.Utilisateur;


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
				return "propage";
			}
			else{
				return "clientpage";
			}
		}
		else{
			System.out.println("login invalide");
		}
		return "gtfo";
	}
}