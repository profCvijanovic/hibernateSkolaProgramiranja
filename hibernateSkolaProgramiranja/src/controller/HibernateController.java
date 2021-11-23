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
		
		//dao.insertSmerDetails(3, "ovo je smer za sve Python kurseve", 95, 140000);
		dao.spojiStudentaIsmer(2, 1);
		

	}

}
