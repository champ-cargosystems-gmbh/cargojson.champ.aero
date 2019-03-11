package aero.champ.cargojson.airmail;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Andy on 10/17/2017.
 */
public class AirmailFormat {

    static HashMap<String, String> messageFunctionCodes = new HashMap<String, String>();
    HashMap<String, String> consignorStatusCodes = new HashMap<String, String>();
    HashMap<String, String> screeningMethodCodes = new HashMap<String, String>();
    HashMap<String, String> screeningExemptionCodes = new HashMap<String, String>();
    HashMap<String, String> securityStatusCodes = new HashMap<String, String>();
    HashMap<String, String> securityStatusReasons = new HashMap<String, String>();
    HashMap<String, String> AR_TransportDirection = new HashMap<String, String>();
    HashMap<String, String> AR_BorderAgencyAuthority = new HashMap<String, String>();
    HashMap<String, String> AR_Flag = new HashMap<String, String>();

    HashMap<String, String> unitQualifier = new HashMap<String, String>();
    HashMap<String, String> locationQualifier = new HashMap<String, String>();
    HashMap<String, String> codeListResponsibleAgency = new HashMap<String, String>();
    HashMap<String, String> codeListQualifier = new HashMap<String, String>();
    HashMap<String, String> transportStageQualifier = new HashMap<String, String>();
    HashMap<String, String> transportMode = new HashMap<String, String>();
    HashMap<String, String> equipmentQualifier = new HashMap<String, String>();

    HashMap<String, String> receptacleHandlingClass = new HashMap<String, String>();

    public AirmailFormat(){
        messageFunctionCodes.put("1", "Cancellation");
        messageFunctionCodes.put("4", "Change");
        messageFunctionCodes.put("5", "Replace");
        messageFunctionCodes.put("6", "Confirmation");
        messageFunctionCodes.put("9", "Original");
        messageFunctionCodes.put("47", "Definitive");


        receptacleHandlingClass.put("R", "Registered items included");
        receptacleHandlingClass.put("V", "Screening Exemption");

        consignorStatusCodes.put("AC", "Account Consignor");
        consignorStatusCodes.put("KC", "Known Consignor");
        consignorStatusCodes.put("RA", "Regulated Agent");

        screeningMethodCodes.put("PHS", "Physical inspection and/or hand search");
        screeningMethodCodes.put("VCK", "Visual check");
        screeningMethodCodes.put("XRY", "X-ray equipment");
        screeningMethodCodes.put("EDS", "Explosive detection system");
        screeningMethodCodes.put("RES", "Remote explosive scent tracing explosive detection dogs");
        screeningMethodCodes.put("FRD", "Free running explosive detection dogs");
        screeningMethodCodes.put("VPT", "Vapours trace");
        screeningMethodCodes.put("PRT", "Particles trace");
        screeningMethodCodes.put("MDE", "Metal detection equipment");
        screeningMethodCodes.put("SIM", "Subject to flight simulation");
        screeningMethodCodes.put("AOM", "Subject to any other means");

        screeningExemptionCodes.put("MAIL", "Mail");

        securityStatusCodes.put("NSC", "Not secured yet");
        securityStatusCodes.put("SPX", "Secured for pasenger flight");
        securityStatusCodes.put("SCO", "Secured for all-cargo flight");
        securityStatusCodes.put("SHR", "secured for all passenger, all-cargo and all-mail aircraft in accordance with high risk requirements");

        securityStatusReasons.put("SE", "Screening Exemption");
        securityStatusReasons.put("SM", "Screening Method");
        securityStatusReasons.put("CS", "Consignor Status");

        AR_TransportDirection.put("1", "Export");
        AR_TransportDirection.put("2", "Import");
        AR_TransportDirection.put("3", "Transit");

        AR_BorderAgencyAuthority.put("CUS", "Customs");
        AR_BorderAgencyAuthority.put("AVS", "Aviation security");
        AR_BorderAgencyAuthority.put("BOC", "Border control");
        AR_BorderAgencyAuthority.put("QRT", "Quarantine");

        AR_Flag.put("0", "Advance cargo information required but not provided");
        AR_Flag.put("1", "Required advance cargo information has been provided; no response received");
        AR_Flag.put("2", "Required advance cargo information has been provided; positive response received");
        AR_Flag.put("3", "Advance cargo information has been provided; treat as high risk cargo");
        AR_Flag.put("X", "All mail in consignment exempt from advance cargo information");
        AR_Flag.put("N", "Advance cargo information not required");

        unitQualifier.put("NMB", "Number");
        unitQualifier.put("KGM", "Kilogramme");
        unitQualifier.put("WT", "Weight");
        unitQualifier.put("AAB", "Unit gross weight");
        unitQualifier.put("AAL", "Unit net weight");

        locationQualifier.put("1", "Place of terms of delivery");
        locationQualifier.put("5", "Place of departure");
        locationQualifier.put("7", "Place of arrival");
        locationQualifier.put("9", "Place of departure. Value accepted for backward compatibility");
        locationQualifier.put("13", "Place of arrival. Value accepted for backward compatibility");
        locationQualifier.put("84", "Transport contract place of acceptance");

        codeListQualifier.put("163", "Country sub-entity");
        codeListQualifier.put("102", "Size and type");
        codeListQualifier.put("172", "Carrier code");

        codeListResponsibleAgency.put("3", "IATA");
        codeListResponsibleAgency.put("6", "UN/LOCODE");
        codeListResponsibleAgency.put("11", "IATA");
        codeListResponsibleAgency.put("13", "Lloyds register of shipping");
        codeListResponsibleAgency.put("14", "International chamber of shippoing");
        codeListResponsibleAgency.put("20", "BIC");
        codeListResponsibleAgency.put("139", "UPU");
        codeListResponsibleAgency.put("ZZZ", "Mutually defined");

        transportStageQualifier.put("10", "Pre-carriage transport");
        transportStageQualifier.put("20", "Main-carriage transport");
        transportStageQualifier.put("30", "On-carriage transport");

        transportMode.put("1", "Sea");
        transportMode.put("2", "Rail");
        transportMode.put("3", "Road");
        transportMode.put("4", "Air");

        equipmentQualifier.put("CN", "Container");
        equipmentQualifier.put("UL", "IATA Unit Load Device (air container only");
        equipmentQualifier.put("BC", "Aircraft belly cart");

    }

