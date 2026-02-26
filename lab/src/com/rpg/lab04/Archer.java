package com.rpg.lab04;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Destructible target) {
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        System.out.println(name + " (" + characterClass + ") shoots a precise arrow at " + targetName + "!");
        int baseDamage = this.damage + weapon.getBaseDamage();
        int rangeBonus = (int)(baseDamage * 0.3);
        int totalDamage = baseDamage + rangeBonus;
        System.out.println("Base Damage: " + baseDamage + " + Range Bonus: " + rangeBonus + " = " + totalDamage);
        System.out.println("Accuracy: " + accuracy + "% (HIT!)");
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