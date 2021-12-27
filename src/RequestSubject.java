public interface RequestSubject 
{
	public void addObserver(DriverEntity d);
	public void removeObserver(DriverEntity d);
	public void notifyObserver();
}
