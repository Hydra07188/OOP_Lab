package com.rpg.lab04;


public class Healer extends Character {

    private int healingPower;

    public Healer(String name, int level, int healthPoints, int damage, int defense, Weapon weapon, int healingPower) {
        super(name, level, healthPoints, damage, defense, weapon, "Healer");
        this.healingPower = healingPower;
    }

    public void heal() {
        int bonus = getLevel() * 3;
        int healAmount = healingPower + bonus;

        int currentHP = getHealthPoints();
        int maxHP = getMaxHealthPoints();
        setHealthPoints(Math.min(currentHP + healAmount, maxHP));

        System.out.println(getName() + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount + " (Base: " + healingPower + " + Level Bonus: " + bonus + ")");
        System.out.println("Restored " + healAmount + " HP! Current HP: " + getHealthPoints() + "/" + maxHP);
    }

    public void healAlly(Character ally) {
        int bonus = getLevel() * 3;
        int healAmount = healingPower + bonus;

        int allyCurrentHP = ally.getHealthPoints();
        int allyMaxHP = ally.getMaxHealthPoints();
        ally.setHealthPoints(Math.min(allyCurrentHP + healAmount, allyMaxHP));

        System.out.println(getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Healing Amount: " + healAmount );
        System.out.println("Restored " + healAmount + " HP to " + ally.getName() + "! Their HP: " + ally.getHealthPoints());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        int totalHealingPower = healingPower + (getLevel() * 3);
        System.out.println("Healing Power: " + totalHealingPower);
    }
}