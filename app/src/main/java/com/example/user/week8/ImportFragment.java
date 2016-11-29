package com.example.user.week8;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {
    private EditText editTextFileName;

    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_import, container, false);

        //Link UI to program
        editTextFileName = (EditText) view.findViewById(R.id.editText);
        Button browse = (Button) view.findViewById(R.id.button);
        browse.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTextFileName.setText("File name : " + editTextFileName.getText().toString());
                    }
                }
        );
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String fileName = sharedPreferences.getString(getString(R.string.file_name).toString(), null);
        editTextFileName.setText(fileName);
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPreferences.edit();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.file_name), editTextFileName.getText().toString());
        editor.commit();
    }
}
