package com.example.daniel.juegoprovincias;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Hashtable;

public class MainActivity2 extends AppCompatActivity {


    /*  Hashtable para hacer un array de strings clave valor y debajo los metodos para introducir
        datos y manejar los datos
        Hashtable<String, String> capitales = new Hashtable<String, String>();
        capitales.put("España","Madrid");
        capitales.put("Argentina","Buenos Aires");
        remove(clave) – Eliminar un par (clave, valor) identificado por su clave
        get(clave) – Obtener el valor asociado a una clave
        containsKey(clave) – Determinar si una clave existe en la hashtable
        contains(valor), containsValue(valor) – Estos dos métodos son equivalentes, y devuelven true
        si el argumento existe en la tabla como un valor asociado a una clave.*/

    private TextView tv, nIntentos;
    private Spinner spinner;
    private Button bt;
    Hashtable<String, String> capitales;
    private String pais;
    private int contador;
    private int perder;

    /**
     * Llama a la actividad cuando ganas el juego
     */
    private void llamarActividad(){
        Intent i = new Intent(this, MainActivity3.class);
        startActivity(i);
    }

    /**
     * Llama a la actividad principal cuando pierdes para empezar el juego de nuevo
     */
    private void llamarActividadPerder(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("perder", perder);
        startActivity(i);
    }

