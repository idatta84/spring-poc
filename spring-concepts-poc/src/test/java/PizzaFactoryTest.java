import org.junit.Test;

import com.springconcepts.designpatterns.abstractfactory.Pizza;
import com.springconcepts.designpatterns.abstractfactory.PizzaFactory;
import com.springconcepts.designpatterns.abstractfactory.PizzaFactoryGourmet;
import com.springconcepts.designpatterns.abstractfactory.PizzaFactorySicillian;

public class PizzaFactoryTest {

	@Test
	public void testCreateGourmetPizza() throws Exception {
		PizzaFactory pizzaFactory = new PizzaFactoryGourmet();
		Pizza cheesePizza = pizzaFactory.createPizza("cheese");
		//Pizza veggiePizza = pizzaFactory.createPizza("veggie");
	}
	
	@Test
	public void testCreateSicillianPizza() throws Exception {
		PizzaFactory pizzaFactory = new PizzaFactorySicillian();
		//Pizza cheesePizza = pizzaFactory.createPizza("cheese");
		Pizza veggiePizza = pizzaFactory.createPizza("veggie");
	}
}
