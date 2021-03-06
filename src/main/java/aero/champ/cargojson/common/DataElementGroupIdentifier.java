package aero.champ.cargojson.common;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@JsonClassDescription("Code identifying a particular group of data elements.")
public enum DataElementGroupIdentifier {

    ACC("ACC", "Accounting Information")
    ,AGT("AGT", "(Nominated) Agent (Coded)/Consignee")
    ,ARD("ARD", "Agent Reference Data")
    ,API("API", "Air Waybill Piece Information")
    ,AIR("AIR", "Airline Header")
    ,ALA("ALA", "Allotment Availability Information")
    ,ALI("ALI", "Allotment Information")
    ,ALR("ALR", "Allotment Remaining")
    ,ALT("ALT", "Allotment Total")
    ,AUD("AUD", "Allotment Used Details")
    ,NFY("NFY", "(Also) Notify (Name and Address)")
    ,AMD("AMD", "Amendment Identification")
    ,AID("AID", "Arrival Information Details")
    ,ATH("ATH", "Authorisation")
    ,AVS("AVS", "Availability Supplementary Details")
    ,ABI("ABI", "AWB Amount Detail Information")
    ,ACS("ACS", "AWB Charge Summary")
    ,ACD("ACD", "AWB Consignment Details")
    ,CER("CER", "AWB Content Certification")
    ,ISU("ISU", "AWB Issue Details")
    ,ARI("ARI", "AWB Recapitulation Information")
    ,ABS("ABS", "AWB Supplementary Information")
    ,ABT("ABT", "AWB Total Amount Information")
    ,ATW("ATW", "AWB Total Weight Summary")
    ,BGD("BGD", "Baggage Detail Information")
    ,BGT("BGT", "Baggage Tag Identification")
    ,REF("REF", "Booking/Sender/Request References")
    ,BRK("BRK", "Broker")
    ,CCL("CCL", "Cargo Control Location")
    ,CRD("CRD", "Carrier Reference Data")
    ,CWI("CWI", "CASS AWB Information")
    ,CBD("CBD", "CASS Billing Details")
    ,CBI("CBI", "CASS Billing Information")
    ,CBP("CBP", "CASS Billing Period")
    ,CIN("CIN", "CASS Identification Number")
    ,CIH("CIH", "CASS Invoice Header Details")
    ,CDC("CDC", "CC Charges in Destination Currency")
    ,CAI("CAI", "CCA/Adjustment Information")
    ,CAS("CAS", "CCA/Adjustment Supplementary Information")
    ,CTI("CTI", "CCA/Adjustment Total Information")
    ,CTW("CTW", "CCA/Adjustment Total Weight Summary")
    ,RQD("RQD", "Charge Calculation Answer Details")
    ,RQT("RQT", "Charge Calculation Answer Totals")
    ,RQH("RQH", "Charge Calculation Request Header")
    ,RQU("RQU", "Charge Calculation Request — ULD")
    ,RQV("RQV", "Charge Calculation Request — Volume")
    ,CDI("CDI", "Charge Declarations")
    ,CVD("CVD", "Charge Declarations")
    ,COL("COL", "Collect Charge Summary")
    ,COI("COI", "Commission Information")
    ,CNE("CNE", "Consignee Name and Address")
    ,CCD("CCD", "Consignment Control Details")
    ,CMI("CMI", "Consignment Onward Movement Information")
    ,CID("CID", "Correction Identification")
    ,CBR("CBR", "Courier Baggage Receiver")
    ,CBS("CBS", "Courier Baggage Sender")
    ,CBV("CBV", "Courier Baggage Voucher Identification")
    ,CUR("CUR", "Currency Details")
    ,CUS("CUS", "Customer Identification")
    ,CAN("CAN", "Customs Action Notification")
    ,CND("CND", "Customs Notification Details")
    ,COR("COR", "Customs Origin")
    ,DTN("DTN", "Date/Time of Notification / DGD Item Technical Name")
    ,DCL("DCL", "Declarant")
    ,DES("DES", "Despatch Information")
    ,DAI("DAI", "DGD Additional Handling Information")
    ,DAP("DAP", "DGD “All Packed in One” Indication")
    ,DAT("DAT", "DGD “All Packed in One” Total")
    ,DCI("DCI", "DGD Emergency Contact Information")
    ,DHD("DHD", "DGD Header Details")
    ,DAU("DAU", "DGD Item Authorisation")
    ,DII("DII", "DGD Item Information")
    ,DNR("DNR", "DGD Item Number")
    ,DPI("DPI", "DGD Item Packing Group and Instructions")
    ,DQP("DQP", "DGD Item Quantity and Type of Packing")
    ,DSN("DSN", "DGD Item Shipping Name")
    ,DOS("DOS", "DGD Overpack Summary")
    ,DRA("DRA", "DGD Radioactive Activity Information")
    ,DRC("DRC", "DGD Radioactive Consignment Information")
    ,DRP("DRP", "DGD Radioactive Packing Instructions")
    ,DSU("DSU", "DGD Signatory Details")
    ,DIM("DIM", "Dimensions Information")
    ,DOC("DOC", "Documentation Identification")
    ,CRR("CRR", "Embargo Carriage Restrictions")
    ,COM("COM", "Embargoed Commodities")
    ,JST("JST", "Embargo Justification")
    ,RTS("RTS", "Embargo Routes/Areas")
    ,EIC("EIC", "Empty Equipment in Compartment Information")
    ,EXP("EXP", "Export")
    ,FLT("FLT", "Flight Booking/Information")
    ,TXT("TXT", "Free Text Description")
    ,GRI("GRI", "Grand AWB Recapitulation Information")
    ,GTI("GTI", "Grand Total Information")
    ,HDL("HDL", "Handling Details")
    ,HTS("HTS", "Harmonised Tariff Schedule Information")
    ,HWB("HWB", "House Waybill")
    ,HPI("HPI", "House Waybill Piece Information")
    ,HAH("HAH", "HWB Agent’s Head Office")
    ,HCD("HCD", "HWB Consignment Details")
    ,HLC("HLC", "HWB Letter of Credit Details")
    ,HBS("HBS", "House Waybill Summary Details")
    ,IMP("IMP", "Import")
    ,ITA("ITA", "Invoice Total Amount Information")
    ,ITW("ITW", "Invoice Total Weight Summary")
    ,LOC("LOC", "Location")
    ,MAL("MAL", "Mail")
    ,MCH("MCH", "Mail Consignment Header")
    ,MCT("MCT", "Mail Consignment Total")
    ,MHU("MHU", "Mail Handling Unit")
    ,MID("MID", "Mail Inbound Data")
    ,MLI("MLI", "Mail Label Identification")
    ,MOD("MOD", "Mail Outbound Data")
    ,MSD("MSD", "Mail Status Details")
    ,MUD("MUD", "Mail ULD Information")
    ,MBI("MBI", "Master Waybill Identification")
    ,MSU("MSU", "Message Sequence and ULD Origin")
    ,MAT("MAT", "Message Advice Type")
    ,MPI("MPI", "Movement Priority Information")
    ,NAM("NAM", "Name")
    ,NBI("NBI", "Net Billing Information")
    ,NNS("NNS", "Net/Net Sales")
    ,NEW("NEW", "New Information")
    ,NOM("NOM", "Nominated Handling Party")
    ,OLD("OLD", "Original Information")
    ,OTH("OTH", "Other Charges")
    ,OCI("OCI", "Other Customs, Security and Regulatory Control Information")
    ,OPI("OPI", "Other Participant Information")
    ,OSI("OSI", "Other Service Information")
    ,PAS("PAS", "Passenger Information")
    ,PPD("PPD", "Prepaid Charge Summary")
    ,PRD("PRD", "Planning Request Details")
    ,PID("PID", "Product Information")
    ,RTD("RTD", "Rate Description")
    ,RID("RID", "Rate Information Answer Details")
    ,RIH("RIH", "Rate Information Answer Header")
    ,RIR("RIR", "Rate Information Request Details")
    ,ACK("ACK", "Reason for Acknowledgement")
    ,RCI("RCI", "Recapitulation Amount Information")
    ,RTI("RTI", "Recapitulation Total Information")
    ,REC("REC", "Receptacle Information")
    ,RTG("RTG", "Routing")
    ,SII("SII", "Sales Incentive Information")
    ,SAR("SAR", "Schedule and Availability Information Request Details")
    ,SAA("SAA", "Schedule and Availability Information Answer Details")
    ,SKH("SKH", "Schedule Information Answer Header")
    ,SRI("SRI", "Shipment Reference Information")
    ,SHP("SHP", "Shipper Name and Address")
    ,SCI("SCI", "Special Customs Information")
    ,SPH("SPH", "Special Handling Details")
    ,SSR("SSR", "Special Service Request")
    ,STS("STS", "Status Details")
    ,SLC("SLC", "Status List Criteria")
    ,STI("STI", "Storage Information")
    ,ADR("ADR", "Street Address")
    ,SRA("SRA", "Supplementary Rate Information Answer Details")
    ,SRR("SRR", "Supplementary Rate Information Request Details")
    ,SSI("SSI", "Supplementary Status Information")
    ,SCS("SCS", "Surface Charge Summary")
    ,SDI("SDI", "Surface Delivery Information")
    ,SPI("SPI", "Surface Pickup Information")
    ,SVA("SVA", "Surface Vehicle Arrival Information")
    ,SVL("SVL", "Surface Vehicle Delay Information")
    ,SVD("SVD", "Surface Vehicle Departure Information")
    ,SVN("SVN", "Surface Vehicle Next Information")
    ,TXS("TXS", "Tax Summary")
    ,TID("TID", "Terminal Identification")
    ,OSS("OSS", "The Regulated Agent Accepting the Security Status for a Consignment Issued by Another Regulated Agent")
    ,ISS("ISS", "The Regulated Agent Issuing the Security Status for a Consignment")
    ,TOT("TOT", "Total Amount")
    ,TAR("TAR", "Total AWB Recapitulation Information")
    ,TCC("TCC", "Total Collect Charges")
    ,TRN("TRN", "Transfer/Transit Information")
    ,TRA("TRA", "Transit")
    ,UCI("UCI", "ULD Connection Information")
    ,ULD("ULD", "ULD Description")
    ,UDI("UDI", "ULD Destination Information")
    ,UII("UII", "ULD Inclusion Information")
    ,UMI("UMI", "ULD Movement Information")
    ,UPI("UPI", "Unique Piece Information")
    ,VOD("VOD", "Vehicle Operator Details")
    ,VCD("VCD", "Void/Cancel Details")
    ,WBD("WBD", "Waybill Details")
    ,WBL("WBL", "Waybill Details")
    ,WBH("WBH", "Waybill Header Details")
    ,WBI("WBI", "Waybill Identification/Information");

    public final String cargoImpCode;
    public final String description;
    DataElementGroupIdentifier(String cargoImpCode, String description) {
        this.cargoImpCode = cargoImpCode;
        this.description = description;
    }

    public static DataElementGroupIdentifier fromCargoImpCode(String cargoImpCode) {
        for (DataElementGroupIdentifier code : values()) {
            if (code.cargoImpCode.equals(cargoImpCode))
                return code;
        }
        throw new IllegalArgumentException("No such cargo imp code: '"+cargoImpCode+"'");
    }

}
