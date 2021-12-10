package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;
import model.TipUsera;
import model.User;

public class HqlCrud {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();	
	
	
	@SuppressWarnings("unchecked")
	public List<Student> vratiStudentePoBrojuIndexa(String brIndexa) {
		
		List<Student> listaStudenata = new ArrayList<Student>();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			// 1. napisi upit
			String hql = "from Student where brojIndexa = :bridx";
			// 2. napravi Query object
			Query query = session.createQuery(hql);
			// 3. setovanje parametara
			query.setParameter("bridx", brIndexa);
			// 4. vrati rezultate iz baze
			listaStudenata = query.getResultList();
			
			System.out.println("Sve ok, vracam Studente...");
			session.getTransaction().commit();
			return listaStudenata;			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puklo je u metodi vratiStudentaPoBrojuIndexa");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
	
	
	public List<Double> vratiCeneNaOsnovuPoena(double brPoena) {
		
		List<Double> listaCena = new ArrayList<>();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			// 1. napisi upit
			String hql = "select cenaZaSamofinansirajuce from SmerDetails where minimalanBrojPoenaZaUpis <= :poeni";
			// 2. napravi Query object
			Query query = session.createQuery(hql);
			// 3. setovanje parametara
			query.setParameter("poeni", brPoena);
			// 4. vrati rezultate iz baze
			listaCena = query.getResultList();
			
			System.out.println("Sve ok, vracam cene...");
			session.getTransaction().commit();
			return listaCena;			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puklo je u metodi vratiCeneNaOsnovuPoena");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
	
	public void ubaciUsera(String userName, String password, TipUsera tip) {
		
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setTip(tip);
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
	
			session.save(user);
			System.out.println("Sve ok sa userom...");
			session.getTransaction().commit();		
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puklo je u metodi ubaciUsera");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public User vratiUsera(String userName, String password) {
		
		User user = new User();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			String hql = "FROM User WHERE userName = :un AND password = :pass";
			Query query = session.createQuery(hql);
				query.setParameter("un", userName);
				query.setParameter("pass", password);
			
			user = (User)query.getSingleResult();
					
			System.out.println("Sve ok sa userom...");
			session.getTransaction().commit();
			return user;
		} catch (NoResultException e) {
			System.out.println("Nema rezultata...");
			session.getTransaction().rollback();
			return user;
		} catch(NonUniqueResultException e) {
			session.getTransaction().rollback();
			System.out.println("Ima vise od 1 reda...");
			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puklo je u metodi vratiUsera!");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}
	
	
	public List<String> vratiSveUserNameove(){
		
		List<String> userNames = new ArrayList<>();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			// 1. napisi upit
			String sql = "SELECT user_name FROM users";
			// 2. napravi Query object
			Query query = session.createNativeQuery(sql);
			// 3. setovanje parametara - nemam sad
			// 4. vrati rezultate iz baze
			userNames = query.getResultList();
			
			System.out.println("Sve ok, vracam user names...");
			session.getTransaction().commit();
			return userNames;			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Puklo je u metodi vratiSveUserNameove");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	
	}
	
	
	
	
	
	
	
	
	
}
