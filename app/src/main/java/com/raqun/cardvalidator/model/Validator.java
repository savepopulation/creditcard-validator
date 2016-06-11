
package com.raqun.cardvalidator.model;


import com.raqun.cardvalidator.strategy.FormatStrategy;

/**
 * Created by tyln on 28.04.16.
 */
public class Validator {
   private int            type;
   private String         fullPattern;
   private String         typePattern;
   private FormatStrategy formatStrategy;
   private int            len;

   public Validator(int type, String fullPattern, String typePattern, FormatStrategy formatStrategy, int len) {
        this.type = type;
        this.fullPattern = fullPattern;
        this.typePattern = typePattern;
        this.formatStrategy = formatStrategy;
        this.len = len;
    }

   public int getType() {
      return type;
   }

   public void setType(int type) {
      this.type = type;
   }

   public String getFullPattern() {
      return fullPattern;
   }

   public void setFullPattern(String fullPattern) {
      this.fullPattern = fullPattern;
   }

   public String getTypePattern() {
      return typePattern;
   }

   public void setTypePattern(String typePattern) {
      this.typePattern = typePattern;
   }

   public FormatStrategy getFormatStrategy() {
      return formatStrategy;
   }

   public void setFormatStrategy(FormatStrategy formatStrategy) {
      this.formatStrategy = formatStrategy;
   }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}