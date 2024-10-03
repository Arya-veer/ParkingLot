package timer;

public final class Timer {
	private volatile static int timestamp = 0;
	
	synchronized public static int getTimestamp() {
		return timestamp++;
	}
	
}
