package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Student;

public class HqlCrud {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();	
	
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
	
	
	
	
	
	
}
