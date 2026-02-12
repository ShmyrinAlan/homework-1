package com.narxoz.rpg.factory;

import com.narxoz.rpg.character.Character;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@AllArgsConstructor
public class MainCharacterFactory implements CharacterFactory{
    private final Map<String, Function<String,Character>> registry;

    @Override
    public Character create(String type, String name) {
        Function<String,Character> characterType = registry.get(type);
        if (Objects.isNull(characterType)) throw new IllegalArgumentException();
        return characterType.apply(name);
    }
}
