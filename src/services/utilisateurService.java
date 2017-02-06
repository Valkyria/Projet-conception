package services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="utilisateurService")
@RequestScoped

public class utilisateurService 
{
	private boolean restaurateur;
    
	public utilisateurService() 
	{
		// TODO Auto-generated constructor stub
	}
	public void setRestaurateur(boolean bool){
		this.restaurateur = bool;
	}
	public boolean isRestaurateur(){
		return this.restaurateur;
	}
}
