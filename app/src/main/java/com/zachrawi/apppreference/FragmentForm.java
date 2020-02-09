package com.zachrawi.apppreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentForm extends Fragment {
    EditText etName;
    EditText etEmail;
    Button button;

    public static OnSaveListener onSaveListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySharedPreference mySharedPreference = new MySharedPreference(getActivity());

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                if (name.length() > 0 && email.length() > 0) {
                    mySharedPreference.saveName(name);
                    mySharedPreference.saveEmail(email);

                    onSaveListener.onSave();
                } else {
                    Toast.makeText(getActivity(), "Nama dan email harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnSaveListener) {
            onSaveListener = (OnSaveListener) context;
        } else {
            throw new RuntimeException("Activity harus implement OnSaveListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        onSaveListener = null;
    }

    public interface OnSaveListener {
        void onSave();
    }
}
