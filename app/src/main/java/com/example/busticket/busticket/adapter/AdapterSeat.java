package com.example.busticket.busticket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.busticket.busticket.R;
import com.example.busticket.busticket.Seat;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by compware on 2/6/2018.
 */

public class AdapterSeat extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Seat> list;

    public AdapterSeat(Context context, JSONArray array) {
        this.context = context;
        list = new ArrayList<>();
        for ( int i=1 ; i <= 33 ; i++){
            Seat s = new Seat();
            s.setNumber(i + "");
            for (int j = 0 ; j < array.length(); j++ ){
                try {
                    if(array.getJSONObject(0).optInt("seat_id") == i){
                        s.setBooked(true);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            list.add(s);
        }
    }

    public List<Seat> getList()
    {
        return list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_seat, parent, false);
        return new ViewHolderSeat(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolderSeat){
            final ViewHolderSeat vh = (ViewHolderSeat) holder;
            int po = position+1;
                vh.btnSeat.setText(po + "");
            vh.btnSeat.setBackgroundColor(context.getResources().getColor(list.get(position).isBooked() ? R.color.colorAccent : R.color.colorPrimary));
            vh.btnSeat.setEnabled(list.get(position).isBooked());
            vh.btnSeat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Seat s = list.get(position);
                    if(s.isChecked())
                    {
                        s.setChecked(false);
                        //vh.btnSeat.setEnabled(false);
                    }
                    else
                    {
                        String no =vh.btnSeat.getText().toString();
                        //Toast.makeText(context, no, Toast.LENGTH_SHORT).show();
                        s.setChecked(true);
                        s.setNumber(no);

                        //vh.btnSeat.setEnabled(true);

                    }
                    list.set(position, s);
                    notifyDataSetChanged();
                }
            });
        }
    }
    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class ViewHolderSeat extends RecyclerView.ViewHolder
    {
        Button btnSeat;
        public ViewHolderSeat(View itemView) {
            super(itemView);
            btnSeat = (Button) itemView.findViewById(R.id.btn_seat);
        }
    }
}
