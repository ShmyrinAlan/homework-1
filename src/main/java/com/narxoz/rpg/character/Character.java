package com.narxoz.rpg.character;

/**
 * Base interface for all character types in the RPG system.
 *
 * TODO: Decide if this should be an interface or abstract class
 * Think: What's common to ALL characters?
 * Think: What varies between character types?
 *
 * Factory Method Pattern:
 * This represents the "Product" in the Factory Method pattern.
 * Different character classes (Warrior, Mage, Archer) are concrete products.
 */
public interface Character {

    // TODO: Define common character behaviors
    // Consider methods like:
    // - String getName()
    // - int getHealth()
    // - int getMana()
    // - int getStrength()
    // - int getIntelligence()
    // - void displayStats()
    // - void useSpecialAbility()

     String getName();
     int getHealth();
     int getMana();
     int getStrength();
     int getIntelligence();
     String  getStats();
     void useSpecialAbility();

    // TODO: Think about equipment
    // Should characters know about their equipped items?
    // How will you handle equipping weapons and armor?

}
