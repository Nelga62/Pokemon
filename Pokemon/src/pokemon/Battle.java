package pokemon;

public class Battle {
	
	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {
		
			if(pokemon2.getSpeed() > pokemon1.getSpeed()) {
				System.out.println(pokemon2.getName()+" comienza el ataque contra "+pokemon1.getName());
				pokemon1.setHealth(pokemon1.getHealth() -pokemon2.getStrength());
				System.out.println(pokemon2.getName() + " daña " + pokemon2.getStrength() + " a " + pokemon1.getName() + " y a " + pokemon1.getName() + " le queda "+ pokemon1.getHealth() + " vida.");
			}
			else {
				System.out.println(pokemon1.getName()+" comienza el ataque contra "+pokemon2.getName());
				
				
			}
			while(pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0 ) {
				pokemon2.setHealth(pokemon2.getHealth() -pokemon1.getStrength());
				System.out.println(pokemon1.getName() + " daña " + pokemon1.getStrength() + " a " + pokemon2.getName() + " y a " + pokemon2.getName() + " le queda "+ pokemon2.getHealth() + " vida.");
				pokemon1.setHealth(pokemon1.getHealth() -pokemon2.getStrength());
				System.out.println(pokemon2.getName() + " daña " + pokemon2.getStrength() + " a " + pokemon1.getName() + " y a " + pokemon1.getName() + " le queda "+ pokemon1.getHealth() + " vida.");
			}
			System.out.println("----------------------------------");
			if(pokemon1.getHealth() > pokemon2.getHealth()) {
				System.out.println(pokemon2.getName() + " ha perdido el combate");
			}
			else{
				System.out.println(pokemon1.getName() + " ha perdido el combate");
			}
			
	}
	
}
