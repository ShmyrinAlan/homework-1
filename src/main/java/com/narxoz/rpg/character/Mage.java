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

// Just a copy of warrior class with changes for mage's ability and stats generation
public class Mage implements Character{
    private final AtomicReference<String> name;
    private final AtomicInteger health;
    private final AtomicInteger mana;
    private final AtomicInteger strength;
    private final AtomicInteger intelligence;
    private Armor armor;
    private Weapon weapon;
    private final AtomicBoolean isAbility;
    private final ScheduledExecutorService service;

    public Mage(String name) {
        this.name = new AtomicReference<>(name);
        Random rn = new Random();
        // Mage stats: high intelligence and mana, low health and strength
        this.health = new AtomicInteger(rn.nextInt(60, 90));
        this.mana = new AtomicInteger(rn.nextInt(100,200));
        this.strength = new AtomicInteger(rn.nextInt(10,40));
        this.intelligence = new AtomicInteger(rn.nextInt(100,150));
        this.isAbility = new AtomicBoolean(false);
        this.service = Executors.newScheduledThreadPool(1);
    }

    @Override
    public String getStats() {
        return String.format(
                """
                =========== Mage ===========
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
            intelligence.set((int)Math.round(intelligence.get()*1.5));
            mana.set((int)Math.round(mana.get()*1.3));
            isAbility.set(true);
            System.out.println("Potion was used(intelligence bonus 50% and mana bonus 30% for the next 20s)");
            service.schedule(() -> {
                intelligence.set((int)Math.round(intelligence.get()/1.5));
                mana.set((int)Math.round(mana.get()/1.3));
                isAbility.set(false);
                System.out.println("Potion was ended");
            }, 20, TimeUnit.SECONDS);
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
