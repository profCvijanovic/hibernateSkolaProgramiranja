package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Smer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSmer;
	private String nazivSmera;
	@OneToOne
	private SmerDetails details;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Student> listaStudenata = new ArrayList<>();
	@ManyToMany
	private List<Predmet> listaPredmetaNaSmeru = new ArrayList<Predmet>();

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

	public SmerDetails getDetails() {
		return details;
	}

	public void setDetails(SmerDetails details) {
		this.details = details;
	}

	public List<Student> getListaStudenata() {
		return listaStudenata;
	}

	public void setListaStudenata(List<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}

	public List<Predmet> getListaPredmetaNaSmeru() {
		return listaPredmetaNaSmeru;
	}

	public void setListaPredmetaNaSmeru(List<Predmet> listaPredmetaNaSmeru) {
		this.listaPredmetaNaSmeru = listaPredmetaNaSmeru;
	}
	
	

}
