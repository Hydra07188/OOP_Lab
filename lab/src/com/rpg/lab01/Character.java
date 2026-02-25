package com.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int maxHealthPoints;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPoints, Weapon weapon, String characterClass){
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int attack() {
        System.out.println(name + " (" + characterClass + ") attacks with " + weapon.getName() + "!");

        int levelBonus = level * 2;
        int totalDamage = weapon.getBaseDamage() + levelBonus;

        System.out.println(" Attack Damage: " + totalDamage + " (Weapon Base: " + weapon.getBaseDamage() + "+ Level Bonus: " + levelBonus + ")");

        return totalDamage;
    }
    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) this.healthPoints = 0;
        System.out.println(name + " takes " + damage + " damage! Current HP: " + healthPoints + "/" + maxHealthPoints);
    }

    public void levelUp() {
        this.level++;
        this.maxHealthPoints += 10;
        this.healthPoints = this.maxHealthPoints;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println(" Max Health increased to " + maxHealthPoints + " (full heal applied)");
    }
    public void displayCharacterDetails(){
        System.out.println(name.toUpperCase());
        System.out.println("Class: " + characterClass);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + healthPoints + "/" + maxHealthPoints);
        System.out.println("Weapon: " + weapon.toString());
    }
}
