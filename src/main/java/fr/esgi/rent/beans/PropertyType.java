package fr.esgi.rent.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum PropertyType {
    FLAT("Appartement"),
    HOUSE("Maison");

    private final String designation;

    public static Optional<PropertyType> getByDesignation(String designation) {
        return Arrays.stream(values())
                .filter(propertyType -> propertyType.designation.equals(designation))
                .findAny();
    }

}
