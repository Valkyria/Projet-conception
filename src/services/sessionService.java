package services;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import model_ORM.Utilisateur;

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
		return this.session;
	}
	
	public void endSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		this.session = (HttpSession) facesContext.getExternalContext().getSession(false);
		this.session.invalidate();
	}
}
