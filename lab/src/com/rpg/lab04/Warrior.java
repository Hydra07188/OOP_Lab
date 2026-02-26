package com.rpg.lab04;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Destructible target) {
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        System.out.println(name + " (" + characterClass + ") performs a POWERFUL STRIKE on " + targetName + "!");
        int totalDamage = (int) ((this.damage + weapon.getBaseDamage()) * 1.5);
        System.out.println("Base Damage: " + (this.damage + weapon.getBaseDamage()) + " Enhanced: " + totalDamage + " (1.5x multiplier)");
        target.takeDamage(totalDamage);
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