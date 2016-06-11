package com.raqun.cardvalidator;

/**
 * Created by tyln on 28.04.16.
 */

public final class CreditCardConstants {
   public static final char   DEFAULT_SEPERATOR        = ' ';

   // CARD TYPES
   public static final int    CARD_UNKNOWN             = 0;
   public static final int    CARD_VISA                = 1;
   public static final int    CARD_MASTER              = 2;
   public static final int    CARD_AMEX                = 3;
   public static final int    CARD_DIN_CLUB            = 4;
   public static final int    CARD_DISCOVER            = 5;
   public static final int    CARD_JCB                 = 6;
   public static final int    CARD_JCB_15_DIGITS       = 7;

   // CARD LENGHTS
   public static final int    MIN_CARD_LEN             = 12;
   public static final int    MAX_CARD_LEN             = 19;
   public static final int    DEFAULT_MAX_LEN          = 16;

   // REGEX FOR VALIDATION
   public static final String CARD_REGEX_DEFAULT       = "^[0-9]{16}$";
   public static final String CARD_REGEX_VISA          = "^4[0-9]{12}(?:[0-9]{3})?$";
   public static final String CARD_REGEX_MASTER        = "^5[1-5][0-9]{14}$";
   public static final String CARD_REGEX_AMEX          = "^3[47][0-9]{13}$";
   public static final String CARD_REGEX_DIN_CLUB      = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";
   public static final String CARD_REGEX_DISCOVER      = "^6(?:011|5[0-9]{2})[0-9]{12}$";
   public static final String CARD_REGEX_JCB           = "^(?:2131|1800|35\\d{3})\\d{11}$";

   // REGEX FOR TYPE
   public static final String CARD_TYPE_REGEX_VISA     = "^[4]+.*";
   public static final String CARD_TYPE_REGEX_MASTER   = "^[5]+.*";
   public static final String CARD_TYPE_REGEX_AMEX     = "^3[47]+.*";
   public static final String CARD_TYPE_REGEX_DIN_CLUB = "^3(?:0[0-5]|[68][0-9])+.*";
   public static final String CARD_TYPE_REGEX_DISCOVER = "^6(?:011|5[0-9]{2})+.*";
   public static final String CARD_TYPE_REGEX_JCB      = "^35\\d{3}+.*";
   public static final String CARD_TYPE_REGEX_JCB_15   = "^(?:2131|1800)+.*";

   // JCB START VARIANTS
   public static final String JCB_STARTS_VAR1          = "35";
   public static final String JCB_STARTS_VAR2          = "2131";
   public static final String JCB_STARTS_VAR3          = "1800";

}
