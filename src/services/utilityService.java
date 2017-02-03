package services;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean(name="utilityService")
@RequestScoped

public class utilityService 
{
    
	public utilityService() 
	{
		
	}
	public String stringHash (String st) throws Exception{
		
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(st.getBytes(),0,st.length());
		return (String) new BigInteger(1,m.digest()).toString(16);
		
	}
}