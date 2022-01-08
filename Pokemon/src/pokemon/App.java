package pokemon;

import java.util.Scanner;

public class App {
	private static final int NUM_POKEMONS = 5;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("------------------------------------");
		System.out.println("Tipo de combate pokemon: ");
		System.out.println("1. Combate 1vs1");
		System.out.println("2. Combate " + NUM_POKEMONS + "vs" + NUM_POKEMONS);
		System.out.println("------------------------------------");
		int tipoCombate = scanner.nextInt();

		switch (tipoCombate) {
		case 1:
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
			break;
		case 2:
			initMultipleCombat();
			break;
		default:
			System.out.println("Opción incorrecta");
		}

	}

	private static void initPokemons() {
		Pokemon charizard = new Pokemon(100, 50, 50, "charizard", "fuego");
		pokemons[0] = charizard;
		Pokemon blastoise = new Pokemon(150, 25, 150, "blastoire", "agua");
		pokemons[1] = blastoise;
		Pokemon venusaur = new Pokemon(300, 10, 100, "venusaur", "planta");
		pokemons[2] = venusaur;
		Pokemon bulbasaur = new Pokemon(250, 20, 180, "bulbasaur", "tierra");
		pokemons[3] = bulbasaur;
		Pokemon pikachu = new Pokemon(300, 40, 200, "pikachu", "electrico");
		pokemons[4] = pikachu;
	}

	private static void initPokemonsRandomly() {
		for (int i = 0; i < pokemons.length; i++) {
			pokemons[i] = new Pokemon();
			pokemons[i].setName("pokemon" + i);
		}
		int numeroRandomTipo = 0;
		String tipo = "";
		for (int i = 0; i < pokemons.length; i++) {
			numeroRandomTipo = (int) (Math.random() * 5 + 1);
			switch (numeroRandomTipo) {
			case 1:
				tipo = "agua";
				break;
			case 2:
				tipo = "fuego";
				break;
			case 3:
				tipo = "planta";
				break;
			case 4:
				tipo = "electrico";
				break;
			case 5:
				tipo = "tierra";
				break;
			default:
				tipo = "";
				break;
			}
			pokemons[i].setTipo(tipo);
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
		if (pokemon1 >= 1 && pokemon1 <= 5) {
			if (pokemon2 >= 1 && pokemon2 <= 5) {
				Battle.initBattle(pokemons[pokemon1 - 1], pokemons[pokemon2 - 1]);
			} else {
				System.out.println("El número del segundo pokemon que has seleccionado no está disponible");
			}
		} else {
			System.out.println("El número del primer pokemon que has seleccionado no está disponible");
			if (pokemon2 < 1 || pokemon2 > 5) {
				System.out.println("El número del segundo pokemon que has seleccionado no está disponible");
			}
		}
	}

	private static void initMultipleCombat() {
		Pokemon[] pokemonsRandom = new Pokemon[NUM_POKEMONS];
		initPokemonsRandomly();
		for (int i = 0; i < pokemons.length; i++) {
			pokemonsRandom[i] = pokemons[i];
		}
		initPokemons();
		int contador = 0;

		int contadorDerrotaPokemon = 0;
		int contadorDerrotaPokemonRandom = 0;

		while (contadorDerrotaPokemon < NUM_POKEMONS && contadorDerrotaPokemonRandom < NUM_POKEMONS) {
			System.out.println("------------------------------------");
			showPokemons();
			System.out.println("------------------------------------");
			int pokemonSeleccionado = 0;
			while (pokemonSeleccionado < 1 || pokemonSeleccionado > 5) {
				System.out.println("Selecciona el pokemon que va a salir al campo de batalla: ");
				pokemonSeleccionado = scanner.nextInt();
				if (pokemonSeleccionado < 1 || pokemonSeleccionado > 5) {
					System.out.println("El número del pokemon que has seleccionado no está disponible");
				}
			}
			if (pokemons[pokemonSeleccionado - 1].getHealth() <= 0) {
				System.out.println("El pokemon " + pokemons[pokemonSeleccionado - 1].getName()
						+ " ha sido derrotado, selecciona otro: ");

			} else {
				Battle.initBattle(pokemons[pokemonSeleccionado - 1], pokemonsRandom[contador]);
				if (pokemons[pokemonSeleccionado - 1].getHealth() <= 0) {
					contadorDerrotaPokemon++;
				} else {
					contadorDerrotaPokemonRandom++;
					contador++;
				}
			}

		}
		System.out.println();
		if (contadorDerrotaPokemon > contadorDerrotaPokemonRandom) {
			System.out.println("DERROTA: Todos tus pokemon han sido derrotados");
		} else {
			System.out.println("VICTORIA: Todos los pokemon de tu rival han sido derrotados");
		}
		System.out.println("FIN DEL JUEGO");
	}
}
