package aero.champ.cargojson.booking;

import aero.champ.cargojson.common.*;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public class Example {

    public static void main(String[] args) {
        BookingRequest request = new BookingRequest();
        request.issueIataCarrierCode = Optional.of(new IATACarrierCode("LH"));
        request.airWaybillNumber = new AirWaybillNumber("020-12345678");
        request.customer = new Customer();
        request.customer.accountNumber = "1234567";
        request.customer.address = new Address();
        request.customer.address.name1 = "Big Spender";
        request.customer.address.streetAddress1 = "Road to serfdom";
        request.customer.address.country = new ISOCountryCode("DE");
        request.customer.address.postCode = "12345";
        request.origin = new IATAAirportCode("FRA");
        request.destination = new IATAAirportCode("ATL");
        request.loadType = LoadType.ULD;
        request.natureOfGoods = "Jellyfisch";
        PieceDetails pieceDetails = new PieceDetails();
        pieceDetails.heightCm = 12;
        pieceDetails.lengthCm = 24;
        pieceDetails.widthCm = 36;
        pieceDetails.numberOfPieces = 12;
        pieceDetails.totalWeightKg = BigDecimal.valueOf(12.3d);
        request.pieceDetails = Optional.of(Arrays.asList(pieceDetails));
        Segment segment = new Segment();
        segment.flight = new FlightIdentity("LH4711");
        segment.origin = new IATAAirportCode("FRA");
        segment.destination = new IATAAirportCode("ATL");
        segment.scheduledArrivalDate = LocalDate.now();
        segment.scheduledArrivalDate = LocalDate.now();
        request.segments = Optional.of(Arrays.asList(segment));
        request.volumeMtq = Optional.of(BigDecimal.valueOf(12.3d*12));
        request.weightKg = BigDecimal.valueOf(1312);
        System.out.println(DefaultObjectMapperBuilder.globalMapper().writeValueAsString(request));



    }
}
