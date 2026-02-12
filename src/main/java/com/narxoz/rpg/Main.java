package com.narxoz.rpg;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.config.AppConfig;

import java.util.Scanner;

/**
 * Main demonstration class for the RPG Character & Equipment System.
 *
 * Your task: Demonstrate both Factory Method and Abstract Factory patterns working together.
 *
 * This file should showcase:
 * 1. Creating different character types using Factory Method pattern
 * 2. Equipping characters with themed equipment using Abstract Factory pattern
 * 3. Displaying character stats and equipment details
 *
 * Expected output flow:
 * - Create 3+ different characters
 * - Equip each with different themed equipment sets
 * - Show that the system is extensible and maintainable
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Character & Equipment System ===\n");
        Scanner scan = new Scanner(System.in);
        Character warrior = AppConfig.createMainCharacterFactory().create("Warrior", "Abor");
        int choice = 0;
        boolean loop = true;
        while (loop) {
            choice = scan.nextInt();
            // TODO: Demonstrate Factory Method Pattern
            // Create different character types (Warrior, Mage, Archer, etc.)
            // Think: How can you create characters without using if-else chains?
            // Think: What class/interface should handle character creation?
            switch (choice){
                case 1 ->{System.out.println(warrior.getStats());}
                case 2 ->{warrior.useSpecialAbility();}
                case -1 -> {loop = false;}
            }


            // TODO: Demonstrate Abstract Factory Pattern
            // Create equipment sets (Medieval, Magic, Ranger, etc.)
            // Think: How do you ensure weapons and armor from same theme are created together?
            // Think: What guarantees a Medieval sword comes with Medieval armor?


            // TODO: Show character stats
            // Display each character's attributes (health, mana, strength, intelligence)
            // Show their special abilities


            // TODO: Equip characters with different themed sets
            // Warrior with Medieval equipment
            // Mage with Magic equipment
            // Archer with Ranger equipment
            // etc.


            // TODO: Display equipped items
            // Show weapon details (damage, special properties)
            // Show armor details (defense, special properties)


            // TODO: (Optional) Demonstrate extensibility
            // In comments, explain how easy it would be to:
            // - Add a new character class (e.g., Rogue, Paladin)
            // - Add a new equipment theme (e.g., Dragon Slayer, Undead)
        }
        System.out.println("\n=== Demo Complete ===");
    }

    // TODO: Add helper methods as needed
    // Consider methods like:
    // - createAndDisplayCharacter(...)
    // - equipCharacter(...)
    // - displayCharacterInfo(...)
}
