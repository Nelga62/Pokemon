package pokemon;

public class Battle {

	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {

		System.out.println(pokemon1.getName() + " es de tipo " + pokemon1.getTipo() + " y " + pokemon2.getName()
				+ " es de tipo " + pokemon2.getTipo());
		if (pokemon1.getTipo() == pokemon2.getTipo()) {
			System.out.println("Ambos son del mismo tipo, por lo tanto su fuerza no varía");
		} else {
			if (pokemon1.getTipo() == "agua") {
				if (pokemon2.getTipo() == "fuego" || pokemon2.getTipo() == "tierra") {
					System.out.println("Por lo tanto la fuerza de " + pokemon1.getName() + " se multiplica por dos");
					pokemon1.duplicarDaño();
				} else {
					System.out.println("Por lo tanto la fuerza de " + pokemon2.getName() + " se multiplica por dos");
					pokemon2.duplicarDaño();
				}
			}

			else if (pokemon1.getTipo() == "fuego") {
				if (pokemon2.getTipo() == "agua" || pokemon2.getTipo() == "tierra") {
					System.out.println("Por lo tanto la fuerza de " + pokemon2.getName() + " se multiplica por dos");
					pokemon2.duplicarDaño();
				} else if (pokemon2.getTipo() == "planta") {
					System.out.println("Por lo tanto la fuerza de " + pokemon1.getName() + " se multiplica por dos");
					pokemon1.duplicarDaño();
				} else {
					System.out.println("Por lo tanto la fuerza de ambos no varía");
				}
			} else if (pokemon1.getTipo() == "planta") {
				if (pokemon2.getTipo() == "agua" || pokemon2.getTipo() == "tierra") {
					System.out.println("Por lo tanto la fuerza de " + pokemon1.getName() + " se multiplica por dos");
					pokemon1.duplicarDaño();
				} else if (pokemon2.getTipo() == "fuego") {
					System.out.println("Por lo tanto la fuerza de " + pokemon2.getName() + " se multiplica por dos");
					pokemon2.duplicarDaño();
				} else {
					System.out.println("Por lo tanto la fuerza de ambos no varía");
				}
			}

			else if (pokemon1.getTipo() == "electrico") {
				if (pokemon2.getTipo() == "agua") {
					System.out.println("Por lo tanto la fuerza de " + pokemon1.getName() + " se multiplica por dos");
					pokemon1.duplicarDaño();
				} else if (pokemon2.getTipo() == "tierra") {
					System.out.println("Por lo tanto la fuerza de " + pokemon2.getName() + " se multiplica por dos");
					pokemon2.duplicarDaño();
				} else {
					System.out.println("Por lo tanto la fuerza de ambos no varía");
				}
			}

			else if (pokemon1.getTipo() == "tierra") {
				if (pokemon2.getTipo() == "electrico" || pokemon2.getTipo() == "fuego") {
					System.out.println("Por lo tanto la fuerza de " + pokemon1.getName() + " se multiplica por dos");
					pokemon1.duplicarDaño();
				} else {
					System.out.println("Por lo tanto la fuerza de " + pokemon2.getName() + " se multiplica por dos");
					pokemon2.duplicarDaño();
				}
			} else {
				System.out.println("Error a la hora de ajustar la fuerza según el tipo");
			}
			System.out.println();
		}

		if (pokemon2.getSpeed() > pokemon1.getSpeed()) {
			System.out.println(pokemon2.getName() + " comienza el ataque contra " + pokemon1.getName());
			pokemon1.setHealth(pokemon1.getHealth() - pokemon2.getStrength());
			System.out.println(pokemon2.getName() + " daña " + pokemon2.getStrength() + " a " + pokemon1.getName()
					+ " y a " + pokemon1.getName() + " le queda " + pokemon1.getHealth() + " vida.");
		} else {
			System.out.println(pokemon1.getName() + " comienza el ataque contra " + pokemon2.getName());

		}
		while (pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0) {
			pokemon2.setHealth(pokemon2.getHealth() - pokemon1.getStrength());
			System.out.println(pokemon1.getName() + " daña " + pokemon1.getStrength() + " a " + pokemon2.getName()
					+ " y a " + pokemon2.getName() + " le queda " + pokemon2.getHealth() + " vida.");
			if (pokemon2.getHealth() > 0) {
				pokemon1.setHealth(pokemon1.getHealth() - pokemon2.getStrength());
				System.out.println(pokemon2.getName() + " daña " + pokemon2.getStrength() + " a " + pokemon1.getName()
						+ " y a " + pokemon1.getName() + " le queda " + pokemon1.getHealth() + " vida.");
			}
		}
		System.out.println("------------------------------------");
		if (pokemon1.getHealth() > pokemon2.getHealth()) {
			System.out.println(pokemon2.getName() + " ha perdido el combate");
		} else {
			System.out.println(pokemon1.getName() + " ha perdido el combate");
		}
		pokemon1.dañoInicial();
		pokemon2.dañoInicial();
	}

}
