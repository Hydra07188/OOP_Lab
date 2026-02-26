package com.rpg.lab04;

public class CastleGate implements Destructible {
    private String name;
    private int durability;
    private int maxDurability;
    private boolean locked;
    private boolean reinforced;

    public CastleGate(String name, int durability, boolean locked, boolean reinforced) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = durability;
        this.locked = locked;
        this.reinforced = reinforced;
    }

    public String getName() { return name; }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) return;
        int actualDamage = amount;
        if (reinforced) {
            actualDamage = amount / 2;
            System.out.println(name + " is REINFORCED! (reduces damage from " + amount + " to " + actualDamage + ")");
        }
        this.durability -= actualDamage;
        System.out.print(name + " takes " + actualDamage + " damage! ");

        if (this.durability <= 0) {
            System.out.println("(Durability: " + durability + "/" + maxDurability + ")");
            System.out.println(name + " has been BREACHED! The gate COLLAPSES!");
            this.durability = 0;
        } else {
            System.out.println("(Durability: " + durability + "/" + maxDurability + ")");
        }
    }

    @Override
    public boolean isDestroyed() { return durability <= 0; }

    public void displayGateDetails() {
        System.out.println(name.toUpperCase());
        System.out.println("Status: " + (isDestroyed() ? "BREACHED" : "INTACT"));
        System.out.println("Durability: " + durability + "/" + maxDurability);
        System.out.println("Locked: " + (locked ? "Yes" : "No"));
        System.out.println("Reinforced: " + (reinforced ? "Yes" : "No"));
    }
}