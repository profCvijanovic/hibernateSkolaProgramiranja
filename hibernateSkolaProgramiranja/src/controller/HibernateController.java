package controller;

import java.util.ArrayList;
import java.util.List;

import dao.CrudDao;
import dao.HqlCrud;
import dao.SlozeneHQLmetode;
import model.Adresa;
import model.Contact;
import model.Finansije;
import model.Smer;
import model.Student;
import model.TipUsera;
import model.User;
import slozeniModeli.StudentSmerDetails;
import slozeniModeli.StudentSmerDetailsHql;

public class HibernateController {

	public static void main(String[] args) {
		
		SlozeneHQLmetode crud = new SlozeneHQLmetode();
		String drzava = "";
		String finansije = Finansije.BUDZET.name();
		String smer = "Java";
		
		//List<StudentSmerDetails> listaIzBaze = crud.vratiSlozenuTabelu(drzava, finansije, smer);
		List<StudentSmerDetailsHql> listaIzBaze = crud.vratiSlozenuTabeluHql(drzava, finansije, smer);
		if(listaIzBaze != null) {
			for(StudentSmerDetailsHql ssd: listaIzBaze) {
				System.out.println("Ime: " + ssd.getImeStudenta());
				System.out.println("Prezime: " + ssd.getPrezimeStudneta());
				System.out.println("Index: " + ssd.getBrojIndexa());
				System.out.println("Drzava: " + ssd.getDrzava());
				System.out.println("Finansije: " + ssd.getFinansije());
				System.out.println("Smer: " + ssd.getSmer());
				System.out.println("Poeni: " + ssd.getPoeni());
			}
		}
		
		
	
		
		
		
		
		
		

	}

}
