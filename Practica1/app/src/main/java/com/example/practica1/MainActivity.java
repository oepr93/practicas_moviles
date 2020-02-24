package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClear;
    TextView cadena_tv, Resultado_tv;

    Button btn_uno, btn_dos, btn_tres, btn_cuatro, btn_cinco, btn_seis, btn_siete, btn_ocho, btn_nueve, btn_cero;
    String cadena = "", resultado = "", cadena_mostrar = "";
    char anterior = 'z';
    Double result = 0.0;
    Button btn_multiplicar, btn_menos, btn_mas, btn_dividir, btn_punto, btnBack, btn_igual, btnPercentage, btn_pow, btn_par_izquierdo, btn_par_derecho;
    Button btn_raiz, btn_pot_cuadrada, btn_mod, btn_div_entera_, btn_sen, btn_cos, btn_tan, btn_senh, btn_cosh, btn_tanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int orientation = this.getResources().getConfiguration().orientation;

        final Convertir convert = new Convertir();
        final Calculadora calc = new Calculadora();

        btnClear = findViewById(R.id.btn_delete);
        cadena_tv = findViewById(R.id.tv_process);
        Resultado_tv = findViewById(R.id.tv_result);

        cadena_tv.setText("");
        Resultado_tv.setText("");

        btn_uno = findViewById(R.id.btn_one);
        btn_dos = findViewById(R.id.btn_two);
        btn_tres = findViewById(R.id.btn_three);
        btn_cuatro = findViewById(R.id.btn_four);
        btn_cinco = findViewById(R.id.btn_five);
        btn_seis = findViewById(R.id.btn_six);
        btn_siete = findViewById(R.id.btn_seven);
        btn_ocho =findViewById(R.id.btn_eight);
        btn_nueve = findViewById(R.id.btn_nine);
        btn_cero = findViewById(R.id.btn_zero);


        btn_multiplicar = findViewById(R.id.btn_multiply);
        btn_menos = findViewById(R.id.btn_minus);
        btn_mas = findViewById(R.id.btn_plus);
        btn_dividir = findViewById(R.id.btn_divide);
        btn_pow = findViewById(R.id.btn_pow);
        btn_par_izquierdo = findViewById(R.id.btn_pizquierdo);
        btn_par_derecho = findViewById(R.id.btn_pderecho);

        btn_raiz = findViewById(R.id.btn_raiz);
        btn_pot_cuadrada = findViewById(R.id.btn_potencia);
        btn_mod = findViewById(R.id.btn_mod);
        btn_div_entera_ = findViewById(R.id.btn_div_entera);
        btn_sen = findViewById(R.id.btn_sen);
        btn_cos = findViewById(R.id.btn_cos);
        btn_tan = findViewById(R.id.btn_tan);
        btn_senh = findViewById(R.id.btn_senh);
        btn_cosh = findViewById(R.id.btn_cosh);
        btn_tanh = findViewById(R.id.btn_tanh);

        btn_punto = findViewById(R.id.btn_dot);

        btn_igual = findViewById(R.id.btn_igual);

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cadena = "";
                cadena_mostrar = "";
                cadena_tv.setText("");
                Resultado_tv.setText("");
            }
        });

        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("*");
            }
        });
        btn_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("+");
            }
        });
        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("/");
            }
        });
        btn_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("-");
            }
        });
        btn_pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("^");
            }
        });
        btn_punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena(".");
            }
        });
        btn_par_izquierdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("(");
            }
        });
        btn_par_derecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena(")");
            }
        });
        btn_uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("1");
            }
        });
        btn_dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("2");
            }
        });
        btn_tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("3");
            }
        });
        btn_cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("4");
            }
        });
        btn_cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("5");
            }
        });
        btn_seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("6");
            }
        });
        btn_siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("7");
            }
        });
        btn_ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("8");
            }
        });
        btn_nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("9");
            }
        });
        btn_cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
                add_cadena("0");
            }
        });
        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(cadena.length()>0){
                   resultado = convert.infixToPostfix(cadena);
               }
                if(resultado != "Syntax error"){
                    String[] strArr = resultado.split(" ");
                    result = calc.calculator(strArr);
                }
                Resultado_tv.setText(result.toString());

            }
        });
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btn_raiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(cadena != "") {
                        if(Character.isDigit(anterior) || anterior == ')') {
                            cadena += "^0.5";
                            anterior = '5';
                            cadena_mostrar += "^0.5";
                        }
                    }
                    cadena_tv.setText(cadena);
                }
            });
            btn_pot_cuadrada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(cadena != "") {
                        if(Character.isDigit(anterior) || anterior == ')') {
                            cadena += "^2";
                            anterior = '2';
                            cadena_mostrar += "^2";
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });
            btn_mod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    add_cadena("%");
                }
            });
            btn_div_entera_.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    add_cadena("\\");
                }
            });
            btn_sen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)){
                            cadena += "&(";
                            cadena_mostrar += "sen(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });
            btn_cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)) {
                            cadena += "#(";
                            cadena_mostrar += "cos(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });
            btn_tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)) {
                            cadena += "$(";
                            cadena_mostrar += "tan(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });

            btn_senh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)) {
                            cadena += "?(";
                            cadena_mostrar += "senh(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });

            btn_cosh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)) {
                            cadena += "!(";
                            cadena_mostrar += "cosh(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });
            btn_tanh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearScreen();
                    if(anterior == 'z' || anterior != ')'){
                        if(!Character.isDigit(anterior)) {
                            cadena += "@(";
                            cadena_mostrar += "tanh(";
                            anterior = '(';
                        }
                    }
                    cadena_tv.setText(cadena_mostrar);
                }
            });

        }

    }
    public void clearScreen(){
        cadena_tv.setText("");
        Resultado_tv.setText("");
    }

    public void add_cadena(String num){
        char c = num.charAt(0);
        if(Character.isDigit(c)) {
            if (anterior != ')'){
                cadena += num;
                cadena_mostrar += num;
            }
        }
        else{
            if(anterior != 'z'){
                if(Character.isDigit(anterior)){
                    cadena += num;
                    cadena_mostrar += num;
                }
                else{
                    if(num == "(" || num == ")"){
                        cadena += num;
                        cadena_mostrar += num;
                    }
                    if(anterior == ')' && num != "."){
                        cadena += num;
                        cadena_mostrar += num;
                    }
                }
            }
            else{
                if(c == '('){
                    cadena += num;
                    cadena_mostrar += num;
                }

            }
        }
        anterior = num.charAt(0);
        cadena_tv.setText(cadena_mostrar);
    }
}
