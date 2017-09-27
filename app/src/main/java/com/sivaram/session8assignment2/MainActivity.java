package com.sivaram.session8assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Create Object Of ListView, Collection of Person Class, And Object of CustomAdapter Class
    private ListView personsListView;
    private List<Person> personList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find List View And Type Cast to ListView Object
        personsListView = (ListView)findViewById(R.id.personsListView);

        // Initialize personList Array
        personList = new ArrayList<>();

        // Assign Values into Person List Array
        for(int i=1;i <=20; i++){
            personList.add(new Person("Name " + i , "Phone Number " + i));
        }

        // Create Object of CustomAdapater and Assign personList Collection.
        customAdapter = new CustomAdapter(getApplicationContext(), personList);
        // Assign Custom Adapter to ListView
        personsListView.setAdapter(customAdapter);

        // Set On Item Click Listener To Get Item And Show Person Name from the selected row as Toast.
        personsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicked On : " + personList.get(i).getPersonName() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