    /**
     * Metodo que crea un Hashtable para asignar los valores de las capitales a los paises
     */
    public void crearCapitales(){
        capitales = new Hashtable<String, String>();
        capitales.put("Afganistán","Kabul");
        capitales.put("Albania","Tirana");
        capitales.put("Alemania","Berlín");
        capitales.put("Andorra","Andorra la Vieja");
        capitales.put("Angola","Luanda");
        capitales.put("Antigua y Barbuda","Saint John’s");
        capitales.put("Arabia Saudita","Riad");
        capitales.put("Argelia","Argel");
        capitales.put("Argentina","Buenos Aires");
        capitales.put("Armenia","Ereván");
        capitales.put("Australia","Camberra");
        capitales.put("Austria","Viena");
        capitales.put("Azerbaiyán","Bakú");
        capitales.put("Bahamas","Nasáu");
        capitales.put("Bangladés","Daca");
        capitales.put("Barbados","Bridgetown");
        capitales.put("Baréin","Manama");
        capitales.put("Bélgica","Bruselas");
        capitales.put("Belice","Belmopán");
        capitales.put("Benín","Porto Novo y Cotonú");
        capitales.put("Bielorrusia","Minsk");
        capitales.put("Birmania","Naipyidó");
        capitales.put("Bolivia","Sucre");
        capitales.put("Bosnia y Herzegoniva","Sarajevo");
        capitales.put("Botsuana","Gaborone");
        capitales.put("Brasil","Brasilia");
        capitales.put("Brunéi","Bandar Seri Begawan");
        capitales.put("Bulgaria","Sofia");
        capitales.put("Burkina Faso","Uagadugú");
        capitales.put("Burundi","Buyumbura");
        capitales.put("Bután","Timbu");
        capitales.put("Cabo Verde","Praia");
        capitales.put("Camboya","Nom Pen");
        capitales.put("Camerún","Yaundé");
        capitales.put("Cánada","Ottawa");
        capitales.put("Catar","Doha");
        capitales.put("Chad","Yamena");
        capitales.put("Chile","Santiago de Chile");
        capitales.put("China","Pekín");
        capitales.put("Chipre","Nicosia");
        capitales.put("Ciudad del Vaticano","Cuidad del Vatincano");
        capitales.put("Colombia","Bogotá");
        capitales.put("Comoras","Moroni");
        capitales.put("Corea del Norte","Pionyang");
        capitales.put("Corea del Sur","Seúl");
        capitales.put("Costa de Marfil","Yamusukro");
        capitales.put("Costa Rica","San José");
        capitales.put("Croacia","Zagreb");
        capitales.put("Cuba","La Habana");
        capitales.put("Dinamarca","Copenhague");
        capitales.put("Dominica","Roseau");
        capitales.put("Ecuador","Quito");
        capitales.put("Egipto","El Cairo");
        capitales.put("El Salvador","San Salvador");
        capitales.put("Emiratos Árabes Unidos","Abu Dabi");
        capitales.put("Eritrea","Asmara");
        capitales.put("Eslovaquia","Bratislava");
        capitales.put("Eslovenia","Liubliana");
        capitales.put("España","Madrid");
        capitales.put("Estados Unidos","Washington D.C.");
        capitales.put("Estonia","Tallin");
        capitales.put("Etiopía","Adís Adeba");
        capitales.put("Filipinas","Manila");
        capitales.put("Finlandia","Helsinki");
        capitales.put("Fiyi","Suva");
        capitales.put("Francia","París");
        capitales.put("Gabón","Libreville");
        capitales.put("Gambia","Banjul");
        capitales.put("Georgia","Tiflis");
        capitales.put("Ghana","Acra");
        capitales.put("Granada","Saint George");
        capitales.put("Grecia","Atenas");
        capitales.put("Guatemala","Cuidad de Guatemala");
        capitales.put("Guyana","Georgetown");
        capitales.put("Guinea","Conakri");
        capitales.put("Guinea-Bisáu","Bisáu");
        capitales.put("Guinea Ecuatorial","Malabo");
        capitales.put("Haití","Puerto Príncipe");
        capitales.put("Honduras","Tegucigalpa");
        capitales.put("Hungría","Budapest");
        capitales.put("India","Nueva Delhi");
        capitales.put("Indonesia","Yakarta");
        capitales.put("Irak","Bagdad");
        capitales.put("Irán","Teherán");
        capitales.put("Irlanda","Dublín");
        capitales.put("Islandia","Reikiavik");
        capitales.put("Islas Marshall","Majuro");
        capitales.put("Islas Salomón","Honiara");
        capitales.put("Israel","Jerusalén");
        capitales.put("Italia","Roma");
        capitales.put("Jamaica","Kingston");
        capitales.put("Japón","Tokio");
        capitales.put("Jordania","Amán");
        capitales.put("Kazajistán","Astaná");
        capitales.put("Kenia","Nairobi");
        capitales.put("Kirguistán","Biskek");
        capitales.put("Kiribati","Tarawa");
        capitales.put("Kuwait","Kuwait");
        capitales.put("Laos","Vientián");
        capitales.put("Lesoto","Riga");
        capitales.put("Líbano","Beirut");
        capitales.put("Liberia","Monrovia");
        capitales.put("Libia","Trípoli");
        capitales.put("Liechtenstein","Vaduz");
        capitales.put("Lituania","Vilna");
        capitales.put("Luxemburgo","Luxemburgo");
        capitales.put("Madagascar","Antananarivo");
        capitales.put("Malasia","Kuala Lumpur");
        capitales.put("Malaui","Lilongüe");
        capitales.put("Maldivas","Malé");
        capitales.put("Malí","Bamako");
        capitales.put("Malta","La Valeta");
        capitales.put("Marruecos","Rabat");
        capitales.put("Mauricio","Port-Louis");
        capitales.put("Mauritania","Nuakchot");
        capitales.put("México","Ciudad de México");
        capitales.put("Micronesia","Palikir");
        capitales.put("Moldavia","Chisináu");
        capitales.put("Mónaco","Mónaco");
        capitales.put("Mongolia","Ulán Bator");
        capitales.put("Montenegro","Podgorica");
        capitales.put("Mozambique","Maputo");
        capitales.put("Namibia","Windhoek");
        capitales.put("Nauru","Yaren");
        capitales.put("Nepal","Katmandú");
        capitales.put("Nicaragua","Managua");
        capitales.put("Níger","Niamey");
        capitales.put("Nigeria","Abuya");
        capitales.put("Noruega","Oslo");
        capitales.put("Nueva Zelanda","Wellington");
        capitales.put("Omán","Mascate");
        capitales.put("Países Bajos","Ámsterdam");
        capitales.put("Pakistán","Islamabad");
        capitales.put("Palaos","Melekeok");
        capitales.put("Panamá","Panamá");
        capitales.put("Papúa Nueva Guinea","Port Moresby");
        capitales.put("Paraguay","Asunción");
        capitales.put("Perú","Lima");
        capitales.put("Polonia","Varsovia");
        capitales.put("Portugal","Lisboa");
        capitales.put("Reino Unido","Londres");
        capitales.put("República Centroafricana","Bangui");
        capitales.put("República Checa","Praga");
        capitales.put("República de Macedonia","Skopie");
        capitales.put("República del Congo","Brazzaville");
        capitales.put("República Democrática del Congo","Kinsasa");
        capitales.put("República Dominicana","Santo Domingo");
        capitales.put("República Sudafricana","Bloemfontein, Ciudad Del Cabo y Pretoria");
        capitales.put("Ruanda","Kigali");
        capitales.put("Rumanía","Bucarest");
        capitales.put("Rusia","Moscú");
        capitales.put("Samoa","Apia");
        capitales.put("San Cristóbal y Nieves","Basseterre");
        capitales.put("San Marino","San Marino");
        capitales.put("San Vicente y las Granadinas","Kingstown");
        capitales.put("Santa Lucía","Castries");
        capitales.put("Santo Tomé y Príncipe","Santo Tomé");
        capitales.put("Senegal","Dakar");
        capitales.put("Serbia","Belgrado");
        capitales.put("Seychelles","Victoria");
        capitales.put("Sierra Leona","Freetown");
        capitales.put("Singapur","Singapur");
        capitales.put("Siria","Damasco");
        capitales.put("Somalia","Mogadiscio");
        capitales.put("Sri Lanka","Sri Jayewardenepura");
        capitales.put("Suazilandia","Babane y Lobamba");
        capitales.put("Sudán","Jartum");
        capitales.put("Sudán del Sur","Yuba");
        capitales.put("Suecia","Estocolmo");
        capitales.put("Suiza","Berna");
        capitales.put("Surinam","Paramaribo");
        capitales.put("Tailandia","Bangkok");
        capitales.put("Tanzania","Dodoma");
        capitales.put("Tayikistán","Dusambé");
        capitales.put("Timor Oriental","Dili");
        capitales.put("Togo","Lomé");
        capitales.put("Tonga","Nukualofa");
        capitales.put("Trinidad y Tobago","Puerto España");
        capitales.put("Túnez","Túnez");
        capitales.put("Turkmenistán","Asjabad");
        capitales.put("Turquía","Ankara");
        capitales.put("Tuvalu","Fongafale");
        capitales.put("Ucrania","Kiev");
        capitales.put("Uganda","Kampala");
        capitales.put("Uruguay","Montevideo");
        capitales.put("Uzbekistán","Taskent");
        capitales.put("Vanuatu","Port Vila");
        capitales.put("Venezuela","Caracas");
        capitales.put("Vietnam","Hanói");
        capitales.put("Yemen","Saná");
        capitales.put("Yibuti","Yibuti");
        capitales.put("Zambia","Lusaka");
        capitales.put("Zimbabue","Harare");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        crearCapitales();

        tv = findViewById(R.id.textView);
        nIntentos = findViewById(R.id.textView3);
        spinner = findViewById(R.id.spinner2);
        bt = findViewById(R.id.button);
        contador = 2;
        nIntentos.setText(String.valueOf(contador+1));
        perder = 0;

        Intent i = getIntent();
        pais = i.getStringExtra("pais");
        //Log.v("Hola", pais);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capitales.get(pais).equals(spinner.getSelectedItem().toString())){
                    llamarActividad();
                }else if(contador == 0){
                    perder = 1;
                    llamarActividadPerder();
                }else {
                    Toast.makeText(MainActivity2.this, "No es correcto", Toast.LENGTH_LONG).show();
                    contador--;
                    nIntentos.setText(String.valueOf(contador+1));
                }
            }
        });
    }

    /**
     * Guardar el estado del contador
     * @param guardaEstado
     */
    @Override
    public void onSaveInstanceState(Bundle guardaEstado) {
        super.onSaveInstanceState(guardaEstado);
        guardaEstado.putInt("contador", contador);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
        nIntentos.setText(String.valueOf(contador+1));
    }
}
