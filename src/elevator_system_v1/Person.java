package elevator_system_v1;

public class Person {

	private int weight;
	private int keycard; //could be a class
	private int freight_weight; //could be a class
	private int current_floor;
	private String name;
	
	public Person(int weight, int keycard, int freight_weight, int current_floor, String name) {
		this.setWeight(weight);
		this.setKeycard(keycard);
		this.setFreight_weight(freight_weight);
		this.setCurrent_floor(current_floor);
		this.setName(name);
	}

	public int getWeight() {
		return weight+freight_weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getKeycard() {
		return keycard;
	}

	public void setKeycard(int keycard) {
		this.keycard = keycard;
	}

	public int getFreight_weight() {
		return freight_weight;
	}

	public void setFreight_weight(int freight_weight) {
		this.freight_weight = freight_weight;
	}

	public int getCurrent_floor() {
		return current_floor;
	}

	public void setCurrent_floor(int current_floor) {
		this.current_floor = current_floor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
