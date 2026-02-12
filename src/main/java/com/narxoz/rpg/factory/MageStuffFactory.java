package com.narxoz.rpg.factory;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@AllArgsConstructor
public class MageStuffFactory implements EquipmentFactory{
    private final Map<String, Supplier<Armor>> armorRegistry;
    private final Map<String, Supplier<Weapon>> weaponRegistry;
    @Override
    public Weapon createWeapon(String name) {
        Supplier<Weapon> item = weaponRegistry.get(name);
        if (Objects.isNull(item)) throw new IllegalArgumentException();
        return item.get();
    }

    @Override
    public Armor createArmor(String name) {
        Supplier<Armor> item = armorRegistry.get(name);
        if (Objects.isNull(item)) throw new IllegalArgumentException();
        return item.get();
    }
}
