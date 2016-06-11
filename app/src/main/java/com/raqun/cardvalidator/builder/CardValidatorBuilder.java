
package com.raqun.cardvalidator.builder;

import com.raqun.cardvalidator.CreditCardConstants;
import com.raqun.cardvalidator.CreditCardValidator;
import com.raqun.cardvalidator.model.Validator;
import com.raqun.cardvalidator.strategy.AmexFormatterStrategy;
import com.raqun.cardvalidator.strategy.DefaultFormatterStrategy;
import com.raqun.cardvalidator.strategy.DinnersClubFormatterStrategy;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by tyln on 28.04.16.
 */
public class CardValidatorBuilder {
   private final List<Validator>                                  mValidators = new ArrayList<>();
   private CreditCardValidator.CreditCardTypeChangeListener       mTypeChangeListener;
   private CreditCardValidator.CreditCardValidationChangeListener mValidationChangeListener;
   private boolean                                                isFormatable;
   private int                                                    mValidatePoint;

   public CardValidatorBuilder() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_UNKNOWN,
                                         CreditCardConstants.CARD_REGEX_DEFAULT,
                                         "",
                                         new DefaultFormatterStrategy(),
                                         CreditCardConstants.DEFAULT_MAX_LEN));
      this.mValidatePoint = 4;
   }

   public CardValidatorBuilder addVisaCardValidator() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_VISA,
                                         CreditCardConstants.CARD_REGEX_VISA,
                                         CreditCardConstants.CARD_TYPE_REGEX_VISA,
                                         new DefaultFormatterStrategy(),
                                         13));
      return this;
   }

   public CardValidatorBuilder addMasterCardValidador() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_MASTER,
                                         CreditCardConstants.CARD_REGEX_MASTER,
                                         CreditCardConstants.CARD_TYPE_REGEX_MASTER,
                                         new DefaultFormatterStrategy(),
                                         16));
      return this;
   }

   public CardValidatorBuilder addAmexCardValidator() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_AMEX,
                                         CreditCardConstants.CARD_REGEX_AMEX,
                                         CreditCardConstants.CARD_TYPE_REGEX_AMEX,
                                         new AmexFormatterStrategy(),
                                         15));
      return this;
   }

   public CardValidatorBuilder addJcbCardValidator() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_JCB,
                                         CreditCardConstants.CARD_REGEX_JCB,
                                         CreditCardConstants.CARD_TYPE_REGEX_JCB,
                                         new DefaultFormatterStrategy(),
                                         16));

      this.mValidators.add(new Validator(CreditCardConstants.CARD_JCB_15_DIGITS,
                                         CreditCardConstants.CARD_REGEX_JCB,
                                         CreditCardConstants.CARD_TYPE_REGEX_JCB_15,
                                         new AmexFormatterStrategy(),
                                         15));
      this.mValidatePoint = 5;
      return this;
   }

   public CardValidatorBuilder addDinClubCardValidator() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_DIN_CLUB,
                                         CreditCardConstants.CARD_REGEX_DIN_CLUB,
                                         CreditCardConstants.CARD_TYPE_REGEX_DIN_CLUB,
                                         new DinnersClubFormatterStrategy(),
                                         14));
      return this;
   }

   public CardValidatorBuilder addDiscoverCardValidator() {
      this.mValidators.add(new Validator(CreditCardConstants.CARD_DISCOVER,
                                         CreditCardConstants.CARD_REGEX_DISCOVER,
                                         CreditCardConstants.CARD_TYPE_REGEX_DISCOVER,
                                         new DefaultFormatterStrategy(),
                                         16));
      return this;
   }

   public CardValidatorBuilder setTypeChangeListener(CreditCardValidator.CreditCardTypeChangeListener listener) {
      this.mTypeChangeListener = listener;
      return this;
   }

   public CardValidatorBuilder setValidationChangeListener(CreditCardValidator.CreditCardValidationChangeListener listener) {
      this.mValidationChangeListener = listener;
      return this;
   }

   public CardValidatorBuilder setFormatable(boolean isFormatable) {
      this.isFormatable = isFormatable;
      return this;
   }

   public CreditCardValidator build() {
      return new CreditCardValidator(mValidators, mValidationChangeListener, mTypeChangeListener, isFormatable, mValidatePoint);
   }
}
