package com.narxoz.rpg;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.config.AppConfig;

import java.util.Objects;
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
        Character character = null;
        String type, name, choice;
        boolean loop = true;
        while (loop) {
            // TODO: Demonstrate Factory Method Pattern
            // Create different character types (Warrior, Mage, Archer, etc.)
            // Think: How can you create characters without using if-else chains?
            // Think: What class/interface should handle character creation?
            if (Objects.isNull(character)){
                System.out.println("""
                        =========================
                        Choice a character type:
                        Mage
                        Warrior
                        Archer
                        ============================""");
                type = scan.nextLine().toLowerCase().trim();
                System.out.println("Enter a character's name: ");
                name = scan.nextLine().toLowerCase().trim();
                try{
                    character = AppConfig.createMainCharacterFactory().create(type,name);
                }catch (IllegalArgumentException e){
                    System.out.println("type is undefined");
                }
            }else {
                System.out.println("""
                        ========================
                        write an action command:
                        show stats
                        use ability
                        stop
                        =========================""");
                choice = scan.nextLine();
                switch (choice.trim().toLowerCase()){
                    case "show stats" -> {
                        System.out.println(character.getStats());}
                    case "use ability" -> {character.useSpecialAbility();}
                    case "stop" -> {loop = false;}
                    default -> {
                        System.out.println("Bad command");
                    }
                }
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
        character.dispose();
        System.out.println("\n=== Demo Complete ===");
    }

    // TODO: Add helper methods as needed
    // Consider methods like:
    // - createAndDisplayCharacter(...)
    // - equipCharacter(...)
    // - displayCharacterInfo(...)
}
