package com.rpg.lab04;

public class HealthPotion implements Consumable {
    private String name;
    private int healingPower;
    private int quantity;

    public HealthPotion(String name, int healingPower, int quantity) {
        this.name = name;
        this.healingPower = healingPower;
        this.quantity = quantity;
    }

    @Override
    public void use(Character user) {
        if (quantity > 0) {
            System.out.println(user.getName() + " drinks " + name + "!");
            int oldHp = user.getHealthPoints();
            int newHp = Math.min(oldHp + healingPower, user.getMaxHealthPoints());
            user.setHealthPoints(newHp);
            quantity--;
            System.out.println("Health restored: " + oldHp + " -> " + newHp + " (+" + healingPower + ")");
            System.out.println(name + " remaining: " + quantity);
        }
    }

    public void displayPotionDetails() {
        System.out.println(name.toUpperCase());
        System.out.println("Healing Power: " + healingPower + " HP");
        System.out.println("Quantity: " + quantity);
        System.out.println("Type: Consumable");
    }
}