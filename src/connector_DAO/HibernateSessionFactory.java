package connector_DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

 private static final SessionFactory sessionFactory;

 static {
   try {
   // Crée la SessionFactory
	   Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	   configuration.addClass(model_ORM.Annonce.class);
	   configuration.addClass(model_ORM.Categorie.class);
	   configuration.addClass(model_ORM.Client.class);
	   configuration.addClass(model_ORM.Creneau.class);
	   configuration.addClass(model_ORM.Menu.class);
	   configuration.addClass(model_ORM.Plagefermeture.class);
	   configuration.addClass(model_ORM.Plat.class);
	   configuration.addClass(model_ORM.Reduction.class);
	   configuration.addClass(model_ORM.Reservation.class);
	   configuration.addClass(model_ORM.Restaurant.class);
	   configuration.addClass(model_ORM.Restaurateur.class);
	   configuration.addClass(model_ORM.Tpsmoyenrepas.class);
	   configuration.addClass(model_ORM.Utilisateur.class);
	   configuration.addClass(model_ORM.Ville.class);
	   
	   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	   sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   
   } 
   catch (HibernateException ex) {
	   throw new RuntimeException("Problème de configuration : "+ ex.getMessage(), ex);
   }
}

 public static final ThreadLocal session = new ThreadLocal();

 public static Session currentSession() throws HibernateException {
   Session s = (Session) session.get();
   // Ouvre une nouvelle Session, si ce Thread n'en a aucune
   if (s == null) {
	   s = sessionFactory.openSession();
	   session.set(s);
   }
   return s;
   }

 public static void closeSession() throws HibernateException {
   Session s = (Session) session.get();
   session.set(null);
   if (s != null)
	   s.close();
   }
 }