    public String getMessageFunctionCode(int key){
        return messageFunctionCodes.get(String.valueOf(key));
    }
    public String getConsignorStatusCode(String key){
        return consignorStatusCodes.get(key);
    }
    public String getScreeningMethodCode(String key){
        return screeningMethodCodes.get(key);
    }
    public String getScreeningExemptionCode(String key){
        return screeningExemptionCodes.get(key);
    }
    public String getSecurityStatusCodes(String key){
        return securityStatusCodes.get(key);
    }
    public String getSecurityStatusReason(String key){
        return securityStatusReasons.get(key);
    }
    public String getReceptacleHandlingClass(String key){
        return receptacleHandlingClass.get(key);
    }
    public String getAR_TransportDirection(String key) {
        return AR_TransportDirection.get(key);
    }
    public String getAR_BorderAgencyAuthority(String key){
        return AR_BorderAgencyAuthority.get(key);
    }
    public String getAR_Flag(String key){
        return AR_Flag.get(key);
    }
    public String getUnitQualifier(String key){
        return unitQualifier.get(key);
    }
    public String getLocationQualifier(String key){
        return locationQualifier.get(key);
    }
    public String getCodeListResponsibleAgency(String key){
        return codeListResponsibleAgency.get(key);
    }
    public String getTransportStageQualifier(String key){
        return transportStageQualifier.get(key);
    }
    public String getTransportMode(String key){
        return transportMode.get(key);
    }


    private static String transformPattern(String format) {
        String transformedPattern = format.replace("an","[A-Z0-9]");
        return transformedPattern;
    }


    public static void main(String[] args){
      //  AirmailFormat airmailFormat = new AirmailFormat();

        String input = "TDT+40";
        String format = "TDT\\+(10|20|30)";
        Pattern pattern = Pattern.compile(format);
        Matcher m = pattern.matcher(input);

        System.out.println("Format := " + pattern.toString());
        if(m.matches()){
            System.out.println(input + "  :- match");
        }else{
            System.out.println(input + "  :- Not match");
        }

        /*
        String in_format = "an{1,12}";
        String out_format = "";
        if(in_format.contains("an{")){
            out_format = in_format.replace("an","[A-Z0-9]");
        }else if(in_format.startsWith("a{")){
            out_format = in_format.replace("a","[A-Z]");
        }
        System.out.println("IN  : " + in_format);
        System.out.println("OUT : " + out_format);
        */

/*

        String format = out;

        String input = "6";
        Pattern pattern = Pattern.compile(format);
        Matcher m = pattern.matcher(input);

        System.out.println("Format := " + pattern.toString());
        if(m.matches()){
            System.out.println(input + "  :- match");
        }else{
            System.out.println(input + "  :- Not match");
        }
        */
    }

}
