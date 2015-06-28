package desgin.behaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern allows us to compose objects in tree structure to represent
 * part whole hierarchies.It lets client treat individual objects and composite
 * object uniformly.
 * 
 * Here we create a component interface that is implemented by leaf as well as
 * composite objects
 * 
 * @author zeeshan
 *
 */
public class CompositeDesignPattern {
	public static void main(String[] args) {
		MenuComponet coffeMenu = new Menu("Coffee", "Some coffee menu");
		MenuComponet capicono = new MenuItem("Capicino", 21);
		MenuComponet coffeMild = new MenuItem("MildCoffee", 12);
		coffeMenu.add(capicono);
		coffeMenu.add(coffeMild);
		coffeMenu.printMenu();
	}
}

//Common interface for leaf and nodes
abstract class MenuComponet {
	public void add(MenuComponet menu) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponet menu) {
		throw new UnsupportedOperationException();
	}

	public void printMenu() {
		throw new UnsupportedOperationException();
	}

	public void getDescription() {
		throw new UnsupportedOperationException();
	}

}
//acts as leaf
class MenuItem extends MenuComponet {
	private String name = "";
	private int cost = 0;
	public MenuItem(String name,int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public void getDescription() {
		System.out.println("The menu is " + name);
		System.out.println("The cost is " + cost);
	}
	public void printMenu() {
		getDescription();
	}
}
//acts as node
class Menu extends MenuComponet{
	List<MenuComponet> items = new ArrayList<MenuComponet>();
	String name = "";
	String description = "";
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void add(MenuComponet menu) {
		items.add(menu);
	}

	public void remove(MenuComponet menu) {
		items.remove(menu);
	}

	public void printMenu() {
		System.out.println("The "+name+" menu");
		for(MenuComponet items:items){
			items.printMenu();
		}
	}

	public void getDescription() {
		System.out.println("the description is "+description);
	}

}