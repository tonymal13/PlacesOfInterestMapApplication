package com.example.lab6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateTravelDialog extends DialogFragment {

    String[] sights;
    boolean[] booleans;
    public CreateTravelDialog(List<Sight> sights)
    {
        this.sights = sights.stream().map(Sight::get_name).collect(Collectors.toList()).toArray(new String[0]);
        booleans = new boolean[sights.size()];
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setMultiChoiceItems(sights, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                    }
                }).setNegativeButton("Отмена", (dialog, which) -> dialog.cancel())
                .setPositiveButton("Создать маршрут", (dialog, which) ->{
                    List<String> strings = new ArrayList<>();
                    for (int i = 0; i < sights.length; i++)
                    {
                        if(booleans[i])
                            strings.add(sights[i]);
                    }

                    ((SightsActivity)getContext()).createRoute(strings);

                } )
                .setTitle("Создание маршрута");

        return builder.create();
    }
}
