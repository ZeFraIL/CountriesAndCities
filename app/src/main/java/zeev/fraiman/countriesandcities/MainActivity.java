package zeev.fraiman.countriesandcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lv2lv(View view) {
        Intent go=new Intent(this, ListView2ListView.class);
        startActivity(go);
    }

    public void accBTV(View view) {
        Intent go=new Intent(this, AccordeonBTV.class);
        startActivity(go);
    }

    public void allMenu(View view) {
        Intent go=new Intent(this, AllInMenu.class);
        startActivity(go);
    }
}