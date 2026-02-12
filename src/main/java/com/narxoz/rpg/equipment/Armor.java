package com.narxoz.rpg.equipment;

/**
 * Interface for all armor types in the game.
 *
 * Abstract Factory Pattern:
 * This is one of the "Product" interfaces in an Abstract Factory.
 * Each equipment theme (Medieval, Magic, Ranger) will have its own concrete armor.
 *
 * TODO: Define what all armor has in common
 * Think: What information should every armor provide?
 * Examples: defense, armor type, special properties, etc.
 */
public interface Armor {

    // TODO: Add armor behavior methods
    // Consider:
    // - int getDefense()
    // - String getArmorInfo()
    // - String getArmorType()
    // - any theme-specific properties?
     int getDefense();
     String getArmorInfo();
     String getArmorType();
     String getArmorMaterial();
     void displayInfo();
}
