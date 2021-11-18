package model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
	
	private String email;
	private String mobilniTelefon;
	private String fiksniTelefon;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilniTelefon() {
		return mobilniTelefon;
	}
	public void setMobilniTelefon(String mobilniTelefon) {
		this.mobilniTelefon = mobilniTelefon;
	}
	public String getFiksniTelefon() {
		return fiksniTelefon;
	}
	public void setFiksniTelefon(String fiksniTelefon) {
		this.fiksniTelefon = fiksniTelefon;
	}
	
	

}
