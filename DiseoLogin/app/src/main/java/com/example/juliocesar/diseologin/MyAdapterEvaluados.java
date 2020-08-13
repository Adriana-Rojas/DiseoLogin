package com.example.juliocesar.diseologin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapterEvaluados extends ArrayAdapter<Employeevaluados> {

    Context context;
    List<Employeevaluados> arrayListapkEmployee;


    public MyAdapterEvaluados(@NonNull Context context, List<Employeevaluados> arrayListapkEmployee) {
        super(context, R.layout.custom_list_item,arrayListapkEmployee);

        this.context = context;
        this.arrayListapkEmployee = arrayListapkEmployee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvNombre = view.findViewById(R.id.txt_name);

        tvID.setText(arrayListapkEmployee.get(position).getId());
        tvNombre.setText(arrayListapkEmployee.get(position).getNombre());

        return view;
    }
}
