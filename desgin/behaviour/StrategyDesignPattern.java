package desgin.behaviour;

/**
 * strategy design pattern is used to change algorithm dynamically 
 */
public class StrategyDesignPattern {

	public static void main(String[] args) {
		//Here we can pass any implementation of PayAmount
		ShoppingCart cart = new ShoppingCart(new PayWithCreditCard());
		cart.payAmount(200);
	}
}

/***
 * 
 * Payamount interface encapsulates the implementation for payment 	
 *
 */
interface PayAmount{
	void pay(int amount);
}

class PayWithCreditCard implements PayAmount{

	@Override
	public void pay(int amount) {
		System.out.println("Paying the amount "+amount+" via credit card");
	}
	
}

class PayWithDebitCard implements PayAmount{

	@Override
	public void pay(int amount) {
		System.out.println("Paying the amount "+amount+" via debit card");
		
	}
	
}

class ShoppingCart{
	PayAmount payamount = null;

	public ShoppingCart(PayAmount pay) {
		this.payamount = pay;
	}
	
	public void payAmount(int amount){
		payamount.pay(amount);
	}
	
}