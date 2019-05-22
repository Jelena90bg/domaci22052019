package domaci22052019;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Podaci {
	
	private static boolean generisaniPodaci = false;
	private static ArrayList<Predmet> listaPredmeta;
	private static ArrayList<Student> listaStudenata;
	private static ArrayList<Prijava> listaPrijava;
	
	
	public static void generisiPodatke() {
		if (generisaniPodaci) {
			System.out.println("Podaci su vec generisani");
		} else {
			generisiStudente();
			generisiPredmete();
			listaPrijava = new ArrayList<Prijava>();
		}
	}
	
	
	public static void odstampajListuPredmeta() {
		odstampajListu(listaPredmeta);
	}
	
	public static void odstampajListuStudenata() {
		odstampajListu(listaStudenata);
	}
	
	public static void izmeniStudenta(Student student, String ime, String prezime, int godinaUpisa, Date datumRodjenja) {
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setGodinaUpisa(godinaUpisa);
		student.setDatumRodjenja(datumRodjenja);
	}
	
	public static Student nadjiStudenta(String brojIndeksa) {
		for (Student student : listaStudenata) {
			if (student.getBrojIndeksa().equals(brojIndeksa)) {
				return student;
			}
		}
		return null;
	}
	
	public static Predmet nadjiPredmet(int sifraPredmeta) {
		for (Predmet predmet : listaPredmeta) {
			if (predmet.getSifraPredmeta() == sifraPredmeta) {
				return predmet;
			}
		}
		return null;
	}
	
	public static void dodajPrijavu(Predmet predmet, Student student, int ocena, Date datumPolaganja) {
		listaPrijava.add(new Prijava(student, predmet, ocena, datumPolaganja));
	}
	
	public static void obrisiPrijavu (Predmet predmet, Student student) {
		listaPrijava.remove(nadjiPolozenuPrijavu(student, predmet));
	}
	
	public static void izlistajPrijavePoStudentu(Student student) {
		boolean nemaPrijave = true;
		for (Prijava prijava : listaPrijava) {
			if (prijava.getStudent().getBrojIndeksa().equals(student.getBrojIndeksa())) {
				nemaPrijave = false;
				System.out.println(prijava);
			}
		}
		if (nemaPrijave) {
			
			System.out.println("Student nema prijave");
		}
	}
	
	public static void izlistajStudenteKojiSuPoloziliPredmet(Predmet predmet) {
		boolean nikoNijePolozio = true;
		for (Prijava prijava : listaPrijava) {
			if (prijava.getPredmet().getSifraPredmeta() == predmet.getSifraPredmeta()) {
				if (prijava.getOcena() > 5) {
					nikoNijePolozio = false;
					System.out.println(prijava);
				}
			}
		}
		if (nikoNijePolozio) {
			System.out.println("Nijedan student nije polozio");
		}
	}
	
	public static boolean daLiJeStudentPolozioPredmet(Student student, Predmet predmet) {
		for (Prijava prijava : listaPrijava) {
			if (prijava.getStudent().getBrojIndeksa().equals(student.getBrojIndeksa())
						&& prijava.getPredmet().getSifraPredmeta() == predmet.getSifraPredmeta()) {
				if (prijava.getOcena() > 5) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static Prijava nadjiPolozenuPrijavu(Student student, Predmet predmet) {
		for (Prijava prijava : listaPrijava) {
			if (prijava.getStudent().getBrojIndeksa().equals(student.getBrojIndeksa())
						&& prijava.getPredmet().getSifraPredmeta() == predmet.getSifraPredmeta()) {
				if (prijava.getOcena() > 5) {
					return prijava;
				}
			}
		}
		return null;
	}
	
	public static boolean daLiJeNovaOcenaVecaOdPrethodne(Student student, Predmet predmet, int ocena) {
		Prijava prijava = nadjiPolozenuPrijavu(student, predmet);
		if (prijava == null) {
			return true;
		} else {
			return prijava.getOcena() < ocena;
		}
	}
	
	private static void generisiStudente() {
		listaStudenata = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
		try {
			listaStudenata.add(new Student("17002", 2017, "Ana", "Kostic", format.parse("27.07.1998.")));
			listaStudenata.add(new Student("17014", 2017, "Ana", "Maric", format.parse("16.05.1998.")));
			listaStudenata.add(new Student("17008", 2017, "Anka", "Anic", format.parse("23.05.1998.")));
			listaStudenata.add(new Student("16002", 2016, "Anica", "Baric", format.parse("23.09.1997.")));
			listaStudenata.add(new Student("16014", 2016, "Mara", "Ilic", format.parse("11.09.1998.")));
			listaStudenata.add(new Student("16008", 2016, "Mila", "Jovic", format.parse("27.07.1998.")));
			listaStudenata.add(new Student("15002", 2015, "Aca", "Kostic", format.parse("17.06.1996.")));
			listaStudenata.add(new Student("15014", 2015, "Moma", "Kojic", format.parse("17.06.1996.")));
			listaStudenata.add(new Student("15008", 2015, "Jova", "Kun", format.parse("12.12.1996.")));
			listaStudenata.add(new Student("14002", 2014, "Laza", "Maric", format.parse("21.02.1995.")));
			listaStudenata.add(new Student("14014", 2014, "Jova", "Kis", format.parse("23.03.1995.")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void generisiPredmete() {
		listaPredmeta = new ArrayList<>();
		listaPredmeta.add(new Predmet(1, "Matematika 1"));
		listaPredmeta.add(new Predmet(2, "Programiranje 1"));
		listaPredmeta.add(new Predmet(3, "Ekonomija"));
		listaPredmeta.add(new Predmet(4, "Uvod u IS"));
		listaPredmeta.add(new Predmet(5, "Osnovi organizacije"));
		listaPredmeta.add(new Predmet(6, "Menadzment"));
		listaPredmeta.add(new Predmet(7, "Baze podataka"));
		listaPredmeta.add(new Predmet(8, "Sociologija"));
		listaPredmeta.add(new Predmet(9, "Psihologija"));
		listaPredmeta.add(new Predmet(10, "Logika"));
		listaPredmeta.add(new Predmet(11, "Filosofija"));
		listaPredmeta.add(new Predmet(12, "Operativni sistemi"));
		listaPredmeta.add(new Predmet(13, "Osnovi kvaliteta"));
		listaPredmeta.add(new Predmet(14, "Arhitektura racunara"));
		listaPredmeta.add(new Predmet(15, "Proizvodni sistemi"));
		listaPredmeta.add(new Predmet(16, "Matematika 2"));
		listaPredmeta.add(new Predmet(17, "Programiranje 2"));
		listaPredmeta.add(new Predmet(18, "Marketing"));
		listaPredmeta.add(new Predmet(19, "Finansije"));
		listaPredmeta.add(new Predmet(20, "Algoritmi"));
		listaPredmeta.add(new Predmet(21, "Strukture podataka"));
		listaPredmeta.add(new Predmet(22, "Upravljanje zalihama"));
	}
	
	private static void odstampajListu(ArrayList<?> lista) {
	    for (Object elementListe : lista) {
	        System.out.println(elementListe);
	    }
	}
}
