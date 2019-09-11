package elevator_system_v1;

import java.util.Arrays;

public class SecureElevator extends Elevator{
	
	private Integer[] valid_keys;
	private Integer[] secured_floors;
	
	public SecureElevator(Integer[] valid_keys, Integer[] secured_floors) {
		super(1000);
		this.valid_keys = valid_keys;
		this.secured_floors = secured_floors;
	}
	
	public boolean checkDestination(int dest) {
		if (Arrays.asList(this.secured_floors).contains(dest)) {
			System.out.println("Passenger needs a valid key card.");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkKeyCard(int key) {
		if (Arrays.asList(this.valid_keys).contains(key)) {
			System.out.println("Key card validated.");
			return true;
		} else {
			System.out.println("Invalid key card.");
			return false;
		}
	}
}
