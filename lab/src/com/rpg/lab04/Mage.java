package com.rpg.lab04;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int healthPoints, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    public void attack(Character target) {
        System.out.println("(Using Mage.attack() - Magic Missile spell)");
        System.out.println(name + " (" + characterClass + ") casts Magic Missile at " + target.getName() + "!");
        int totalDamage = this.damage + weapon.getBaseDamage();
        System.out.println("Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Weapon: " + weapon.toString());
    }
}