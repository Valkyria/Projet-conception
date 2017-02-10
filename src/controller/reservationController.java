package controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model_ORM.Reservation;
import model_ORM.Utilisateur;
import services.sessionService;
import connector_DAO.HibernateSessionFactory;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


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
	}
	public void addCart(){
		
	}
}