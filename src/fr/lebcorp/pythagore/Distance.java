package fr.lebcorp.pythagore;

public class Distance {

	private String name;
	
	private double distance;
	
	public Distance(String name, double distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getDistance() {
		return distance;
	}
}
