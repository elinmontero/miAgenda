package com.example.miagenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarActividad#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarActividad extends Fragment {

    EditText etTitulo, etDescripcion;
    Button btnGuardar;

    FloatingActionButton btnEditar, btnEliminar;

    Actividades usuario;

    int id =0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditarActividad() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditarActividad.
     */
    // TODO: Rename and change types and number of parameters
    public static EditarActividad newInstance(String param1, String param2) {
        EditarActividad fragment = new EditarActividad();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editar_actividad, container, false);

        etTitulo = view.findViewById(R.id.etEditarTitulo);
        etDescripcion = view.findViewById(R.id.etEditarDescripcion);
        btnGuardar = view.findViewById(R.id.btnGuardarEdicion);
        btnEditar = view.findViewById(R.id.floatingActionButton);
        btnEliminar = view.findViewById(R.id.floatingActionButton2);

        if(savedInstanceState == null){

            Bundle extras = getActivity().getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }

        } else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbActividades dbUsuarios = new DbActividades(getActivity());
        usuario = dbUsuarios.verActividad(id);
        if(usuario== null){
            etTitulo.setText(usuario.getTitulo());
            etDescripcion.setText(usuario.getDescripcion());
            btnGuardar.setVisibility(view.INVISIBLE);

            etTitulo.setInputType(InputType.TYPE_NULL);
            etDescripcion.setInputType(InputType.TYPE_NULL);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditarActividad.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Deseas eliminar esta actividad ?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(dbUsuarios.eliminarActividad(id)){
                                    lista();

                                }


                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        }

        return view;
    }

    private  void lista(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}