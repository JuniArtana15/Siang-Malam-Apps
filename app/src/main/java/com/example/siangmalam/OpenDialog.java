package com.example.siangmalam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class OpenDialog extends AppCompatDialogFragment {
    private OpenDialogListener listener;
    int minteger = 0;
    TextView displaynumber,harga;
    Button tambah,kurang;
    private long receivedFoodId;
    private SQLiteHelper sqLiteHelper = null ;
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_counter, null);
        tambah = (Button) view.findViewById(R.id.increase);
        kurang = (Button) view.findViewById(R.id.decrease);
        displaynumber = (TextView) view.findViewById(R.id.integer_number);
        harga = (TextView) view.findViewById(R.id.tPrice);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseInteger();
            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decreaseInteger();
            }
        });
        builder.setView(view)
                .setTitle("Pesan")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Pesanan Anda sedang diproses. harap menunggu..",
                                Toast.LENGTH_LONG).show();
                    }
                });

        return builder.create();

    }

    private void decreaseInteger() {
        minteger = minteger - 1;
        display(minteger);
    }
    private void increaseInteger() {
        minteger = minteger + 1;
        display(minteger);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (OpenDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

        public interface OpenDialogListener {
        void applyTexts(String username, String password);
    }
    private void display(int number) {
        displaynumber.setText("" + number);
    }
}