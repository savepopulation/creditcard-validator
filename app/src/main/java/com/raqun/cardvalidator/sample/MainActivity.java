package com.raqun.cardvalidator.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raqun.cardvalidator.CreditCardValidator;
import com.raqun.cardvalidator.R;
import com.raqun.cardvalidator.builder.CardValidatorBuilder;
import com.raqun.cardvalidator.utils.CreditCardUtils;

public class MainActivity extends AppCompatActivity implements CreditCardValidator.CreditCardValidationChangeListener, CreditCardValidator.CreditCardTypeChangeListener {
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        final EditText editTextCardNumber = (EditText) findViewById(R.id.edittext_card_number);
        editTextCardNumber.addTextChangedListener(creditCardValidator);

        mTextViewResult = (TextView) findViewById(R.id.textview_result);
        mTextViewResult.setText("Valid Card:" + " " + false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onValidationChanged(boolean isValid) {
        mTextViewResult.setText("Valid Card:" + " " + isValid);
    }

    @Override
    public void onCreditCardTypeChanged(int type) {
        Toast.makeText(getApplicationContext(), CreditCardUtils.getDefaultCardName(type), Toast.LENGTH_SHORT).show();
    }
}
