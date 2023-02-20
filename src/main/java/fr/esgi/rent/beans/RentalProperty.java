package fr.esgi.rent.beans;

import lombok.Builder;
import org.apache.commons.csv.CSVRecord;

import java.util.function.Predicate;

import static fr.esgi.rent.beans.PropertyType.FLAT;

@Builder
public record RentalProperty(
        int referenceId,
        String description,
        String town,
        String address,
        PropertyType propertyType,
        double rentAmount,
        double securityDepositAmount,
        double area,
        int bedroomsCount,
        int floorNumber,
        int numberOfFloors,
        int constructionYear,
        EnergyClassification energyClassification,
        boolean hasElevator,
        boolean hasIntercom,
        boolean hasBalcony,
        boolean hasParkingSpace) {

    public static RentalProperty create(CSVRecord csvRecord, String[] headers, Predicate<String> testIfCsvFieldHasExpectedValue) {
        RentalPropertyBuilder builder = RentalProperty.builder()
                .referenceId(Integer.parseInt(csvRecord.get(headers[0])))
                .description(csvRecord.get(headers[1]))
                .town(csvRecord.get(headers[2]))
                .address(csvRecord.get(headers[3]))
                .propertyType(PropertyType.getByDesignation(csvRecord.get(headers[4])).orElse(null))
                .rentAmount(Double.parseDouble(csvRecord.get(headers[5])))
                .securityDepositAmount(Double.parseDouble(csvRecord.get(headers[6])))
                .area(Double.parseDouble(csvRecord.get(headers[7])))
                .bedroomsCount(Integer.parseInt(csvRecord.get(headers[8])))
                .constructionYear(Integer.parseInt(csvRecord.get(headers[11])))
                .energyClassification(EnergyClassification.getByName(csvRecord.get(headers[12])).orElse(null))
                .hasElevator(testIfCsvFieldHasExpectedValue.test(csvRecord.get(headers[13])))
                .hasIntercom(testIfCsvFieldHasExpectedValue.test(csvRecord.get(headers[14])))
                .hasBalcony(testIfCsvFieldHasExpectedValue.test(csvRecord.get(headers[15])))
                .hasParkingSpace(testIfCsvFieldHasExpectedValue.test(csvRecord.get(headers[16])));

        if (FLAT.equals(builder.propertyType)) {
            builder.floorNumber(Integer.parseInt(csvRecord.get(headers[9])))
                    .numberOfFloors(Integer.parseInt(csvRecord.get(headers[10])));
        }

        return builder.build();
    }

}
