package com.example.conversaotemperaturas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ViewHolder mViewHolder = new ViewHolder();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_text);
        this.mViewHolder.textFahrenheit = findViewById(R.id.text_fahrenheit);
        this.mViewHolder.textKelvin = findViewById(R.id.text_kelvin);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    //@Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.button_calculate)
        {
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value))
            {
                Toast.makeText(this,getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            }else
            {
                Double celsius = Double.valueOf(value);
                //F = C * 1.8 + 32
                this.mViewHolder.textFahrenheit.setText(String.format("%.2f",celsius*1.8 + 32));
                this.mViewHolder.textKelvin.setText(String.format("%.2f",(celsius+273)));
            }
        }
    }

    private void clearValues()
    {
        this.mViewHolder.textFahrenheit.setText("");
        this.mViewHolder.textKelvin.setText("");
    }

    private static class ViewHolder
    {
        EditText editValue;
        TextView textFahrenheit;
        TextView textKelvin;
        Button buttonCalculate;
    }
}