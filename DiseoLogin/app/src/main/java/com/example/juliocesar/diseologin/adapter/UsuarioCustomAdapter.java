package com.example.juliocesar.diseologin.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.juliocesar.diseologin.EditUsuario;
import com.example.juliocesar.diseologin.R;

import java.util.List;

public class UsuarioCustomAdapter extends RecyclerView.Adapter<UsuarioCustomAdapter.ViewHolder> {

    private List<UsuarioAdapter> blogList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, telefono, correo, contraseña;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre  = itemView.findViewById(R.id.txt_nombre);
            telefono   = itemView.findViewById(R.id.telefono);
            correo   = itemView.findViewById(R.id.correo);
            contraseña   = itemView.findViewById(R.id.contraseña);
        }
    }
    public UsuarioCustomAdapter(List<UsuarioAdapter> listBlog){
        this.blogList = listBlog;
    }

    @Override
    public UsuarioCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_blog, parent, false);
        return new ViewHolder(view);
    }

    public void add(UsuarioAdapter blog){
        blogList.add(blog);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(UsuarioCustomAdapter.ViewHolder holder, int position) {
        final UsuarioAdapter blog = blogList.get(position);
        holder.nombre.setText(blog.getNombre());
        holder.telefono.setText(blog.getTelefono());
        holder.correo.setText(blog.getCorreo());
        holder.contraseña.setText(blog.getContraseña());
        ///edit
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(v.getContext(), EditUsuario.class);
                mIntent.putExtra("id",blog.getId());
                v.getContext().startActivity(mIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
