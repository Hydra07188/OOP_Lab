package com.rpg.lab04;

public class Character implements Destructible {
    protected String name;
    protected int level;
    protected int healthPoints;
    protected int maxHealthPoints;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    protected String characterClass;

    public Character(String name, int level, int healthPoints, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealthPoints() { return healthPoints; }
    public void setHealthPoints(int hp) { this.healthPoints = hp; }
    public int getMaxHealthPoints() { return maxHealthPoints; }

    public boolean isAlive() { return healthPoints > 0; }

    public void attack(Destructible target) {
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        System.out.println(name + " (" + characterClass + ") attacks " + targetName + " with " + weapon.getName() + "!");
        int totalDamage = this.damage + weapon.getBaseDamage();
        System.out.println("Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount - this.defense;
        if (actualDamage < 0) actualDamage = 0;
        this.healthPoints -= actualDamage;
        if (this.healthPoints < 0) this.healthPoints = 0;
        System.out.println(name + "'s Defense: " + defense + " (reduces damage from " + amount + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);
        System.out.println(name + "'s HP: " + healthPoints + "/" + maxHealthPoints);
    }

    public void displayCharacterDetails() {
        System.out.println(name.toUpperCase() + " (" + characterClass.toUpperCase() + ")");
        System.out.println("Status: " + (isAlive() ? "Active" : "Fainted"));
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + healthPoints + "/" + maxHealthPoints);
        System.out.println("Damage: " + damage);
        System.out.println("Defense: " + defense);
    }

    @Override
    public boolean isDestroyed() { return !isAlive(); }
}