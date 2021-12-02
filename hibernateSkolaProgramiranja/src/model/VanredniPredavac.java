package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vanredni")
public class VanredniPredavac extends Predavac {
	
	private int brojPoslova;

	public int getBrojPoslova() {
		return brojPoslova;
	}

	public void setBrojPoslova(int brojPoslova) {
		this.brojPoslova = brojPoslova;
	}
	
	
	
	

}
