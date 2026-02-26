package com.rpg.lab04;

public class StoneWall implements Destructible {
    private String location;
    private int durability;
    private int maxDurability;
    private String type;

    public StoneWall(String location, int durability, String type) {
        this.location = location;
        this.durability = durability;
        this.maxDurability = durability;
        this.type = type;
    }

    public String getLocation() { return location; }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) return;
        this.durability -= amount;
        System.out.print(location + " takes " + amount + " damage! ");
        if (this.durability <= 0) {
            System.out.println("(Durability: " + durability + "/" + maxDurability + ")");
            System.out.println(location + " has CRUMBLED to pieces!");
            this.durability = 0;
        } else {
            System.out.println("(Durability: " + durability + "/" + maxDurability + ")");
        }
    }

    @Override
    public boolean isDestroyed() { return durability <= 0; }

    public void displayWallDetails() {
        System.out.println(location.toUpperCase());
        System.out.println("Type: " + type);
        System.out.println("Status: " + (isDestroyed() ? "DESTROYED" : "STANDING"));
        System.out.println("Durability: " + durability + "/" + maxDurability);
    }
}