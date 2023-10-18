package com.example.miagenda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListaActividadAdaptador extends ArrayAdapter<Actividades> {

    public ListaActividadAdaptador(@NonNull Context context, int resource, @NonNull ArrayList<Actividades> actividades) {
        super(context, 0, actividades);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout, parent, false);
        }

        TextView tituloActividad = ((LinearLayout)convertView).findViewById(R.id.tvTitulo);
        TextView descripcionActividad = ((LinearLayout)convertView).findViewById(R.id.tvDescripcion);

        Actividades actividades = getItem(position);

        tituloActividad.setText(actividades.getTitulo());
        descripcionActividad.setText(actividades.getDescripcion());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, VerActividades.class);

                intent.putExtra("ID", actividades.getId() );
                context.startActivity(intent);
            }
        });

        return convertView;

    }
}
