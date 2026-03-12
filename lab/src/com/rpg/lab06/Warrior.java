package com.rpg.lab06;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack()));
    }


    @Override
    public void takeDamage(int incomingDamage) {
        int reducedDamage = incomingDamage - this.armorValue;
        if (reducedDamage < 0) reducedDamage = 0;
        System.out.println(name + "'s Armor: " + armorValue + " (reduces damage from " + incomingDamage + " to " + reducedDamage + ")");
        super.takeDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + armorValue);
        System.out.println("Weapon: " + weapon.toString());
    }
}