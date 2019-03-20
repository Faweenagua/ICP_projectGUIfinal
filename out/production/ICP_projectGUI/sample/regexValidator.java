package sample;

import java.util.regex.*;

/**
 * This class holds compares the user's input to make sure it is in the required format
 * @author Eugenia Mawuenya AKPO
 * @author Michael Dankwah AGYEMAN-PREMPEH
 * @author Issifu ALHASSAN
 * @author Francis AWEEENAGUA
 * @version 1.0.0
 */

public class regexValidator {
    protected Pattern thePattern1;
    protected Pattern thePattern2;
    protected Pattern thePattern3;

    protected Matcher theMatcher1;
    protected Matcher theMatcher2;
    protected Matcher theMatcher3;

    protected static final String OBYEAR_REGEX = "^\\d{4}$";
    protected static final String OBNAME_REGEX = "^[a-zA-Z]{1,20}$";
    protected static final String OBCOUNTRY_REGEX = "^[a-zA-Z]{4,20}$";

    public regexValidator() {
        thePattern1 = Pattern.compile(OBYEAR_REGEX);
        thePattern2 = Pattern.compile(OBNAME_REGEX);
        thePattern3 = Pattern.compile(OBCOUNTRY_REGEX);
    }

    public boolean validateYear(final String obyear) {
        theMatcher1 = thePattern1.matcher(obyear);
        return theMatcher1.matches();
    }

    public boolean validateName(final String obname) {
        theMatcher2 = thePattern2.matcher(obname);
        return theMatcher2.matches();
    }
    public boolean validateCountry(final String obcountry) {
        theMatcher3 = thePattern3.matcher(obcountry);
        return theMatcher3.matches();
    }


    public static void main(String[] args) {


        regexValidator validate =  new regexValidator();

        System.out.println(validate.validateYear("1992"));
        System.out.println(validate.validateName("me"));
        System.out.println(validate.validateCountry("Madagascar"));


    }

}