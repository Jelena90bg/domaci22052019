package domaci22052019;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void napraviMenu() {
		
		int izbor;
		do {
			System.out.println("Izaberite neku od opcija");
			System.out.println("1. Pregled");
			System.out.println("2. Unos nove prijave");
			System.out.println("3. Izmena podataka o studentu");
			System.out.println("0. Kraj");
			System.out.println("Vas izbor: ");
			
			try {
				izbor = StandardniUlaz.iscitajBroj();
			} catch (InputMismatchException e) {
				izbor = -1;
			}

			switch (izbor) {
				case 1: 
					int izborPregleda;
					do {
						System.out.println("Izaberite neku od opcija pregleda");
						System.out.println("1. Pregled svih predmeta");
						System.out.println("2. Pregled svih studenata");
						System.out.println("3. Pregled svih prijava za trazenog studenta");
						System.out.println("4. Pregled svih studenata koji su polozili odredjeni predmet");
						System.out.println("0. Povratak u glavni meni");
						System.out.println("Vas izbor: ");
						
						try {
							izborPregleda = StandardniUlaz.iscitajBroj();
						} catch (InputMismatchException e) {
							izborPregleda = -1;
						}
						
						switch (izborPregleda) {
							case 1:
								Podaci.odstampajListuPredmeta();
								break;
							case 2:
								Podaci.odstampajListuStudenata();
								break;
							case 3:
								System.out.println("Unesite broj indeksa studenta: ");
								String brojIndeksaStudenta = StandardniUlaz.iscitajString();
								
								Student student = Podaci.nadjiStudenta(brojIndeksaStudenta);
								if (student == null) {
									System.out.println("U sistemu ne postoji student sa brojem indeksa " + brojIndeksaStudenta);
								} else {
									Podaci.izlistajPrijavePoStudentu(student);
								}
								break;
							case 4:
								System.out.println("Unesite sifru predmeta: ");
								int sifraPredmeta;
								try {
									sifraPredmeta = StandardniUlaz.iscitajBroj();
								} catch (InputMismatchException e) {
									System.out.println("Niste ispravno uneli sifru predmeta!");
									break;
								}
								
								Predmet predmet = Podaci.nadjiPredmet(sifraPredmeta);
								if (predmet == null) {
									System.out.println("U sistemu ne postoji predmet sa sifrom " + sifraPredmeta);
								} else {
									Podaci.izlistajStudenteKojiSuPoloziliPredmet(predmet);
								}
								break;
							case 0:
								break;
							default:
								System.out.println("Niste uneli odgovarajucu opciju!");
								break;
						}
					} while (izborPregleda != 0);
					break;
				case 2:
					System.out.println("Unesite novu prijavu");
					
					System.out.println("Unesite broj indeksa studenta:");
					String indeksStudenta = StandardniUlaz.iscitajString();
					
					Student student = Podaci.nadjiStudenta(indeksStudenta);
					if (student == null) {
						System.out.println("U sistemu ne postoji student sa brojem indeksa " + indeksStudenta);
						break;
					}
					
					System.out.println("Unesite sifru predmeta: ");
					int sifraPredmeta;
					try {
						sifraPredmeta = StandardniUlaz.iscitajBroj();
					} catch (InputMismatchException e) {
						System.out.println("Niste ispravno uneli sifru predmeta!");
						break;
					}
					
					Predmet predmet = Podaci.nadjiPredmet(sifraPredmeta);
					if (predmet == null) {
						System.out.println("U sistemu ne postoji predmet sa sifrom " + sifraPredmeta);
						break;
					}
					
					if (Podaci.daLiJeStudentPolozioPredmet(student, predmet)) {
					
						System.out.println("Unesite ocenu sa polaganja: ");
						int ocena;
						try {
							ocena = StandardniUlaz.iscitajBroj();
							if (ocena < 5 || ocena > 10) {
								System.out.println("Niste ispravno uneli ocenu!");
							}
						} catch (InputMismatchException e) {
							System.out.println("Niste ispravno uneli ocenu!");
							break;
						}
						if (Podaci.daLiJeNovaOcenaVecaOdPrethodne(student, predmet, ocena)) {
							System.out.println("Unesite datum polaganja u formatu dd.MM.yyyy. : ");
							String datumPolaganjaString = StandardniUlaz.iscitajString();
							SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
							Date datumPolaganja;
							try {
								datumPolaganja = format.parse(datumPolaganjaString);
							} catch (ParseException e) {
								System.out.println("Uneli ste los format datuma!");
								break;
							}
							Podaci.obrisiPrijavu(predmet, student);
							Podaci.dodajPrijavu(predmet, student, ocena, datumPolaganja);
						} else {
							System.out.println("Nova ocena je niza od prethodne ili jednaka prethodnoj i nece biti upisana.");
						}
						break;
					
					} else {
						System.out.println("Unesite ocenu sa polaganja: ");
						int ocena;
						try {
							ocena = StandardniUlaz.iscitajBroj();
							if (ocena < 5 || ocena > 10) {
								System.out.println("Niste ispravno uneli ocenu!");
							}
						} catch (InputMismatchException e) {
							System.out.println("Niste ispravno uneli ocenu!");
							break;
						}
						System.out.println("Unesite datum polaganja u formatu dd.MM.yyyy. : ");
						String datumPolaganjaString = StandardniUlaz.iscitajString();
						SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
						Date datumPolaganja;
						try {
							datumPolaganja = format.parse(datumPolaganjaString);
						} catch (ParseException e) {
							System.out.println("Uneli ste los format datuma!");
							break;
						}
						Podaci.dodajPrijavu(predmet, student, ocena, datumPolaganja);
						break;
					}
					
				case 3:
					int izborIzmena;
					do {
						System.out.println("Izaberite neku od opcija");
						System.out.println("1. Izmena podataka o studentu");
						System.out.println("0. Povratak u glavni meni");
						System.out.println("Vas izbor: ");
						
						try {
							izborIzmena = StandardniUlaz.iscitajBroj();
						} catch (InputMismatchException e) {
							izborIzmena = -1;
						}
						
						switch (izborIzmena) {
							case 1:
								System.out.println("Unesite broj indeksa studenta:");
								String indeksStudentaZaIzmenu = StandardniUlaz.iscitajString();
								Student studentZaIzmenu = Podaci.nadjiStudenta(indeksStudentaZaIzmenu);
								if (studentZaIzmenu == null) {
									System.out.println("U sistemu ne postoji student sa brojem indeksa " + indeksStudentaZaIzmenu);
									break;
								} else {
									System.out.println("Trenutni podaci za studenta: " + studentZaIzmenu);
								}
								System.out.println("Unesite ime studenta:");
								String ime = StandardniUlaz.iscitajString();
								System.out.println("Unesite prezime studenta:");
								String prezime = StandardniUlaz.iscitajString();
								System.out.println("Unesite godinu upisa studenta:");
								int godinaUpisa;
								
								try {
									godinaUpisa = StandardniUlaz.iscitajBroj();
								} catch (InputMismatchException e) {
									System.out.println("Niste ispravno uneli godinu upisa!");
									break;
								}
								
								System.out.println("Unesite godinu rodjenja u formatu dd.MM.yyyy. : ");
								String godinaRodjenjaString = StandardniUlaz.iscitajString();
								SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
								Date datumRodjenja;
								try {
									datumRodjenja = format.parse(godinaRodjenjaString);
								} catch (ParseException e) {
									System.out.println("Uneli ste los format datuma!");
									break;
								}
								Podaci.izmeniStudenta(studentZaIzmenu, ime, prezime, godinaUpisa, datumRodjenja);
								break;
							case 0:
								break;
							default:
								System.out.println("Niste uneli odgovarajucu opciju!");
								break;
						}
					} while (izborIzmena != 0);
					
				case 0:
					break;
				default:
					System.out.println("Niste uneli odgovarajucu opciju!");
					break;
			}
		} while (izbor != 0);		
					
		
	}

}
