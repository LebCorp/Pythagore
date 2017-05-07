package fr.lebcorp.pythagore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(
				"Ce programme va vous dire si un triangle est équilatéral \n Pour cela il vous faudra donner les coordonées de 3 points dans un repère orthogonal");

		Scanner scanner = new Scanner(System.in);
		
		Coord a = build("a", scanner);
		Coord b = build("b", scanner);
		Coord c = build("c", scanner);

		Distance ab = a.distance(b);
		Distance bc = b.distance(c);
		Distance ac = a.distance(c);

		List<Distance> sides = getHypotenuse(ab, bc, ac);

		Distance hyp = sides.get(0);

		Distance c1 = sides.get(1);
		Distance c2 = sides.get(2);

		double hypo = Math.pow(hyp.getDistance(), 2);

		System.out.println(hyp.getName() + " au carré = " + hypo);
		
		double c0 = Math.pow(c1.getDistance(), 2) + Math.pow(c2.getDistance(), 2);
		
		System.out.println(c1.getName() + " + " + c2.getName() + " au carré = " + c0);

		
		if(hypo == c0) {
			System.out.println("Donc le triangle " + a.getName() + b.getName() + c.getName() + " est bien rectangle");
		} else System.out.println("Donc le triangle " + a.getName() + b.getName() + c.getName() + " n'est pas rectangle");
	}

	/**
	 * Nécessite un scanner pour créer une coordonnée 
	 * */
	private static Coord build(String name, Scanner scanner) {
		System.out.println("Veuillez entrer les coordonées du point " + name + " commencez par l'abscisse");
		int x = scanner.nextInt();
		System.out.println("Maintenant veuillez entrer l'ordonnée");
		int y = scanner.nextInt();

		Coord coord = new Coord(name, x, y);

		System.out.println("Merci d'avoir entrer les coordonées du point " + name);

		return coord;
	}

	/**
	 * Créé une liste qui contiendra les 3 distances, 
	 * la plus grande distance sera toujours en première position dans la liste
	 * */
	private static List<Distance> getHypotenuse(Distance dist1, Distance dist2, Distance dist3) {

		List<Distance> distance = new ArrayList<Distance>(3);

		distance.clear();

		if (dist1.getDistance() > dist2.getDistance() && dist1.getDistance() > dist3.getDistance()) {
			distance.add(dist1);
			distance.add(dist2);
			distance.add(dist3);
		} else if (dist2.getDistance() > dist1.getDistance() && dist2.getDistance() > dist3.getDistance()) {
			distance.add(dist2);
			distance.add(dist1);
			distance.add(dist3);
		} else if (dist3.getDistance() > dist1.getDistance() && dist3.getDistance() > dist2.getDistance()) {
			distance.add(dist3);
			distance.add(dist1);
			distance.add(dist2);
		}

		return distance;
	}
}
