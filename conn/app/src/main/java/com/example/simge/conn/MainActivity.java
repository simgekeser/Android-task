package com.example.simge.conn;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button kek;
    Button makarna;
    Button atıstırma;
    Button diyet;
    Button balık;
    Button borek;


    Spinner spinner;

    public TextView result;
    public TextView tarif;
    public TextView malzeme;
    ListView listView;

    Intent intent;
    String[] categories = {"Kategoriler","Makarnalar","Kekler","Atıştırmalıklar","Balıklar","Börekler","Diyetler"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinner);

        kek=(Button)findViewById(R.id.kek);
        makarna=(Button)findViewById(R.id.makarna);
        diyet= (Button)findViewById(R.id.diyet);
        borek=(Button)findViewById(R.id.börek);
        atıstırma=(Button)findViewById(R.id.atıstırma);
        balık=(Button)findViewById(R.id.balık);

        listView=(ListView)findViewById(R.id.listView);




//spinner------------------------------------------------------------------

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);


//KEKLER-----------------------------------------------------------------------------------------------
        kek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Kekler";
              //  String tarif1 = databaseAccess.getMalzeme(n);

               //tarif.setText(tarif1);
                //   DatabaseAccess db = new DatabaseAccess(MainActivity.this);
                //ArrayList<HashMap<String, String>> userList = db.GetUsers(n);
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);
                //ListAdapter adapter = new SimpleAdapter(MainActivity.this, userList, R.layout.list_row,new String[]{"yemekad","yemektarifi"}, new int[]{R.id.yemekad,R.id.yemektarifi});;
                listView.setAdapter(adapter);
              //  Toast.makeText(getApplicationContext(),tarif,Toast.LENGTH_LONG).show();



                databaseAccess.close();


            }
        });

//MAKARNALAR-----------------------------------------------------------------------------------------------
        makarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Makarnalar";
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

                listView.setAdapter(adapter);

                databaseAccess.close();

            }
        });
//DİYETLER-----------------------------------------------------------------------------------------------------------
        diyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Diyetler";
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

                listView.setAdapter(adapter);

                databaseAccess.close();

            }
        });
//BALIKLAR------------------------------------------------------------------------------------------------
        balık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Balıklar";
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

                listView.setAdapter(adapter);

                databaseAccess.close();

            }
        });

//ATIŞTIRMALIKLAR------------------------------------------------------------------------------

        atıstırma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Atıştırmalıklar";
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

                listView.setAdapter(adapter);

                databaseAccess.close();

            }
        });
//BÖREKLER------------------------------------------------------------------------------------
        borek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n= "Börekler";
                ArrayList<String> temp = new ArrayList<>();
                temp = databaseAccess.getYemekadı(n);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

                listView.setAdapter(adapter);

                databaseAccess.close();

            }
        });
//--------------------------------------------------------------------------------------------------------






    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();


        // Showing selected spinner item
      //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        if(item.equals("Kategoriler")){
            DatabaseAccess databaseAccess1 = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess1.open();
            ArrayList<String> tumYemekler = new ArrayList<>();
            tumYemekler = databaseAccess1.getTumYemekadı();

            ArrayAdapter<String> adapterYemek=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,tumYemekler);

            listView.setAdapter(adapterYemek);
            databaseAccess1.close();

        }else {


            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();


            ArrayList<String> temp = new ArrayList<>();
            temp = databaseAccess.getYemekadı(item);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.activity_list_item, android.R.id.text1, temp);

            listView.setAdapter(adapter);

            databaseAccess.close();
        }
    }/*
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {




        String text = spinner.getSelectedItem().toString();

        Toast.makeText(getApplicationContext(),categories[position] , Toast.LENGTH_LONG).show();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        ArrayList<String> temp = new ArrayList<>();
        temp = databaseAccess.getYemekadı();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item,android.R.id.text1,temp);

        listView.setAdapter(adapter);

        databaseAccess.close();
    }*/

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
