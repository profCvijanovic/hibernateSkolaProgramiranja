package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CrudDao;
import dao.HqlCrud;
import model.Adresa;
import model.Contact;
import model.Finansije;
import model.Student;
import model.TipUsera;
import model.User;

public class HibernateController {

	public static void main(String[] args) {
		
		HqlCrud crud = new HqlCrud();
		
		/*List<Student> listaStudenata = crud.vratiStudentePoBrojuIndexa("123ABC");
		
		if(listaStudenata.isEmpty()) {
			System.out.println("Ne postoji taj broj indexa");
		}else {
			for(Student s: listaStudenata) {
				System.out.println("Id: " + s.getIdStudent());
				System.out.println("Ime: " + s.getIme());
				System.out.println("Prezime: " + s.getPrezime());
				System.out.println("Grad: " + s.getAdresa().getGrad());
				System.out.println("Finansiranje: " + s.getFinansije());
				System.out.println("Smer: " + s.getSmer().getNazivSmera());
			}
		}*/
		
		/*
		 * List<Double> cene = crud.vratiCeneNaOsnovuPoena(80);
		 * System.out.println("Cene u ponudi: "); for(Double cena: cene) {
		 * System.out.println(cena); }
		 */
		
		/*
		 * User user = crud.vratiUsera("aaa", "aaa123");
		 * 
		 * if(user != null) { System.out.println("ID:" + user.getIdUser());
		 * System.out.println("UN:" + user.getUserName()); System.out.println("PASS:" +
		 * user.getPassword()); System.out.println("TIP:" + user.getTip()); }
		 */
		
		List<String> sviUserNameovi = crud.vratiSveUserNameove();
		for(String name: sviUserNameovi) {
			System.out.println(name);
		}
		
		
		

	}

}
