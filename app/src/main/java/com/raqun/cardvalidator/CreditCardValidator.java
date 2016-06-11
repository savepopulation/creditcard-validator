
package com.raqun.cardvalidator;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;

import com.raqun.cardvalidator.model.Validator;
import com.raqun.cardvalidator.strategy.DefaultFormatterStrategy;
import com.raqun.cardvalidator.strategy.FormatStrategy;
import com.raqun.cardvalidator.utils.CreditCardUtils;

import java.util.List;


/**
 * Created by tyln on 28.04.16.
 */

public class CreditCardValidator implements TextWatcher {
   private List<Validator> mValidators;
   private final InputFilter[]                mFilterArray = new InputFilter[1];

   private CreditCardValidationChangeListener mValidationChangeListener;
   private CreditCardTypeChangeListener       mTypeChangeListener;

   private Validator                          mDefaultValidator;

   private boolean                            isPatternValid;
   private boolean                            isCardValid;
   private boolean                            isFormatable;

   private int                                mValidatePoint;

   public CreditCardValidator(List<Validator> validators,
                              CreditCardValidationChangeListener validationChangeListener,
                              CreditCardTypeChangeListener typeChangeListener,
                              boolean isFormatable,
                              int validatePotint) {
      this.mValidators = validators;
      this.mValidationChangeListener = validationChangeListener;
      this.mTypeChangeListener = typeChangeListener;
      this.isFormatable = isFormatable;
      this.isCardValid = false;
      this.isPatternValid = false;
      this.mValidatePoint = validatePotint;
   }

   @Override
   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

   }

   @Override
   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

   }

   @Override
   public void afterTextChanged(Editable editable) {
      final String s = CreditCardUtils.cleanCardNumber(editable.toString());
      if (s.length() >= 0) {
         if (isValidatorChanged(s)) {
            mFilterArray[0] = new InputFilter.LengthFilter(getMaxLenForFormatter());
            editable.setFilters(mFilterArray);
            if (this.mTypeChangeListener != null) {
               this.mTypeChangeListener.onCreditCardTypeChanged(mDefaultValidator.getType());
            }
         }
      }

      isPatternValid = (s.length() >= mDefaultValidator.getLen()) && s.matches(mDefaultValidator.getFullPattern());

      final boolean tempValid = validateCreditCard(s, isPatternValid);
      if (isCardValid != tempValid) {
         isCardValid = tempValid;
         if (mValidationChangeListener != null) {
            mValidationChangeListener.onValidationChanged(isCardValid);
         }
      }

      if (isFormatable) {
         mDefaultValidator.getFormatStrategy().formatCardNumber(editable);
      }
   }

   private boolean isValidatorChanged(String s) {
      boolean isChanged = false;

      if (mDefaultValidator == null) {
         mDefaultValidator = mValidators.get(0);
         isChanged = true;
      }

      for (Validator v : mValidators) {
         if (s.matches(v.getTypePattern()) && this.mDefaultValidator.getType() != v.getType()) {
            this.mDefaultValidator = v;
            isChanged = true;
         }
      }

      return isChanged;
   }

   private int getMaxLenForFormatter() {
      if (!isFormatable) {
         if (mDefaultValidator.getType() == CreditCardConstants.CARD_VISA) {
            return mDefaultValidator.getLen() + 3;
         }
         else {
            return mDefaultValidator.getLen();
         }
      }
      else {
         final FormatStrategy formatStrategy = mDefaultValidator.getFormatStrategy();
         if (formatStrategy instanceof DefaultFormatterStrategy) {
            if (mDefaultValidator.getType() == CreditCardConstants.CARD_VISA) {
               return mDefaultValidator.getLen() + 6;
            }
            else {
               return mDefaultValidator.getLen() + 3;
            }
         }
         else {
            return mDefaultValidator.getLen() + 2;
         }
      }
   }

   public static boolean validateCreditCard(String carNumber, boolean isPatternValid) {
      return isPatternValid && CreditCardUtils.luhm(carNumber);
   }

   public interface CreditCardValidationChangeListener {
      void onValidationChanged(boolean isValid);
   }

   public interface CreditCardTypeChangeListener {
      void onCreditCardTypeChanged(int type);
   }
}