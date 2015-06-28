package desgin.behaviour;

public class StateDesignPattern {
	public static void main(String[] args) {
		MP3Context mp3 = new MP3Context(new OnState());
		System.out.println(mp3.getMp3State().toString());
		mp3.doAction();
		System.out.println(mp3.getMp3State().toString());
		mp3.doAction();
		System.out.println(mp3.getMp3State().toString());
		
	}
}

interface State {
	void doAction(MP3Context context);
}
	
class MP3Context {
	State mp3State = null;

	public MP3Context(State mp3State) {
		this.mp3State = mp3State;
	}
	
	public State getMp3State() {
		return mp3State;
	}

	public void setMp3State(State mp3State) {
		this.mp3State = mp3State;
	}
	public void doAction() {
		mp3State.doAction(this);
	}

	
}

class OnState implements State{
	
	@Override
	public String toString() {
		return "OnState";
	}

	@Override
	public void doAction(MP3Context context) {
	context.setMp3State(new OffState());
	}
	
}

class OffState implements State{
	@Override
	public String toString() {
		return "OffState";
	}

	@Override
	public void doAction(MP3Context context) {
		context.setMp3State(new OnState());	
	}
	
}
