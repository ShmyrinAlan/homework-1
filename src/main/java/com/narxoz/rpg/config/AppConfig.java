package com.narxoz.rpg.config;

import com.narxoz.rpg.character.Archer;
import com.narxoz.rpg.character.Mage;
import com.narxoz.rpg.character.Warrior;
import com.narxoz.rpg.equipment.*;
import com.narxoz.rpg.factory.*;

import java.util.Map;

public class AppConfig {
    public static CharacterFactory createMainCharacterFactory(){
        return new MainCharacterFactory(Map.of(
                "warrior", Warrior::new,
                "mage", Mage::new,
                "archer", Archer::new
        ));
    }

    public static EquipmentFactory createEquipmentFactory(String type){
        switch (type.toLowerCase().trim()){
            case "warrior" -> {
                return new WarriorStuffFactory(
                        Map.of(
                             "helmet", Helmet::new,
                                "no armor", NoArmor::new
                        ),
                        Map.of(
                                "iron sword", IronSword::new,
                                "no weapon", NoWeapon::new
                        ));
            }
            case "mage" -> {
                return new MageStuffFactory(Map.of(
                        "mage robe", MageRobe::new,
                        "no armor", NoArmor::new
                ), Map.of(
                        "gendalf's stick", GendalfsStick::new,
                        "no weapon", NoWeapon::new
                ));
            }
            case "archer" -> {
                return new ArcherStuffFactory(Map.of(
                        "archer armor", ArcherArmor::new,
                        "no armor", NoArmor::new
                ), Map.of(
                        "elven bow", ElvenBow::new,
                        "no weapon", NoWeapon::new
                ));
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
