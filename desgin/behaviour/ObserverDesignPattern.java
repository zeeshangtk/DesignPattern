package desgin.behaviour;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
	public static void main(String[] args) {
		NewsPaperSubject subject = new NewsPaperSubject();
		subject.registerObserver(new MRGupta());
		subject.registerObserver(new MRKhan());
		subject.update();
	}
}

interface Subject {
	
	void registerObserver(Observer observer);
	void unregisterObserver(Observer observer);
	void update();
}


interface Observer{
	void update();
}

class NewsPaperSubject implements Subject{
	List<Observer> observerList = new ArrayList<Observer>();
	
	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
		
	}

	@Override
	public void unregisterObserver(Observer observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for(Observer observer:observerList){
			observer.update();
		}
	}
	
}

class MRKhan implements Observer{

	@Override
	public void update() {
		System.out.println("MR KHAN GOT THE NOTIFICATION");
		
	}
	
}

class MRGupta implements Observer{

	@Override
	public void update() {
		System.out.println("MR GUPTA GOT THE NOTIFICATION");
		
	}
	
}