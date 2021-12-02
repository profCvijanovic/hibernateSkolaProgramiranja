package model;

import javax.persistence.Entity;

@Entity
public class VanredniPredavac extends Predavac {
	
	private int brojPoslova;

	public int getBrojPoslova() {
		return brojPoslova;
	}

	public void setBrojPoslova(int brojPoslova) {
		this.brojPoslova = brojPoslova;
	}
	
	
	
	

}
