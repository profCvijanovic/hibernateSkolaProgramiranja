package model;

import javax.persistence.Entity;

@Entity
public class RedovniPredavac extends Predavac {
	
	private int brojNaucnihRadova;

	public int getBrojNaucnihRadova() {
		return brojNaucnihRadova;
	}

	public void setBrojNaucnihRadova(int brojNaucnihRadova) {
		this.brojNaucnihRadova = brojNaucnihRadova;
	}
	
	

}
