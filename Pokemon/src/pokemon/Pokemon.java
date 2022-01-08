package pokemon;

public class Pokemon {

	private static final int INITIAL_HEALTH = 301;
	private static final int INITIAL_STRENGTH = 51;
	private static final int INITIAL_SPEED = 201;
	private int health;
	private int strength;
	private int speed;
	private String name;
	private String tipo;
	private int originalStrength;

	public Pokemon() {
		int randomHealth = (int) (Math.random() * INITIAL_HEALTH + 1);
		int randomStrength = (int) (Math.random() * INITIAL_STRENGTH + 1);
		int randomSpeed = (int) (Math.random() * INITIAL_SPEED + 1);

		health = randomHealth;
		strength = randomStrength;
		speed = randomSpeed;
		name = "";
		tipo = "";
		originalStrength = strength;
	}

	public Pokemon(int health, int strength, int speed, String name, String tipo) {
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.name = name;
		this.tipo = tipo;
		originalStrength = strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void duplicarFuerza() {
		strength += strength;
	}

	public void fuerzaInicial() {
		strength = originalStrength;
	}
}
