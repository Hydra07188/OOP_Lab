package src.com.rpg.lab02;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private int damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPoints, int damage, int defense, Weapon weapon, String characterClass){
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    // --- Getters & Setters ---
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealthPoints() { return healthPoints; }
    public void setHealthPoints(int hp) { this.healthPoints = hp; }
    public int getMaxHealthPoints() { return maxHealthPoints; }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    // --- Core Logic ---

    public void attack(Character target) {
        System.out.println(name + " (" + characterClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");

        int totalDamage = this.damage + weapon.getBaseDamage();
        System.out.println("Raw Attack Damage: " + totalDamage);

        target.takeDamage(totalDamage);
    }

    public void takeDamage(int incomingDamage) {
        int actualDamage = incomingDamage - this.defense;

        if (actualDamage < 0) actualDamage = 0;

        this.healthPoints -= actualDamage;
        if (this.healthPoints < 0) this.healthPoints = 0;

        System.out.println(name + "'s Defense: " + defense + " (reduces damage by " + defense + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);
        System.out.println(name + "'s HP: " + healthPoints + "/" + maxHealthPoints);
    }

    public void levelUp() {
        this.level++;
        this.maxHealthPoints += 10;
        this.healthPoints = this.maxHealthPoints; // Full heal
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHealthPoints + " (full heal applied)");
    }

    public void displayCharacterDetails(){
        System.out.println("=".repeat(20));
        System.out.println(name.toUpperCase());
        System.out.println("Class: " + characterClass);
        // แสดงสถานะ Active / Fainted
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + healthPoints + "/" + maxHealthPoints);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Weapon: " + weapon.toString());
    }
}