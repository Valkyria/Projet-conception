package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Reservation;
import model_ORM.Utilisateur;
import services.sessionService;
import connector_DAO.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name="reservationController")
@RequestScoped

/* Lien entre la vue et le service*/
public class reservationController 
{
	public void confirm(){
		sessionService sessionUtil = new sessionService();
		List<Reservation> panier = (List<Reservation>)sessionUtil.getSession().getAttribute("panier");
		for(Reservation item:panier){
			item.save();
		}
		sessionUtil.getSession().setAttribute("panier", new ArrayList<Reservation>());
	}
	
	public void addCart(){
		sessionService sessionUtil = new sessionService();
		List<Reservation> panier = (List<Reservation>)sessionUtil.getSession().getAttribute("panier");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Reservation r = (Reservation) ec.getRequestMap().get("reservation");
		boolean check = true;
		for(Reservation item:panier){
			if((item.getDateReservation() == r.getDateReservation()) && (item.getHeureReservation() == r.getHeureReservation())){
				check = false;
			}
		}
		if(check == true){
			panier.add(r);
			sessionUtil.getSession().setAttribute("panier", panier);
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Vous avez deja une reservation de prévue à ces dates et heures"));
		}
	}
	public void deleteCart(){
		sessionService sessionUtil = new sessionService();
		List<Reservation> panier = (List<Reservation>)sessionUtil.getSession().getAttribute("panier");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Reservation r = (Reservation) ec.getRequestMap().get("reservation");
		panier.remove(r);
		sessionUtil.getSession().setAttribute("panier", panier);
	}
}