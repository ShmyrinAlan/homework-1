package com.narxoz.rpg.character;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Archer implements Character{
    private final AtomicReference<String> name;
    private final AtomicInteger health;
    private final AtomicInteger mana;
    private final AtomicInteger strength;
    private final AtomicInteger intelligence;
    private Armor armor;
    private Weapon weapon;
    private final AtomicBoolean isAbility;
    private final ScheduledExecutorService service;

    public Archer(String name) {
        this.name = new AtomicReference<>(name);
        Random rn = new Random();
        // Archer stats: high intelligence and strength, low health and mana
        this.health = new AtomicInteger(rn.nextInt(60, 110));
        this.mana = new AtomicInteger(rn.nextInt(0,20));
        this.strength = new AtomicInteger(rn.nextInt(80,120));
        this.intelligence = new AtomicInteger(rn.nextInt(90,130));
        this.isAbility = new AtomicBoolean(false);
        this.service = Executors.newScheduledThreadPool(1);
    }

    @Override
    public String getStats() {
        return String.format(
                """
                =========== Archer ===========
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
            strength.set((int)Math.round(strength.get()*1.5));
            isAbility.set(true);
            System.out.println("Archer get focused(strength bonus 50% for the next 7s)");
            service.schedule(() -> {
                strength.set((int)Math.round(strength.get()/1.5));
                isAbility.set(false);
                System.out.println("Potion was ended");
            }, 7, TimeUnit.SECONDS);
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



}
