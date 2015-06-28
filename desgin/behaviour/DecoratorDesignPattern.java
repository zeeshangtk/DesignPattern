package desgin.behaviour;

/**
 * Decorator design pattern is used to wrap additional behaviour on the fly.
 *  
 * @author zeeshan
 * In the below example we have an ice cream with additional toppling.
 * We are trying to compute the cost of ice cream and the toppling dynamically.
 */
public class DecoratorDesignPattern {
	public static void main(String[] args) {
		IIceCream icecream = new VanillaIceCream();
		icecream = new Raisin(icecream);
		icecream = new Chocolates(icecream);
		icecream = new Raisin(icecream);
		System.out.println(icecream.cost());
	}
}

interface IIceCream{
	int cost();
}

interface IToppings extends IIceCream{
	int cost();
	
}

class VanillaIceCream implements IIceCream{

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 21;
	}
	
}

class Raisin implements IToppings{
	IIceCream iceCream  = null;
	
	public Raisin(IIceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 2+iceCream.cost();
	}
	
}
class Chocolates implements IToppings{
	IIceCream iceCream  = null;
	
	public Chocolates(IIceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 5+iceCream.cost();
	}
	
}