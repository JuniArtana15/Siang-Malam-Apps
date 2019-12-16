package com.example.siangmalam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siangmalam.R;

public class showDetail extends AppCompatActivity implements OpenDialog.OpenDialogListener{

    private long receivedFoodId;
    TextView totalan,edtName,edtDetail,edtPrice,edtStamp;
    ImageView imageView ;
    private SQLiteHelper sqLiteHelper = null ;
    public DbBitmapUtility bitmapUtility;
    Button tambahbasket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        //add button back navigation
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtName =(TextView) findViewById(R.id.tName);
        edtDetail =(TextView) findViewById(R.id.tDetail);
        edtPrice = (TextView) findViewById(R.id.tPrice);
        edtStamp = (TextView) findViewById(R.id.tStamp);
        imageView = (ImageView) findViewById(R.id.imageView2);
        tambahbasket = (Button) findViewById(R.id.tambahbasketnya);
        sqLiteHelper = new SQLiteHelper(this);

        try {
            receivedFoodId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Food queriedFood = sqLiteHelper.getFood(receivedFoodId);

        edtName.setText(queriedFood.getName());
        edtDetail.setText(queriedFood.getDetail());
        edtPrice.setText("Rp."+queriedFood.getPrice()+",00");
        edtStamp.setText("Tersisa "+queriedFood.getStamp());
        bitmapUtility.getImageShow(imageView,queriedFood.getImage());

        tambahbasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        OpenDialog openDialog = new OpenDialog();

        openDialog.show(getSupportFragmentManager(),"Open Dialog");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(String username, String password) {

    }
}