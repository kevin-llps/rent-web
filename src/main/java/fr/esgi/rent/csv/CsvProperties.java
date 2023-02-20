package fr.esgi.rent.csv;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CsvProperties {

    public static final String[] HEADERS = {
            "Id",
            "Description",
            "Ville",
            "Adresse",
            "Type de propriété",
            "Loyer mensuel",
            "Dépôt de garantie",
            "Surface",
            "Nombre de chambres",
            "Numéro d'étage",
            "Nombre d'étages",
            "Année de construction",
            "Classification énergétique",
            "Ascenseur",
            "Interphone",
            "Balcon",
            "Place de parking"
    };

}
