package com.ytheekshana.deviceinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapterApk extends ArrayAdapter<Employeepk> {

    Context context;
    List<Employeepk> arrayListapkEmployee;


    public MyAdapterApk(@NonNull Context context, List<Employeepk> arrayListapkEmployee) {
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
