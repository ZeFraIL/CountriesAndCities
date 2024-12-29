package zeev.fraiman.countriesandcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class AccordeonBTV extends AppCompatActivity
        implements View.OnClickListener {

    LinearLayout llABTV;
    Context context;
    String[][] sities={{"Wien","Graz","Salzburg","Bregenz","Linz"},
            {"Warsaw","Krakow","Poznan","Lodz","Pulawy","Radom","Wroclaw","Olsztyn"},
            {"Berlin","Bonn","Hannover"},
            {"Paris","Nantes","Bergerac","Mont-Dore","Montpellier","Toulouse","Toulon","Marsielle"},
            {"Roma","Bologna","Napoli","Venezia","Milano"},
            {"Madrid","Toledo","Barcelona","Malaga","Sevilla"}};
    String[] towns=null;
    String[] countries=null;
    Button[] btns;
    GridLayout[] lls;
    int k=-1;
    TextView[] tvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accordeon_btv);

        initElements();
    }

    private void initElements() {
        llABTV=findViewById(R.id.llABTV);
        context=AccordeonBTV.this;
        countries=getResources().getStringArray(R.array.category);
        int n=countries.length;
        btns=new Button[n];
        lls=new GridLayout[n];
        for (int i = 0; i < n; i++) {
            btns[i] = new Button(llABTV.getContext());
            llABTV.addView(btns[i], 400,180);
            btns[i].setPadding(10, 10, 10, 10);
            btns[i].setId(i);
            btns[i].setText(countries[i]);
            btns[i].setOnClickListener(this);
            lls[i]=new GridLayout(llABTV.getContext());
            llABTV.addView(lls[i]);
            lls[i].setVisibility(View.GONE);
            lls[i].setColumnCount(2);
            lls[i].setPadding(100,50,100,50);
        }
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < btns.length; i++) {
            if (view==btns[i]) {
                Toast.makeText(context, "" + countries[i], Toast.LENGTH_SHORT).show();
                k = i;
                if (lls[i].getVisibility()==View.VISIBLE)
                    lls[i].setVisibility(View.GONE);
                else {
                    lls[i].setVisibility(View.VISIBLE);
                    goTV(k);
                }
            }
        }
        for (int i = 0; i < tvs.length; i++) {
            if (view==tvs[i])
                Toast.makeText(context,
                        ""+tvs[i].getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private void goTV(int k) {
        towns=sities[k];
        tvs=new TextView[towns.length];
        for (int i = 0; i < towns.length; i++) {
            tvs[i] = new TextView(lls[k].getContext());
            lls[k].addView(tvs[i], 400,180);
            tvs[i].setPadding(10, 10, 10, 10);
            tvs[i].setId(i);
            tvs[i].setText(towns[i]);
            tvs[i].setClickable(true);
            tvs[i].setOnClickListener(this);
            tvs[i].setTextColor(Color.RED);
        }
    }
}