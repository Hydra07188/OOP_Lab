package com.rpg.lab04;

public class WoodenBox implements Destructible {
    private String name;
    private int health;
    private int maxHealth;
    private boolean locked;
    private String contains;

    public WoodenBox(String name, int health, boolean locked, String contains) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.locked = locked;
        this.contains = contains;
    }

    public String getName() { return name; }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) return;
        this.health -= amount;
        System.out.print(name + " takes " + amount + " damage! ");
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(name + " HP: 0/" + maxHealth + " (DESTROYED!)");
        } else {
            System.out.println(name + " HP: " + health + "/" + maxHealth);
        }
    }

    @Override
    public boolean isDestroyed() { return health <= 0; }

    public void displayBoxDetails() {
        System.out.println(name.toUpperCase() + " (WOODEN BOX)");
        System.out.println("Status: " + (isDestroyed() ? "Destroyed" : "Intact"));
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Locked: " + (locked ? "Yes" : "No"));
        System.out.println("Contains: " + contains);
    }

    public void breakOpen() {
        if (isDestroyed()) {
            System.out.println("The lock broke! " + name + " breaks open!");
            System.out.println("Contents revealed: " + contains);
        } else {
            System.out.println("Cannot break open " + name + " - it's still intact!");
        }
    }
}