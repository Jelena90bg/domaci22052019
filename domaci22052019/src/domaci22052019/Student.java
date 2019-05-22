package domaci22052019;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

	private String brojIndeksa;
	private int godinaUpisa;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	
	public Student(String brojIndeksa, int godinaUpisa, String ime,
			String prezime, Date datumRodjenja) {
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
		return "broj indeksa: " + brojIndeksa + ", godina upisa: " + godinaUpisa + ", ime: " + ime + ", prezime: " + prezime + ", datum rodjenja: " + format.format(datumRodjenja);
	}
}
