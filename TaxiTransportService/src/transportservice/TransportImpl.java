package transportservice;

public class TransportImpl implements Transport {
	
	//Method for additional charges for booking a taxi
	@Override
	public float calculate(float distance) {
		if (distance <= 3) {
			return 200;
		} else {
			return (200 + (distance - 3) * 10);
		}
	}
}
