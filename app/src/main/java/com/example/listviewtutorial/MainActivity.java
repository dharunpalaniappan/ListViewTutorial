package com.example.listviewtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText tag;
    Button add;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.name);
        tag=(EditText) findViewById(R.id.number);
        add=(Button) findViewById(R.id.join);
        listview=(ListView) findViewById(R.id.listview);
        ArrayList<Player> playerArrayList = new ArrayList<>();
        CustomAdapter adapter = new CustomAdapter(this,playerArrayList);
        listview.setAdapter(adapter);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String playername = name.getText().toString();
            if(playername.contains(" "))
                {
                    name.setError("Player name cannot have space");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String pname = name.getText().toString();
                    final String ptag = tag.getText().toString();
                    Player player = new Player(pname,ptag);
                    playerArrayList.add(player);
                }
            });
    }
}