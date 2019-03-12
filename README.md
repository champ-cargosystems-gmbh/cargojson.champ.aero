## cargoJSON(™) 
cargoJSON(™) is a message definition and format that has been defined and is owned by CHAMP to enable the air cargo industry stakeholders (airlines, handlers, forwarders, shippers, consignees, customs, truckers) to use as a means of exchanging air cargo data in a modern and open way. 

CHAMPs cargoJSON(™) is compatible with all existing cargo data sets (IATA CARGOIMP and IATA XML) and covers the key documents and processes in the industry. 

- Master and House Air Waybill
- Tracking
- Schedules
- Availability
- Booking
- Manifest

cargoJSON(™) can and will be extendible to cover the progress in the industry in terms of data coverage and technologies.

## Quickintroduction

To demonstrate the use of cargoJSON(™) we use a Flight Status Request as an example.

The Cargo Canonical message containing the request is handled in the structure provided by the class:

```java
aero.champ.cargojson.flightstatus.FlightStatusRequestMessage
```

This structure is a subtype identified by a type parameter named "type". The type name is always "flight status request" and the type information must be the first element in the JSON data. See also the JSON example below.

### Fields

Name | id
------ | ------
Description | Unique identification of the message.
Type | UUID
Required | yes
Example | 1f7cb56b-7aa4-4077-b38d-9371a24fa45c

Name | messageHeader
------ | ------
Description | The message header.
Type | MessageHeader
Required | yes

Name | payload (unwrapped, name not used in JSON)
------ | ------
Description | The body of the message containing the business payload.
Type | FlightStatusRequest
Required | no

### JSON Example

```json
{
  "type" : "flight status request",
  "id" : "1f7cb56b-7aa4-4077-b38d-9371a24fa45c",
  "messageHeader" : {
    "addressing" : {
      "routeVia" : {
        "type" : "PIMA",
        "address" : "REUAIR08AAL"
      },
      "routeAnswerVia" : {
        "type" : "PIMA",
        "address" : "REUAIR08AAL"
      },
      "senderAddresses" : [ {
        "type" : "PIMA",
        "address" : "REUAIR08AAL"
      } ],
      "finalRecipientAddresses" : [ {
        "type" : "PIMA",
        "address" : "REUAIR08AAL"
      } ],
      "replyAnswerTo" : [ {
        "type" : "PIMA",
        "address" : "REUAIR08AAL"
      } ]
    },
    "creationDate" : "2017-09-05T11:46:13.000",
    "edifactData" : {
      "commonAccessReference" : "10381",
      "messageReference" : "ORDERS:D:94B:UN",
      "password" : "test1234",
      "interchangeControlReference" : "abcde1234567"
    }
  },
  "airWaybillNumber" : "020-97162321",
  "originAndDestination" : {
    "origin" : "FRA",
    "destination" : "FRA"
  },
  "quantity" : {
    "shipmentDescriptionCode" : "DIVIDED_CONSIGNMENT",
    "numberOfPieces" : "8",
    "weight" : {
      "amount" : "100",
      "unit" : "KILOGRAM"
    }
  },
  "natureOfGoods" : "Black hats and sunglasses.",
  "flightDetailsList" : [ {
    "flight" : {
      "flight" : "LH116",
      "scheduledDate" : "2017-09-05",
      "scheduledTime" : "11:46:13.000"
    },
    "originAndDestination" : {
      "origin" : "FRA",
      "destination" : "FRA"
    },
    "spaceAllocationCode" : "XX",
    "allotmentIdentification" : "MRC7615164"
  } ],
  "otherServiceInformation" : "Extra charge due to special handling requirements."
}
```

### Usage

The message object is simply instatiated, by using the provided class:
```java
aero.champ.cargojson.jackson.DefaultObjectMapperBuilder
```

###### Example

Read a Flight Status Request from a .json file make some good use of it and get the altered version of the .json: 

```java
import aero.champ.cargojson.flightstatus.FlightStatusRequestMessage;
import aero.champ.cargojson.jackson.DefaultObjectMapperBuilder;
import aero.champ.cargojson.jackson.SimplifiedObjectMapper;

public class SimpleExample {

    SimplifiedObjectMapper mapper = DefaultObjectMapperBuilder.build();

    public String fsrExample(String fsrJson) {
        FlightStatusRequestMessage fsrMessage = mapper.readValue(fsrJson, FlightStatusRequestMessage.class);
        // Make some good use of the message
        return mapper.writeValueAsString(fsrMessage);
    }
}
``` 

### Maven repository

The repository can be used with: 

###### Gradle
```groovy
compile group: 'aero.champ', name :'cargojson', version: '1.0'
```

###### Maven
```xml
<dependency>
    <groupId>aero.champ</groupId>
    <artifactId>cargojson</artifactId>
    <version>1.0</version>
</dependency>
```

### License

Released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).

### Contact

For further information please contact our support team at:

[CargoHUB Support](mailto:cargohub.support@champ.aero)
