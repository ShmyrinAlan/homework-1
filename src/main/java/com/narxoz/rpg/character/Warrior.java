package com.narxoz.rpg.character;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
public class Warrior implements Character {

    private final AtomicReference<String> name;
    private final AtomicInteger health;
    private final AtomicInteger mana;
    private final AtomicInteger strength;
    private final AtomicInteger intelligence;
    private Armor armor;
    private Weapon weapon;
    private final AtomicBoolean isAbility;
    private final ScheduledExecutorService service;

    // TODO: Add fields for equipped weapon and armor
    // Think: Should Warrior know about its equipment?

    public Warrior(String name) {
        this.name = new AtomicReference<>(name);
        Random rn = new Random();
        // Warrior stats: high health and strength, low mana and intelligence
        this.health = new AtomicInteger(rn.nextInt(150, 200));
        this.mana = new AtomicInteger(rn.nextInt(10,50));
        this.strength = new AtomicInteger(rn.nextInt(70,100));
        this.intelligence = new AtomicInteger(rn.nextInt(5,23));
        this.isAbility = new AtomicBoolean(false);
        this.service = Executors.newScheduledThreadPool(1);
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
                """, name.get(),health.get(),mana.get(),strength.get(),intelligence.get());
    }

    @Override
    public void useSpecialAbility() {
        if(isAbility.get()){
            System.out.println("Ability is");
        }else {
            strength.set((int)Math.round(strength.get()*1.2));
            health.set((int)Math.round(health.get()*1.3));
            isAbility.set(true);
            System.out.println("For the next 10s warrior gets a berserk mod(strength bonus 20% and health bonus 30%)");
            service.schedule(() -> {
                strength.set((int)Math.round(strength.get()/1.2));
                health.set((int)Math.round(health.get()/1.3));
                isAbility.set(false);
                System.out.println("Berserk mod was ended");
            }, 10, TimeUnit.SECONDS);
        }
    }

    @Override
    public void dispose() {
        service.shutdown();
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public void displayEquipment() {
        System.out.println("=======================");
        weapon.displayInfo();
        System.out.println("=======================");
        armor.displayInfo();
        System.out.println("=======================");
    }

    // TODO: Implement methods from Character interface
    // You need to define those methods in Character interface first!

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public int getHealth() {
        return health.get();
    }

    @Override
    public int getMana() {
        return mana.get();
    }

    @Override
    public int getStrength() {
        return strength.get();
    }

    @Override
    public int getIntelligence() {
        return intelligence.get();
    }


    // TODO: Add equipment-related methods
    // Examples:
    // - void equipWeapon(Weapon weapon)
    // - void equipArmor(Armor armor)
    // - void displayEquipment()



}
