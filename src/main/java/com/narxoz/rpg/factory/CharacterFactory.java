package com.narxoz.rpg.factory;

import com.narxoz.rpg.character.Character;

public interface CharacterFactory {
    Character create(String type, String name);
}
