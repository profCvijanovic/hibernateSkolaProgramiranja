package controller;

import dao.CrudDao;
import model.Adresa;
import model.Finansije;
import model.Smer;
import model.Student;

public class HibernateController {

	public static void main(String[] args) {
		
		CrudDao dao = new CrudDao();
		
		//dao.insertSmer("Python");
		
		/*
		 * Smer smerIzBaze = dao.vratiSmerPoId(3);
		 * 
		 * if(smerIzBaze == null) { System.out.println("Ne postoji taj id!"); }else {
		 * System.out.println("id: " + smerIzBaze.getIdSmer());
		 * System.out.println("Naziv: " + smerIzBaze.getNazivSmera()); }
		 */

		
		/*boolean uradiUpdateNazivSmera = dao.updateNazivSmera("Java", 1);
		
		if(uradiUpdateNazivSmera) {
			System.out.println("Uradjen update...");
		}else {
			System.out.println("Nije uspeo update!");
		}*/
		
		
		/*if(dao.deleteSmer(2)) {
			System.out.println("Uradjen delete...");
		}else {
			System.out.println("Nije uspeo delete!");
		}*/
		
		
		// insert Student
		//dao.insertStudent("Nenad", "Nenadovic", "123AB", "Srbija" , "Beograd", "Knez Mihajlova 12" , "11000",Finansije.SAMOFINANSIRANJE );
		
		
		 Student student = dao.vratiStudentaPoId(2); 
		 System.out.println("Ime: " + student.getIme()); 
		 Adresa adresa = student.getAdresa();
		 System.out.println("Drzava: " + adresa.getDrzava());
		 System.out.println("Grad: " + adresa.getGrad()); 
		 System.out.println("Ulica: "+ adresa.getUlica()); 
		 System.out.println("PB: " + adresa.getPostanskiBroj());
		 System.out.println("Finansije: " + student.getFinansije());
		 
		
		

	}

}
