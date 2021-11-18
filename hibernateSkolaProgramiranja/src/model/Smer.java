package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Smer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSmer;
	private String nazivSmera;

	public int getIdSmer() {
		return idSmer;
	}

	public void setIdSmer(int idSmer) {
		this.idSmer = idSmer;
	}

	public String getNazivSmera() {
		return nazivSmera;
	}

	public void setNazivSmera(String nazivSmera) {
		this.nazivSmera = nazivSmera;
	}

}
