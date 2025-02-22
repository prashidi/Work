package com.example.cape_medics;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

public class ItemsHanded extends Fragment {
    ListView itemsHanded;
    JSONObject itemsHandedOver;

    public ItemsHanded(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_items_handed,container,false);

        itemsHandedOver = new JSONObject();

        itemsHanded = view.findViewById(R.id.items);
        itemsHanded.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items = {"Refferal Letter", "X-Rays", "WCA Forms", "Medications", "Patient Valuables", "Cell-Phone",
                "No items Handed Over"};
        ArrayAdapter<String> ItemsAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.custom_checked_list,items);

        itemsHanded.setAdapter(ItemsAdapter);

        return view;

        //add recording mechanism
    }

    public JSONObject createJson(){
        itemsHandedOver = new JSONObject();
        for (int i = 0; i < itemsHanded.getChildCount(); i++) {

            if (itemsHanded.isItemChecked(i)){
                try{
                    itemsHandedOver.put(itemsHanded.getItemAtPosition(i).toString(),itemsHanded.getItemAtPosition(i).toString());

                }catch (Exception e){}
            }
        }
        return itemsHandedOver;
    }

    public void skip(View v){

    }
}
