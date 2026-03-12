package com.rpg.lab06;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int healthPoints, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public int getAccuracy() { return accuracy; }
    public boolean hasRangeAdvantage() { return true; }


    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + weapon.toString());
    }
}