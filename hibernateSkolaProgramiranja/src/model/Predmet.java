package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredmet;
	private String nazivPredmeta;
	private int brojPoena;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Smer> listaSmerova = new ArrayList<>();

	public int getIdPredmet() {
		return idPredmet;
	}

	public void setIdPredmet(int idPredmet) {
		this.idPredmet = idPredmet;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getBrojPoena() {
		return brojPoena;
	}

	public void setBrojPoena(int brojPoena) {
		this.brojPoena = brojPoena;
	}

	public List<Smer> getListaSmerova() {
		return listaSmerova;
	}

	public void setListaSmerova(List<Smer> listaSmerova) {
		this.listaSmerova = listaSmerova;
	}
	
	
	
	

}
