package br.edu.ifspsaocarlos.sdm.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

public class CalculadoraActivity extends Activity {
    private double operando;
    private double resultado;
    private int operacao;
    private EditText etLcd;
    private static final int NENHUMA = -1, SOMA = 0, SUBTRACAO = 1, MULTIPLICACAO = 2, DIVISAO = 4, RAIZ = 5, POTENCIA = 6, FATORIAL = 7;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        operando = 0;
        operacao = NENHUMA;
        resultado = 0;
        etLcd = (EditText) findViewById(R.id.lcd);
    }

    public void onClickPonto(View v) {
        if (!etLcd.getText().toString().contains(".")) {
            etLcd.append(".");
        }
    }

    public void onClickSoma(View v) {
        configuraOperacao(SOMA);
    }

    public void onClickSub(View v) {
        configuraOperacao(SUBTRACAO);
    }

    public void onClickMult(View v) {
        configuraOperacao(MULTIPLICACAO);
    }

    public void onClickDiv(View v) {
        configuraOperacao(DIVISAO);
    }

    public void onClickRaizQuadrada(View v) {
        configuraOperacao(RAIZ);
    }

    public void onClickPotencia(View v) {
        configuraOperacao(POTENCIA);
    }

    public void onClickFatorial(View v) {
        configuraOperacao(FATORIAL);
    }

    public void onClickLimpa(View v) {
        etLcd.setText("");
    }

    private void configuraOperacao(int operacao) {
        if (etLcd.getText().toString().length() != 0) {
            operando = Double.parseDouble(etLcd.getText().toString());
            this.operacao = operacao;
            etLcd.setText("");
        }
    }


    public void onClickRes(View v) {
        if (etLcd.getText().toString().length() != 0 && operacao != NENHUMA) {
            switch (operacao) {
                case SOMA:
                    resultado = operando + Double.parseDouble(etLcd.getText().toString());
                    break;
                case SUBTRACAO:
                    resultado = operando - Double.parseDouble(etLcd.getText().toString());
                    break;
                case MULTIPLICACAO:
                    resultado = operando * Double.parseDouble(etLcd.getText().toString());
                    break;
                case DIVISAO:
                    resultado = operando / Double.parseDouble(etLcd.getText().toString());
                    break;
                case POTENCIA:
                    resultado = Math.pow(operando, Double.parseDouble(etLcd.getText().toString()));
                    break;
            }
            etLcd.setText(Double.toString(resultado));
            operando = resultado;
            operacao = NENHUMA;
        } else {
            switch (operacao) {
                case RAIZ:
                    resultado = Math.sqrt(operando);
                    break;
                case FATORIAL: {
                    BigInteger result = factorial(BigInteger.valueOf((long) operando));
                    resultado = result.doubleValue();
                }
                break;
            }
            etLcd.setText(Double.toString(resultado));
            operando = resultado;
            operacao = NENHUMA;
        }
    }

    public BigInteger factorial(BigInteger x) {
        if (x.compareTo(new BigInteger("1")) == 0 || x.compareTo(new BigInteger("0")) == 0)
            return new BigInteger("1");
        else return x.multiply(factorial(x.subtract(new BigInteger("1"))));
    }

    public void onClick0(View v) {
        eNovaOperacao();
        etLcd.append("0");
    }

    public void onClick1(View v) {
        eNovaOperacao();
        etLcd.append("1");
    }

    public void onClick2(View v) {
        eNovaOperacao();
        etLcd.append("2");
    }

    public void onClick3(View v) {
        eNovaOperacao();
        etLcd.append("3");
    }

    public void onClick4(View v) {
        eNovaOperacao();
        etLcd.append("4");
    }

    public void onClick5(View v) {
        eNovaOperacao();
        etLcd.append("5");
    }

    public void onClick6(View v) {
        eNovaOperacao();
        etLcd.append("6");
    }

    public void onClick7(View v) {
        eNovaOperacao();
        etLcd.append("7");
    }

    public void onClick8(View v) {
        eNovaOperacao();
        etLcd.append("8");
    }

    public void onClick9(View v) {
        eNovaOperacao();
        etLcd.append("9");
    }

    public void eNovaOperacao() {
        if (resultado != 0) {
            etLcd.setText("");
            resultado = 0;
        }
    }
}
