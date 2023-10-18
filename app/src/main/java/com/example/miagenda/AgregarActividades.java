package com.example.miagenda;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarActividades#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarActividades extends Fragment {

    SQLiteDatabase db;
    EditText etTitulo, etDescripcion;
    Button btnGuardar;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AgregarActividades() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarActividades.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarActividades newInstance(String param1, String param2) {
        AgregarActividades fragment = new AgregarActividades();
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

       View view = inflater.inflate(R.layout.fragment_agregar_actividades, container, false);
        etTitulo = view.findViewById(R.id.etTitulo);
        etDescripcion = view.findViewById(R.id.etDescripcion);
        btnGuardar = view.findViewById(R.id.btnSubmit);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbActividades dbUsuarios = new DbActividades(getActivity());
                long id = dbUsuarios.AgregarActividad(etTitulo.getText().toString(),
                        etDescripcion.getText().toString());

                if(id > 0){
                    Toast.makeText(getActivity(), "REGISTRO GUARDADO EXITOSAMENTE",
                            Toast.LENGTH_LONG).show();
                    limpiarCampos();
                } else {
                    Toast.makeText(getActivity(), "ERROR AL GUARDAR REGISTRO ",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;

    }
    private void limpiarCampos(){
        etTitulo.setText("");
        etDescripcion.setText("");
    }
}