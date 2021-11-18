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
		
		Student student = dao.vratiStudentaPoId(4);
		System.out.println("Ime: " + student.getIme());
		System.out.println("Grad: " + student.getAdresa().getGrad());
		System.out.println("Status: " + student.getFinansije());
		
		for(Contact c: student.getContact()) {
			System.out.println("Mob: " + c.getMobilniTelefon());
		}
		

	}

}
