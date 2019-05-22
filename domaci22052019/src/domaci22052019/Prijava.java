package domaci22052019;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prijava {

	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datumPolaganja;
	
	public Prijava(Student student, Predmet predmet, int ocena, Date datumPolaganja) {
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganja = datumPolaganja;
	}

	public Prijava(Student student2, Predmet predmet2) {
		// TODO Auto-generated constructor stub
	}

	public Student getStudent() {
		return student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
		return "Student: " + student + ", Predmet: " + predmet + ", Ocena: " + ocena + ", datum polaganja " + format.format(datumPolaganja);
	}
}
