package src.com.rpg.lab03;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int healthPoints, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, healthPoints, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        System.out.println(" (Using Warrior.attack() - 1.5x damage bonus)");
        System.out.println(name + " (" + characterClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");
        int totalDamage = (int) ((this.damage + weapon.getBaseDamage()) * 1.5);
        System.out.println("Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }

    @Override
    public void takeDamage(int incomingDamage) {
        int reducedDamage = incomingDamage - this.armorValue;
        if (reducedDamage < 0) reducedDamage = 0;

        super.takeDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + armorValue);
        System.out.println("Weapon: " + weapon.toString());
    }
}