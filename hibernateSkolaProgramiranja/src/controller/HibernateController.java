package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CrudDao;
import model.Adresa;
import model.Contact;
import model.Finansije;
import model.Student;



public class HibernateController {

	public static void main(String[] args) {
		
		CrudDao dao = new CrudDao();
		
		Adresa adresa = new Adresa();
			adresa.setDrzava("Srbija");
			adresa.setGrad("Novi Sad");
			adresa.setUlica("Zmaj Jovina 3");
			adresa.setPostanskiBroj("21000");
		
		Contact kontakt1 = new Contact();
			kontakt1.setEmail("prviMail@gmail.com");
			kontakt1.setFiksniTelefon("021111222");
			kontakt1.setMobilniTelefon("063111222");
			
		Contact kontakt2 = new Contact();
			kontakt2.setEmail("drugiMail@gmail.com");
			kontakt2.setFiksniTelefon("021333444");
			kontakt2.setMobilniTelefon("061333444");
			
		List<Contact> kontakti = new ArrayList<Contact>();
			kontakti.add(kontakt1);
			kontakti.add(kontakt2);
		
		String imeStudenta = "Lala";
		String prezimeStudenta= "Lalic";
		String brojIndexa = "987ER";
		Finansije finansije = Finansije.POLAPOLA;
		
		dao.insertStudent(imeStudenta, prezimeStudenta, brojIndexa, adresa, finansije, kontakti);
		

	}

}
