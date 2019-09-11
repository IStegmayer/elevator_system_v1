package elevator_system_v1;

import java.util.HashMap;
import java.util.Scanner;

public class Building {
	
	private int[] floors;
	private HashMap<String,Person> people = new HashMap<String, Person>();
	private SecureElevator elevator;
	private Elevator fr_elevator;
	
	public Building (SecureElevator elevator, Elevator fr_elevator, int[] floors) {
		this.setElevator(elevator);
		this.setFr_elevator(fr_elevator);
		this.setFloors(floors);
	}
	
	public void callElevator(Person person) {
		Elevator freight_el = this.getFr_elevator();
		SecureElevator secure_el = this.getElevator();
		
		//get closest elevator to the floor
		//insert person into the elevator
		if (Math.abs(secure_el.getCurrent_floor()-person.getCurrent_floor()) <
			Math.abs(freight_el.getCurrent_floor()-person.getCurrent_floor()) ) {
			
			secure_el.addPassenger(person);
			int dest = this.askForDestination();
			if (secure_el.checkDestination(dest)) {
				if (secure_el.checkKeyCard(person.getKeycard())){
					secure_el.travel(dest, person);
				} else return;
			} else secure_el.travel(dest, person);
			
		}else {
			
			freight_el.addPassenger(person);
			int dest = this.askForDestination();
			freight_el.travel(dest, person);
		}
		
		return;
	}
	
	public int askForDestination() {
		System.out.println("Floor?\n");
	    Scanner myScan = new Scanner(System.in);  // Create a Scanner object
	    return myScan.nextInt();
	}

	public SecureElevator getElevator() {
		return elevator;
	}

	public void setElevator(SecureElevator elevator) {
		this.elevator = elevator;
	}

	public Elevator getFr_elevator() {
		return fr_elevator;
	}

	public void setFr_elevator(Elevator fr_elevator) {
		this.fr_elevator = fr_elevator;
	}

	public int[] getFloors() {
		return floors;
	}

	public void setFloors(int[] floors) {
		this.floors = floors;
	}

	public HashMap<String,Person> getPeople() {
		return people;
	}

	public void setPeople(HashMap<String,Person> people2) {
		this.people = people2;
	}
	
	
}
