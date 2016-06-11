
package com.raqun.cardvalidator.utils;

import android.text.TextUtils;

import com.raqun.cardvalidator.CreditCardConstants;


/**
 * Created by tyln on 28.04.16.
 */

public final class CreditCardUtils {

    public static boolean luhm(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public static String cleanCardNumber(String cardNumber) {
        if (!TextUtils.isEmpty(cardNumber)) {
            return cardNumber.replaceAll(String.valueOf(CreditCardConstants.DEFAULT_SEPERATOR), "").trim();
        }
        return cardNumber;
    }

    public static String getDefaultCardName(int type) {
        switch (type) {
            case CreditCardConstants.CARD_VISA:
                return "VISA";

            case CreditCardConstants.CARD_MASTER:
                return "MASTER CARD";

            case CreditCardConstants.CARD_AMEX:
                return "American Express";

            case CreditCardConstants.CARD_DIN_CLUB:
                return "Diners Club";

            case CreditCardConstants.CARD_DISCOVER:
                return "Discover";

            case CreditCardConstants.CARD_JCB:
            case CreditCardConstants.CARD_JCB_15_DIGITS:
                return "JCB";

            default:
                return "Unknown Card Type";
        }
    }
}
