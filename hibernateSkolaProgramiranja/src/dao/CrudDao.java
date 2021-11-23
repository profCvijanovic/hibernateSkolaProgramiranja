package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Adresa;
import model.Contact;
import model.Finansije;
import model.Smer;
import model.SmerDetails;
import model.Student;

public class CrudDao {

	// CRUD - Create Read Update Delete operacije
	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public void insertSmer(String nazivSmera) {

		Smer smer = new Smer();
		smer.setNazivSmera(nazivSmera);

		// otvaranje sesije
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// radimo insert
			sesija.persist(smer);
			System.out.println("Upisan smer " + smer.getNazivSmera() + " u bazu...");
			// zatvaram transakciju USPESNO
			sesija.getTransaction().commit();
		} catch (Exception e) {
			// zatvaram transakciju NEUSPESNO
			sesija.getTransaction().rollback();
		} finally {
			// zatvaranje sesije
			sesija.close();
		}
	}

	public Smer vratiSmerPoId(int id) {

		Smer smer = new Smer();

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// select * from smer where idSmer = id;
			smer = sesija.get(Smer.class, id);
			sesija.getTransaction().commit();
			return smer;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		} finally {
			sesija.close();
		}
	}

	public boolean updateNazivSmera(String noviNazivSmera, int idSmer) {

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// select * from smer where idSmer = id;
			Smer smer = sesija.get(Smer.class, idSmer);
			// setujem kolonu na novu vrednost
			smer.setNazivSmera(noviNazivSmera);
			// update
			sesija.update(smer);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		} finally {
			sesija.close();
		}
	}

	public boolean deleteSmer(int idSmer) {

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// select * from smer where idSmer = id;
			Smer smer = sesija.get(Smer.class, idSmer);
			// delete
			sesija.delete(smer);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		} finally {
			sesija.close();
		}
	}

	public void insertStudent(String imeStudenta, String prezimeStudenta, String brojIndexa, Adresa adresa,
			Finansije finansije, List<Contact> kontakti) {

		Student student = new Student();
		student.setIme(imeStudenta);
		student.setPrezime(prezimeStudenta);
		student.setBrojIndexa(brojIndexa);
		student.setFinansije(finansije);
		student.setAdresa(adresa);
		student.setContact(kontakti);
		// otvaranje sesije
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// radimo insert
			sesija.save(student);
			System.out.println("Upisan student sa indexom " + student.getBrojIndexa() + " u bazu...");
			// zatvaram transakciju USPESNO
			sesija.getTransaction().commit();
		} catch (Exception e) {
			// zatvaram transakciju NEUSPESNO
			sesija.getTransaction().rollback();
		} finally {
			// zatvaranje sesije
			sesija.close();
		}
	}

	public Student vratiStudentaPoId(int id) {

		Student student = new Student();

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			// select * from student where idStudent = id;
			student = sesija.get(Student.class, id);
			Hibernate.initialize(student.getContact());
			sesija.getTransaction().commit();
			return student;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		} finally {
			sesija.close();
		}
	}

	public void insertSmerDetails(int idSmer, String opis, double minBrojPoena, double cena) {

		SmerDetails details = new SmerDetails();
			details.setOpisSmera(opis);
			details.setMinimalanBrojPoenaZaUpis(minBrojPoena);
			details.setCenaZaSamofinansirajuce(cena);
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			Smer smer = sesija.get(Smer.class, idSmer);
			smer.setDetails(details);
			sesija.saveOrUpdate(details);
			sesija.update(smer);
			
			System.out.println("Upisan smer details u bazu...");
			sesija.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("NIJE upisan smer details u bazu!");
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	}
	
	
	
	
	public void spojiStudentaIsmer(int idStudent, int idSmer) {

		
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			
			Student student = sesija.get(Student.class, idStudent);
			Smer smer = sesija.get(Smer.class, idSmer);
			Hibernate.initialize(smer.getListaStudenata());
			
			student.setSmer(smer);
			smer.getListaStudenata().add(student);
			
			System.out.println("Povezani student i smer...");
			sesija.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("NISU Povezani student i smer!");
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	}

	
	

}
