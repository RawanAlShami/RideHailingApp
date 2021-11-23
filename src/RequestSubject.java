import java.util.ArrayList;

public interface RequestSubject {
	public void addObserver(Driver d);
	public void removeObserver(Driver d);
	public void notifyObserver();
}
