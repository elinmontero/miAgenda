package com.example.miagenda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class VerActividades extends Fragment {
    ListView listaActividades;

    ArrayList<Actividades> actividades;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VerActividades() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerActividades.
     */
    // TODO: Rename and change types and number of parameters
    public static VerActividades newInstance(String param1, String param2) {
        VerActividades fragment = new VerActividades();
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
        View view = inflater.inflate(R.layout.fragment_ver_actividades, container, false);

        listaActividades = view.findViewById(R.id.listView);

        DbActividades dbUsuarios = new DbActividades(getActivity());


        ListaActividadAdaptador adaptador = new ListaActividadAdaptador(dbUsuarios.context, 0, actividades);

        listaActividades.setAdapter(adaptador);




        return view;
    }

}