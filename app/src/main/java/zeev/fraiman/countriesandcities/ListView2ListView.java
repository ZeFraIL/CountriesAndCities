package zeev.fraiman.countriesandcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView2ListView extends AppCompatActivity {

    String[][] sities={{"Wien","Graz","Salzburg","Bregenz","Linz"},
            {"Warsaw","Krakow","Poznan","Lodz","Pulawy","Radom","Wroclaw","Olsztyn"},
            {"Berlin","Bonn","Hannover"},
            {"Paris","Nantes","Bergerac","Mont-Dore","Montpellier","Toulouse","Toulon","Marsielle"},
            {"Roma","Bologna","Napoli","Venezia","Milano"},
            {"Madrid","Toledo","Barcelona","Malaga","Sevilla"}};
    String[] towns=null;
    ListView lvMain, lvSub;
    ArrayAdapter<String> adapterMain, adapterSub;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2_list_view);

        initElements();
        adapterMain=new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.category));
        lvMain.setAdapter(adapterMain);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                towns=sities[i];
                adapterSub=new ArrayAdapter<>(context,
                        android.R.layout.simple_list_item_1,
                        towns);
                lvSub.setAdapter(adapterSub);
            }
        });
        lvSub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewInfo(towns[i]);
            }
        });
    }

    private void viewInfo(String town) {
        Toast.makeText(context, town, Toast.LENGTH_SHORT).show();
    }

    private void initElements() {
        lvMain=findViewById(R.id.lvMain);
        lvSub=findViewById(R.id.lvSub);
        context=ListView2ListView.this;
    }
}