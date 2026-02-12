package com.narxoz.rpg.config;

import com.narxoz.rpg.character.Archer;
import com.narxoz.rpg.character.Mage;
import com.narxoz.rpg.character.Warrior;
import com.narxoz.rpg.factory.CharacterFactory;
import com.narxoz.rpg.factory.MainCharacterFactory;

import java.util.Map;

public class AppConfig {
    public static CharacterFactory createMainCharacterFactory(){
        return new MainCharacterFactory(Map.of(
                "warrior", Warrior::new,
                "mage", Mage::new,
                "archer", Archer::new
        ));
    }
}
