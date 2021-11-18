package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	private String ime;
	private String prezime;
	private String brojIndexa;
	@Embedded
	private Adresa adresa;
	@Enumerated
	private Finansije finansije;
	@ElementCollection
	private List<Contact> contact = new ArrayList<Contact>();
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrojIndexa() {
		return brojIndexa;
	}
	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public Finansije getFinansije() {
		return finansije;
	}
	public void setFinansije(Finansije finansije) {
		this.finansije = finansije;
	}
	public List<Contact> getContact() {
		return contact;
	}
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}


	
	
	
	
	
	
	

}
