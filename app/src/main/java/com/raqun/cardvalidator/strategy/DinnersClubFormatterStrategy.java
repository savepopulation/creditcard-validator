package com.raqun.cardvalidator.strategy;

import android.text.Editable;
import android.text.TextUtils;

import com.raqun.cardvalidator.CreditCardConstants;


/**
 * Created by tyln on 28.04.16.
 */
public class DinnersClubFormatterStrategy implements FormatStrategy {
    @Override
    public void formatCardNumber(Editable editable) {
        if (editable.length() == 5 || editable.length() == 12) {
            final char c = editable.charAt(editable.length() - 1);
            if (CreditCardConstants.DEFAULT_SEPERATOR == c) {
                editable.delete(editable.length() - 1, editable.length());
            } else if (Character.isDigit(c) && TextUtils.split(editable.toString(),
                    String.valueOf(CreditCardConstants.DEFAULT_SEPERATOR)).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(CreditCardConstants.DEFAULT_SEPERATOR));
            }
        }
    }
}
