package com.narxoz.rpg.character;

import lombok.Data;

import java.util.Random;

/**
 * Example concrete implementation of a Character.
 *
 * This is provided as a reference to help you get started.
 * Study this implementation, then create similar classes for Mage, Archer, etc.
 *
 * Notice:
 * - How attributes are initialized
 * - How methods are implemented
 * - The structure you should follow for other character types
 *
 * TODO: Create similar implementations for:
 * - Mage (high mana/intelligence, low health/strength)
 * - Archer (balanced stats, ranged combat)
 * - (Optional) Additional classes: Rogue, Paladin, etc.
 */
@Data
public class Warrior implements Character {

    private String name;
    private int health;
    private int mana;
    private int strength;
    private int intelligence;
    private Random rn;
    private Thread ability;

    // TODO: Add fields for equipped weapon and armor
    // Think: Should Warrior know about its equipment?

    public Warrior(String name) {
        this.name = name;
        this.rn = new Random();
        // Warrior stats: high health and strength, low mana and intelligence
        this.health = rn.nextInt(150, 200);
        this.mana = rn.nextInt(10,50);
        this.strength = rn.nextInt(70,100);
        this.intelligence = rn.nextInt(5,23);
        this.ability = new Thread(()->{
            long endTime = System.nanoTime() + 10 *1_000_000_000L;
            strength = (int)Math.round(strength*1.2);
            health = (int)Math.round(health*1.3);
            System.out.println("For the next 10s warrior gets a berserk mod(strength bonus 20% and health bonus 30%)");
            while (System.nanoTime()<endTime){}
            strength = (int)Math.round(strength/1.2);
            health = (int)Math.round(health/1.3);
            System.out.println("Berserk mod was ended");
        });
    }

    @Override
    public String getStats() {
        return String.format(
                """
                =========== Warrior ===========
                Name: %s
                HP: %d
                Mana: %d
                Strength: %d
                Intelligence: %d
                """, name,health,mana,strength,intelligence);
    }

    @Override
    public void useSpecialAbility() {
        if(ability.isAlive()){
            System.out.println("Ability is");
        }else {
            ability.start();
        }
    }

    // TODO: Implement methods from Character interface
    // You need to define those methods in Character interface first!


    // TODO: Add equipment-related methods
    // Examples:
    // - void equipWeapon(Weapon weapon)
    // - void equipArmor(Armor armor)
    // - void displayEquipment()

}
