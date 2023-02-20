package fr.esgi.rent.samples;

import fr.esgi.rent.beans.RentalProperty;
import lombok.NoArgsConstructor;

import java.util.List;

import static fr.esgi.rent.beans.EnergyClassification.B;
import static fr.esgi.rent.beans.EnergyClassification.D;
import static fr.esgi.rent.beans.PropertyType.FLAT;
import static fr.esgi.rent.beans.PropertyType.HOUSE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class RentalPropertySample {

    public static List<RentalProperty> rentalProperties() {
        RentalProperty.RentalPropertyBuilder rentalPropertyBuilder = oneRentalPropertyBuilder();
        rentalPropertyBuilder.hasElevator(false);
        rentalPropertyBuilder.hasIntercom(false);
        rentalPropertyBuilder.hasParkingSpace(false);

        RentalProperty largeFlat = RentalProperty.builder()
                .referenceId(12850)
                .description("Appartement bien situé près du métro et des commerces")
                .town("Neuilly-sur-Seine")
                .address("90 rue de la Victoire")
                .propertyType(FLAT)
                .rentAmount(1040.90)
                .securityDepositAmount(1250.90)
                .area(50.69)
                .bedroomsCount(3)
                .floorNumber(2)
                .numberOfFloors(5)
                .constructionYear(1989)
                .energyClassification(B)
                .hasElevator(true)
                .hasIntercom(true)
                .hasBalcony(true)
                .hasParkingSpace(true)
                .build();

        RentalProperty house = RentalProperty.builder()
                .referenceId(83872)
                .description("Maison à louer dans banlieue calme et proche du RER")
                .town("Champs-sur-Marne")
                .address("12 rue de la Pyramide")
                .propertyType(HOUSE)
                .rentAmount(1050.90)
                .securityDepositAmount(1400.90)
                .area(62.50)
                .bedroomsCount(4)
                .constructionYear(2000)
                .energyClassification(B)
                .build();

        return List.of(rentalPropertyBuilder.build(), largeFlat, house);
    }

    public static RentalProperty oneRentalProperty() {
        return oneRentalPropertyBuilder().build();
    }

    public static RentalProperty.RentalPropertyBuilder oneRentalPropertyBuilder() {
        return RentalProperty.builder()
                .referenceId(46890)
                .description("Appartement spacieux avec vue sur l'ESGI")
                .town("Paris")
                .address("77 Rue des roses")
                .propertyType(FLAT)
                .rentAmount(750.90)
                .securityDepositAmount(1200.90)
                .area(37.48)
                .bedroomsCount(2)
                .floorNumber(1)
                .numberOfFloors(3)
                .constructionYear(1990)
                .energyClassification(D)
                .hasElevator(true)
                .hasIntercom(true)
                .hasBalcony(true)
                .hasParkingSpace(true);
    }

}
