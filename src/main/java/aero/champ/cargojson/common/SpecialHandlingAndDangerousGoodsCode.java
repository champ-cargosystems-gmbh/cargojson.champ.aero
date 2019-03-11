package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;

@JsonClassDescription("Enumeration of codes for special handling and dangerous goods.")
public enum SpecialHandlingAndDangerousGoodsCode {

    ACT("Active Temperature Controlled System"), AOG("Aircraft on Ground"), BUP("Bulk Unitization Programme, Shipper/Consignee Handled Unit"), CAO("Cargo Aircraft Only"), CAT("Cargo Attendant Accompanying Shipment"), NSC("Cargo Has Not Been Secured Yet for Passenger or All-Cargo Aircraft"), SHR("Secure for Passenger, All-Cargo and All-Mail Aircraft in Accordance with High Risk Requirements"), COM("Company Mail"), ECP("Consignment established with a paper air waybill contract being printed under an e-AWB agreement"), ECC("Consignment established with an electronically concluded cargo contract with no accompanying paper airwaybill"), CRT("Control Room Temperature +15°C to +25°C"), COL("Cool Goods"), RDS("Diagnostic Specimens"), DIP("Diplomatic Mail"), EAP("e-freight Consignment with Accompanying Paper Documents"), EAW("e-freight Consignment with No Accompanying Paper Documents"), REQ("Excepted Quantities of Dangerous Goods"), RRE("Excepted Quantities of Radioactive Material"), PES("Fish/Seafood"), PEF("Flowers"), EAT("Foodstuffs"), FRI("Frozen Goods Subject to Veterinary/Phytosanitary Inspections"), FRO("Frozen Goods"), PEP("Fruits and Vegetables"), ATT("Goods Attached to Air Waybill"), GOH("Hanging Garments"), HEG("Hatching Eggs"), HEA("Heavy Cargo/150 kilograms and over per piece"), HUM("Human Remains in Coffin"), PEA("Hunting trophies, skin, hide and all articles made from or containing parts of species listed in the CITES (Convention on International Trade in Endangered Species) appendices"), SCO("Cargo Secure forAll-Cargo Aircraft Only"), SPF("Laboratory Animals"), SPX("Cargo Secure for Passenger and All-Cargo Aircraft"), LIC("License Required"), AVI("Live Animal"), LHO("Living Human Organs/Blood"), MAL("Mail"), PEM("Meat"), MUW("Munitions of War"), NWP("Newspapers, Magazines"), OBX("Obnoxious Cargo"), BIG("Outsized"), OHG("Overhang Item"), PAC("Passenger and Cargo"), PER("Perishable Cargo"), PIL("Pharmaceuticals"), XPS("Priority Small Package"), QRT("Quick Ramp Transfer"), RAC("Reserved Air Cargo"), SHL("Save Human Life"), WET("Shipments of Wet Material not Packed in Watertight Containers"), SWP("Sporting Weapons"), SUR("Surface Transportation"), FIL("Undeveloped/Unexposed Film"), VAL("Valuable Cargo"), VIC("Very Important Cargo"), VOL("Volume"), VUN("Vulnerable Cargo"), PEB("Animal products for non-human consumption"), PHY("Goods subject to phytosanitary inspections"), VAG("SWISS Air Volume Agreement"), FSA("KLM FSA Code"), XPH("KLM XPH Code"), AER("KLM AER Code"), VIP("KLM VIP Code"), UCB("KLM UCB Code"), XPU("KLM XPU Code"), MON("KLM MON Code"), PEV("KLM PEV Code"), ART("KLM ART Code"), BSD("LH BSD Code"), BPL("LH BPL Code"), CSL("LH CSL Code"), DGR("LH DGR Code"), NOS("LH NOS Code"), PPL("LH PPL Code"), SEC("LH SEC Code"), SMU("LH SMU Code"), ZXF("LH ZXF Code"), ZXO("LH ZXO Code")
    ,ELI("Lithium Ion Batteries otherwise excepted from the IATA DGR", true)
    ,ELM("Lithium Metal Batteries otherwise excepted from the IATA DGR", true)
    ,RCM("Corrosive", true)
    ,RCL("Cryogenic Liquids", true)
    ,RFW("Dangerous When Wet", true)
    ,ICE("Dry Ice", true)
    ,REX("To be reserved for normally forbidden Explosives, Divisions 1.1, 1.2, 1.3, 1.4F, 1.5 and 1.6", true)
    ,RCX("Explosives 1.3C", true)
    ,RGX("Explosives 1.3G", true)
    ,RLI("Fully Regulated Lithium Ion Batteries (Class 9, true)", true)
    ,RLM("Fully Regulated Lithium Metal Batteries (Class 9, true)", true)
    ,RXB("Explosives 1.4B", true)
    ,RXC("Explosives 1.4C", true)
    ,RXD("Explosives 1.4D", true)
    ,RXE("Explosives 1.4E", true)
    ,RXG("Explosives 1.4G", true)
    ,RXS("Explosives 1.4S", true)
    ,RFG("Flammable Gas", true)
    ,RFL("Flammable Liquid", true)
    ,RFS("Flammable Solid", true)
    ,RIS("Infectious Substance", true)
    ,MAG("Magnetized Material", true)
    ,RMD("Miscellaneous Dangerous Goods", true)
    ,RNG("Non-Flammable Non-Toxic Gas", true)
    ,ROP("Organic Peroxide", true)
    ,ROX("Oxidizer", true)
    ,RPB("Toxic Substance", true)
    ,RPG("Toxic Gas", true)
    ,RSB("Polymeric Beads", true)
    ,RRW("Radioactive Material Category I-White", true)
    ,RRY("Radioactive Material Categories II-Yellow and III-Yellow", true)
    ,RSC("Spontaneously Combustible", true);

    public final String description;
    public final boolean isDangerousGoodsCode;

    SpecialHandlingAndDangerousGoodsCode(String decription) {
        this(decription,false);
    }

    SpecialHandlingAndDangerousGoodsCode(String decription, boolean isDangerousGoodsCode) {
        this.description = decription;
        this.isDangerousGoodsCode = isDangerousGoodsCode;
    }
}