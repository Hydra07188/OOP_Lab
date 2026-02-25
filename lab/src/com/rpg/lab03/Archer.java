package com.rpg.lab03;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Character target) {
        System.out.println("(Using Archer.attack() - Ranged arrow attack with accuracy)");
        System.out.println(name + " (" + characterClass + ") shoots an arrow at " + target.getName() + " with " + weapon.getName() + "!");
        int totalDamage = this.damage + weapon.getBaseDamage();
        System.out.println("Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + weapon.toString());
    }
}