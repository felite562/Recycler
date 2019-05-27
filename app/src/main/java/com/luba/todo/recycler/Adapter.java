package com.luba.todo.recycler;

import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Item> mList;


    public static class ViewHolder extends RecyclerView.ViewHolder {
       public TextView tView,tDate;

        public ViewHolder(@NonNull View itemView, int typeItem) {
            super(itemView);
         if(typeItem==Item.TYPE1)
            {tView=itemView.findViewById(R.id.textView1);
            tDate=itemView.findViewById(R.id.textView11);            }
          if(typeItem==Item.TYPE2)
            {tView=itemView.findViewById(R.id.textView2);
            tDate=itemView.findViewById(R.id.textView21);}
         if(typeItem==Item.TYPE3)
            {tView=itemView.findViewById(R.id.textView3);
            tDate=itemView.findViewById(R.id.textView31);}
        }

    }
public Adapter(ArrayList<Item> list){
        this.mList=list;

}
    @Override
    public int getItemViewType(int position) {
        int c=1;
        Item item=mList.get(position);
        if(item !=null)
        c= item.getType();
        return c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int typeItem) {
        View v=null;
        switch(typeItem)
        {
            case 1:v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_type_one, viewGroup, false);
                break;
            case 2:v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_type_two, viewGroup, false);
                break;
            case 3: v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_type_three, viewGroup, false);
            break;
            default: break;

        }
        ViewHolder vh=new ViewHolder(v,typeItem);
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            final Item currentItem=mList.get(position);

        viewHolder.tView.setText(currentItem.getText1());
        final String g=currentItem.getText1();
       viewHolder.tDate.setText(currentItem.getText2());
       /* Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = null;
        String strDate = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            strDate = sdf.format(c.getTime());
        }
        viewHolder.tView2.setText(strDate);*/
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),g,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
