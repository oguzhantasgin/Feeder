package com.example.oguzhan.feeder;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button myButtonMama;
    private TextView mySensor;
    private Firebase myRefMotor,myRefSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        myRefMotor = new Firebase("https://cat-feeder-c8c3d.firebaseio.com/motorDurumu");
        myRefSensor = new Firebase("https://cat-feeder-c8c3d.firebaseio.com/sensorDurumu");
        myButtonMama = findViewById(R.id.mamaButton);
        mySensor = (TextView) findViewById(R.id.sensorView);

        myRefSensor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String durum = dataSnapshot.getValue(String.class);
                mySensor.setText(durum);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        //Mamanın döküleceği dokunma eylemine dair mantıki sorgular

        myButtonMama.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {

                                               myRefMotor.setValue(1);
                                           }
                                       }

        );
    }

}
