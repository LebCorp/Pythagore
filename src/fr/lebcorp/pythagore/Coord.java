package fr.lebcorp.pythagore;

public class Coord {

	private int x;
	
	private int y;
	
	private String name;
	
	/**
	 * Créé une coordonnée avec des points x et y et avec un nom
	 * */
	public Coord(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return name;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Créé un objet distance qui contiendra la distance entre cette coordonnée et la coordonée 'coord'
	 * */
	public Distance distance(Coord coord) {
		
		if(coord != this) {
		
			int x = coord.getX();
			int y = coord.getY();
			
			double distance = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
			
			System.out.println("La distance entre " + name + " et " + coord.name + " est de " + distance);
			
			return new Distance(this.name + coord.name, distance);
		}
		
		System.err.println("Cannot distantiate the same coordinates !");
		
		return null;
	}
}
