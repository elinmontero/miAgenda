package com.example.miagenda;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionPagerAdapter extends FragmentStateAdapter {
    public SectionPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                AgregarActividades agregarActividad = new AgregarActividades();
                return agregarActividad;

            case 1:
                VerActividades verActividades = new VerActividades();
                return verActividades;

            case 2:
                EditarActividad editarActividad = new EditarActividad();
                return editarActividad;

        }
        return null;
    }

    @Override
    public int getItemCount() {

        return 3;
    }
}
