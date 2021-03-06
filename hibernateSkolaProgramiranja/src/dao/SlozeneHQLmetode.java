package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Finansije;
import slozeniModeli.StudentSmerDetails;
import slozeniModeli.StudentSmerDetailsHql;

public class SlozeneHQLmetode {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();	
	
	
	public List<StudentSmerDetails> vratiSlozenuTabelu(String drzava, String finansije, String smer) {
		
		List<StudentSmerDetails> povratnaLista = new ArrayList<>();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			
			String sql = "SELECT st.ime as imeStudenta, " + 
					"st.prezime as prezimeStudenta, " + 
					"st.brojIndexa as brojIndexa, " + 
					"st.drzava as drzava, " + 
					"st.finansije as finansije, " + 
					"sm.nazivSmera as smer, " + 
					"sd.minimalanBrojPoenaZaUpis as poeniZaUpis " + 
					"FROM student st " + 
					"INNER JOIN smer sm ON st.smer_idSmer = sm.idSmer " + 
					"INNER JOIN smerdetails sd ON sm.details_idSmerDetails = sd.idSmerDetails " +
					"WHERE 5=5 ";
			
			if(!drzava.equals("")) {
				sql += " AND drzava = :drz ";
			}
			
			if(!finansije.equals("")) {
				sql += " AND finansije = :fin ";
			}
			
			if(!smer.equals("")) {
				sql += " AND sm.nazivSmera = :smer ";
			}
			
			
			Query query = session.createNativeQuery(sql);
			
			if(!drzava.equals("")) {
				query.setParameter("drz", drzava);
			}
			
			if(!finansije.equals("")) {
				query.setParameter("fin", Integer.parseInt(finansije));
			}
			
			if(!smer.equals("")) {
				query.setParameter("smer", smer);
			}
			
			
			List<Object[]> fromDb= query.getResultList();
			
			for(Object[] o: fromDb) {
				
				StudentSmerDetails ssd = new StudentSmerDetails();
				
					ssd.setImeStudenta(o[0].toString());
					ssd.setPrezimeStudneta(o[1].toString());
					ssd.setBrojIndexa(o[2].toString());
					ssd.setDrzava(o[3].toString());
					ssd.setFinansije((int)o[4]);
					ssd.setSmer(o[5].toString());
					ssd.setPoeni((double)o[6]);
				
				povratnaLista.add(ssd);
			}
			
			session.getTransaction().commit();
			System.out.println("Sve ok u preuzimanju iz slozene tabele...");
			return povratnaLista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto ne valja u metodi vratiSlozenuTabelu!" + e);
			return null;
		}finally {
			session.close();
		}	
	}
	
	
	
	
public List<StudentSmerDetailsHql> vratiSlozenuTabeluHql(String drzava, String finansije, String smer) {
		
		List<StudentSmerDetailsHql> povratnaLista = new ArrayList<>();
		
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			
			String hql = "SELECT st.ime as imeStudenta, "
					+ "st.prezime as prezimeStudenta, "
					+ "st.brojIndexa as brojIndexa, "
					+ "st.adresa.drzava as drzava, "
					+ "st.finansije as finansije, "
					+ "sm.nazivSmera as nazivSmera, "
					+ "sd.minimalanBrojPoenaZaUpis as poeniZaUpis "
					+ "FROM Student st "
					+ "INNER JOIN st.smer sm "
					+ "INNER JOIN sm.details sd "
					+ "WHERE 5=5 ";
			
			if(!drzava.equals("")) {
				hql += " AND drzava = :drz ";
			}
			
			if(!finansije.equals("")) {
				hql += " AND enumFinansije = :fin ";
			}
			
			if(!smer.equals("")) {
				hql += " AND sm.nazivSmera = :smer ";
			}
			
			
			Query query = session.createQuery(hql);
			
			if(!drzava.equals("")) {
				query.setParameter("drz", drzava);
			}
			
			if(!finansije.equals("")) {
				query.setParameter("fin", finansije);
			}
			
			if(!smer.equals("")) {
				query.setParameter("smer", smer);
			}
			
			
			List<Object[]> fromDb= query.getResultList();
			
			for(Object[] o: fromDb) {
				
				StudentSmerDetailsHql ssd = new StudentSmerDetailsHql();
				
					ssd.setImeStudenta(o[0].toString());
					ssd.setPrezimeStudneta(o[1].toString());
					ssd.setBrojIndexa(o[2].toString());
					ssd.setDrzava(o[3].toString());
					ssd.setFinansije(o[4].toString());
					ssd.setSmer(o[5].toString());
					ssd.setPoeni((double)o[6]);
				
				povratnaLista.add(ssd);
			}
			
			session.getTransaction().commit();
			System.out.println("Sve ok u preuzimanju iz slozene tabele...");
			return povratnaLista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Nesto ne valja u metodi vratiSlozenuTabeluHQL! " + e);
			return null;
		}finally {
			session.close();
		}	
	}
	
	

}
