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
		
		dao.insertPredavace("Ana", "Anic", 4, 7);
		
		
		

	}

}
