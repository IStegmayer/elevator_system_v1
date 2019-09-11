package elevator_system_v1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		System.out.println("Program start: \n");
		
		//armo el building
		
		Elevator fr_elevator = new Elevator(1000);
		Integer[] valid_keys = {1234, 4567};
		Integer[] secured_floors = {-1, 50};
		SecureElevator elevator = new SecureElevator(valid_keys, secured_floors);
		int [] floors = IntStream.rangeClosed(-1, 50).toArray();

		Person p1 = new Person(350, 5478, 200, 8, "p1");
		Person p2 = new Person(250, 2436, 3, 30, "p2");
		Person p3 = new Person(450, 1234, 0, 2, "p3");
		Person p4 = new Person(200, 4567, 0, 0, "p4");
		
		HashMap<String, Person> people = new HashMap<String, Person>();
		people.put("p1",p1);
		people.put("p2",p2);
		people.put("p3",p3);
		people.put("p4",p4);
		
		//instancio el building
		
		Building building = new Building(elevator, fr_elevator, floors);
		building.setPeople(people);
		
		//main loop
	    Scanner myScan = new Scanner(System.in);  // Create a Scanner object
		while (true) {
			System.out.println("[Freight elevator on floor"+fr_elevator.getCurrent_floor()+"]");
			System.out.println("[Secure elevator on floor"+elevator.getCurrent_floor()+"]");
			System.out.println("Who needs a lift?");
			for (Person p: people.values()) {
				System.out.println(p.getName()+"[On floor "+p.getCurrent_floor()+"]");
			}
		    String choice = myScan.nextLine();
		    
		    if (people.containsKey(choice)) {
		    	building.callElevator(building.getPeople().get(choice));
		    } else {
		    	System.out.println("Invalid input.");
		    }
		}
		
		
//		System.out.println("End of program.");
	}

}
