package pokemon;

import java.util.Scanner;

public class App {
	private static final int NUM_POKEMONS = 5;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int numOpcion = 0;
		
		while (numOpcion != 3) {
			System.out.println("------------------------------------");
			System.out.println("Elija una opción: ");
			System.out.println("1. Utilizar los pokemons del juego");
			System.out.println("2. Crear los pokemons aleatoriamente");
			System.out.println("3. Salir");
			System.out.println("------------------------------------");
			numOpcion = scanner.nextInt();

			switch (numOpcion) {
			case 1:
				initPokemons();
				initCombat();
				break;
			case 2:
				initPokemonsRandomly();
				initCombat();
				break;
			case 3:
				System.out.println("FIN DEL JUEGO");
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}
	}

	private static void initPokemons() {
		Pokemon charizard = new Pokemon(100, 50, 50, "charizard");
		pokemons[0] = charizard;
		Pokemon blastoise = new Pokemon(150, 25, 150, "blastoire");
		pokemons[1] = blastoise;
		Pokemon venusaur = new Pokemon(300, 10, 100, "venusaur");
		pokemons[2] = venusaur;
		Pokemon bulbasaur = new Pokemon(250, 20, 180, "bulbasaur");
		pokemons[3] = bulbasaur;
		Pokemon pikachu = new Pokemon(300, 40, 200, "pikachu");
		pokemons[4] = pikachu;
	}

	private static void initPokemonsRandomly() {
		for (int i = 0; i < pokemons.length; i++) {
			pokemons[i] = new Pokemon();
			pokemons[i].setName("pokemon" + i);
		}
	}

	private static void showPokemons() {
		int contador = 1;
		for (int i = 0; i < pokemons.length; i++) {
			System.out.println(contador + ". " + pokemons[i].getName());
			contador++;
		}
	}

	private static void initCombat() {
		showPokemons();
		System.out.println();
		System.out.println("¿Que dos pokemons quieres enfrentar?");
		System.out.println("Número del primer pokemon: ");
		int pokemon1 = scanner.nextInt();
		System.out.println("Número del segundo pokemon: ");
		int pokemon2 = scanner.nextInt();
		System.out.println();
		if(pokemon1 >= 1 && pokemon1 <= 5) {
			if(pokemon2 >= 1 && pokemon2 <= 5) {
				Battle.initBattle(pokemons[pokemon1 - 1], pokemons[pokemon2 - 1]);
			}
			else {
				System.out.println("El número del segundo pokemon que has seleccionado no está disponible");
			}
		}
		else {
			System.out.println("El número del primer pokemon que has seleccionado no está disponible");
			if(pokemon2 < 1 || pokemon2 > 5) {
				System.out.println("El número del segundo pokemon que has seleccionado no está disponible");
			}
		}
	}
}
