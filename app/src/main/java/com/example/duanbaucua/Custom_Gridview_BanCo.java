package com.example.duanbaucua;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Custom_Gridview_BanCo extends ArrayAdapter<Integer>
{
    private Context context;
    private int resource;
    private Integer[] objects;
    private Integer[] giaTien = {0,100,200,300,400,500,1000};
    ArrayAdapter<Integer> adapter;
    public Custom_Gridview_BanCo(Context context, int resource, Integer[] objects)
    {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;

        adapter = new ArrayAdapter<Integer>(context,R.layout.support_simple_spinner_dropdown_item,giaTien);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View view = View.inflate(context, resource, null);
        ImageView imgBanCo = (ImageView) view.findViewById(R.id.imgBanCo);
        Spinner spinGiaTien = (Spinner) view.findViewById(R.id.spinGiaTien);

        imgBanCo.setImageResource(objects[position]);
        spinGiaTien.setAdapter(adapter);

        spinGiaTien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positionspin, long id)
            {
                Manhinh2.gtDatCuoc[position] = giaTien[positionspin];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });



        return  view;
    }
}