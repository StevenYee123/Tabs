package com.example.stevenyee.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    static int rows;
    static int cols;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, null);

        final EditText rowNum = (EditText) view.findViewById(R.id.RowField);
        final EditText colNum = (EditText) view.findViewById(R.id.ColField);

        Button btn = (Button) view.findViewById(R.id.StartButton);
        final TextView tx = (TextView) view.findViewById(R.id.EnterText);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                rows = Integer.parseInt(rowNum.getText().toString());
                cols = Integer.parseInt(colNum.getText().toString());

                try{
                    if (rowsColumns(cols, rows) == cols){
                        tx.setText("Success!");
                    } else {
                        tx.setText("Failure...");
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        return view;
    }


public native int rowsColumns(int cols, int rows);
}
