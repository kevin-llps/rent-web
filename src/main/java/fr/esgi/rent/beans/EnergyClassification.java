package fr.esgi.rent.beans;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public enum EnergyClassification {
    A,
    B,
    C,
    D,
    E,
    F,
    G;

    public static Optional<EnergyClassification> getByName(String name) {
        return Arrays.stream(values())
                .filter(energyClassification -> energyClassification.name().equals(name))
                .findAny();
    }

}
