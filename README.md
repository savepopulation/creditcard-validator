# creditcardvalidator
A simple credit card validation and format library for most popular credit cards in the world.

How to use?

1- Setup your validator:
```
CreditCardValidator creditCardValidator = new CardValidatorBuilder()
                .addVisaCardValidator()
                .addMasterCardValidador()
                .addAmexCardValidator()
                .addDiscoverCardValidator()
                .addDinClubCardValidator()
                .addJcbCardValidator()
                .setTypeChangeListener(this)
                .setValidationChangeListener(this)
                .setFormatable(true)
                .build();
```

2- Add it to your EditText:
```
final EditText editTextCardNumber = (EditText) findViewById(R.id.edittext_card_number);
editTextCardNumber.addTextChangedListener(creditCardValidator);
```
