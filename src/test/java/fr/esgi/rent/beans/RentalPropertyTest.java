package fr.esgi.rent.beans;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.esgi.rent.samples.RentalPropertySample.oneRentalProperty;
import static fr.esgi.rent.samples.RentalPropertySample.oneRentalPropertyBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalPropertyTest {

    private static final String[] HEADERS = {
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

    @ParameterizedTest
    @MethodSource("provideCsvValuesAndExpectedRentalProperty")
    void shouldCreate(String[] csvValues, RentalProperty expectedRentalProperty) {
        CSVRecord csvRecord = mock(CSVRecord.class);

        when(csvRecord.get(HEADERS[0])).thenReturn(csvValues[0]);
        when(csvRecord.get(HEADERS[1])).thenReturn(csvValues[1]);
        when(csvRecord.get(HEADERS[2])).thenReturn(csvValues[2]);
        when(csvRecord.get(HEADERS[3])).thenReturn(csvValues[3]);
        when(csvRecord.get(HEADERS[4])).thenReturn(csvValues[4]);
        when(csvRecord.get(HEADERS[5])).thenReturn(csvValues[5]);
        when(csvRecord.get(HEADERS[6])).thenReturn(csvValues[6]);
        when(csvRecord.get(HEADERS[7])).thenReturn(csvValues[7]);
        when(csvRecord.get(HEADERS[8])).thenReturn(csvValues[8]);
        when(csvRecord.get(HEADERS[9])).thenReturn(csvValues[9]);
        when(csvRecord.get(HEADERS[10])).thenReturn(csvValues[10]);
        when(csvRecord.get(HEADERS[11])).thenReturn(csvValues[11]);
        when(csvRecord.get(HEADERS[12])).thenReturn(csvValues[12]);
        when(csvRecord.get(HEADERS[13])).thenReturn(csvValues[13]);
        when(csvRecord.get(HEADERS[14])).thenReturn(csvValues[14]);
        when(csvRecord.get(HEADERS[15])).thenReturn(csvValues[15]);
        when(csvRecord.get(HEADERS[16])).thenReturn(csvValues[16]);

        RentalProperty rentalProperty = RentalProperty.create(csvRecord, HEADERS, (csvField) -> true);

        assertThat(rentalProperty).isEqualTo(expectedRentalProperty);
    }

    private static Stream<Arguments> provideCsvValuesAndExpectedRentalProperty() {
        String[] csvValues = {"46890", "Appartement spacieux avec vue sur l'ESGI", "Paris", "77 Rue des roses", "Appartement", "750.90", "1200.90", "37.48", "2", "1", "3", "1990", "D", "non", "non", "oui", "non"};
        String[] csvValuesWithUnknownPropertyType = {"46890", "Appartement spacieux avec vue sur l'ESGI", "Paris", "77 Rue des roses", "Unknown", "750.90", "1200.90", "37.48", "2", "1", "3", "1990", "D", "non", "non", "oui", "non"};
        String[] csvValuesWithUnknownEnergyClassification = {"46890", "Appartement spacieux avec vue sur l'ESGI", "Paris", "77 Rue des roses", "Appartement", "750.90", "1200.90", "37.48", "2", "1", "3", "1990", "Unknown", "non", "non", "oui", "non"};

        RentalProperty.RentalPropertyBuilder rentalPropertyWithNullPropertyTypeBuilder = oneRentalPropertyBuilder();
        rentalPropertyWithNullPropertyTypeBuilder.propertyType(null);
        rentalPropertyWithNullPropertyTypeBuilder.floorNumber(0);
        rentalPropertyWithNullPropertyTypeBuilder.numberOfFloors(0);

        RentalProperty.RentalPropertyBuilder rentalPropertyWithNullEnergyClassificationBuilder = oneRentalPropertyBuilder();
        rentalPropertyWithNullEnergyClassificationBuilder.energyClassification(null);

        return Stream.of(
                Arguments.of(csvValues, oneRentalProperty()),
                Arguments.of(csvValuesWithUnknownPropertyType, rentalPropertyWithNullPropertyTypeBuilder.build()),
                Arguments.of(csvValuesWithUnknownEnergyClassification, rentalPropertyWithNullEnergyClassificationBuilder.build()));
    }

}
