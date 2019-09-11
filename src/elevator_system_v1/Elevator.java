package elevator_system_v1;

import java.util.HashMap;
import java.util.Scanner;

public class Elevator {
	
	private int weight_limit;
	private int current_floor;
	private boolean available;
	private HashMap<String, Person> passengers = new HashMap<String, Person>();
	
	public Elevator(int weight_limit) {
		this.setAvailable(true);;
		this.setCurrent_floor(0);
		this.setWeight_limit(weight_limit);
	}
	
	public void travel(int destination, Person person) {
		this.setCurrent_floor(destination);
		this.setAvailable(false);
		int distance = Math.abs(this.getCurrent_floor() - destination);
		//WAIT FOR IT TO TRAVEL IN THE BACKGROUND
		this.setAvailable(true);
		person.setCurrent_floor(destination);
		return;
	}
	
	public void soundAlarm() {
		return;
	}

	public int getCurrent_floor() {
		return current_floor;
	}

	public void setCurrent_floor(int current_floor) {
		this.current_floor = current_floor;
	}

	public int getWeight_limit() {
		return weight_limit;
	}

	public void setWeight_limit(int weight_limit) {
		this.weight_limit = weight_limit;
	}

	public HashMap<String,Person> getPassengers() {
		return passengers;
	}

	public void setPassengers(HashMap<String, Person> passengers) {
		this.passengers = passengers;
	}

	public void addPassenger(Person passenger) {
		this.passengers.put(passenger.getName(), passenger);
		this.checkWeight();
		return;
	}
	
	public void checkWeight() {
		while (true) {
			
			int total_weight = 0;
			for (Person p: this.passengers.values()) {
				total_weight = total_weight + p.getWeight();
			}
			
			if (total_weight > this.getWeight_limit()) {
				this.setAvailable(false);
				System.out.println("[ALARM]Weight limit exceeded, who's getting off?\n");
				for (Person p: this.getPassengers().values()) {
					System.out.println(p.getName()+"["+p.getWeight()+"]");
				}
			    Scanner myScan = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("\nChoice: ");
			    String choice = myScan.nextLine();
			    this.passengers.remove(choice);
			    
			    if (this.passengers.isEmpty()) {
					this.setAvailable(true);
					break;
			    }
			} else {
				this.setAvailable(true);
				break;
			}
		}
		
		return;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	
}
