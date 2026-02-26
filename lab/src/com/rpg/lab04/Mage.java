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
    public void attack(Destructible target) {
        String targetName = (target instanceof Character) ? ((Character) target).getName() : "Target";
        if (mana < 30) {
            System.out.println(name + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("Current Mana: " + mana + "/" + maxMana + " (Need: 30)");
            return;
        }
        System.out.println(name + " (" + characterClass + ") casts MAGIC MISSILE at " + targetName + "!");
        int baseSpell = this.damage + weapon.getBaseDamage();
        int spellBonus = 10;
        int totalDamage = baseSpell + spellBonus;
        mana -= 30;
        System.out.println("Spell Damage: " + totalDamage + " (Base: " + baseSpell + " + Spell Bonus: " + spellBonus + ")");
        System.out.println("Mana Used: 30 | Remaining: " + mana + "/" + maxMana);
        target.takeDamage(totalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Weapon: " + weapon.toString());
    }
}