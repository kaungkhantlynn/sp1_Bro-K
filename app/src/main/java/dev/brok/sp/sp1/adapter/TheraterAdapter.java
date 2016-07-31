package dev.brok.sp.sp1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import dev.brok.sp.sp1.R;
import dev.brok.sp.sp1.model.TheraterModel;

/**
 * Created by kaungkhantlynn on 7/31/16.
 */
public class TheraterAdapter extends RecyclerView.Adapter<TheraterAdapter.TheraterViewHolder>{
    Context context;
    List<TheraterModel> theraterModelList;
    TheraterItemClicketListenter theraterItemClicketListenter;

    public TheraterAdapter(Context context, List<TheraterModel> theraterModelList, TheraterItemClicketListenter theraterItemClicketListenter) {
        this.context = context;
        this.theraterModelList = theraterModelList;
        this.theraterItemClicketListenter = theraterItemClicketListenter;
    }

    @Override
    public TheraterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.therater_card, parent, false);

        return new TheraterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TheraterViewHolder holder, int position) {
        holder.txtThearter.setText(theraterModelList.get(position).getName());
        Glide.with(context).load(theraterModelList.get(position).getImg())
                .skipMemoryCache( true )
                .diskCacheStrategy( DiskCacheStrategy.ALL)
                .into(holder.imgTherater);
    }

    @Override
    public int getItemCount() {
        return theraterModelList.size();
    }

    public class TheraterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgTherater;
        TextView txtThearter;
        public TheraterViewHolder(View itemView) {
            super(itemView);
            imgTherater=(ImageView)itemView.findViewById(R.id.therater_img);
            txtThearter=(TextView)itemView.findViewById(R.id.txt_theratre);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            theraterItemClicketListenter.OnItemClick(theraterModelList.get(getLayoutPosition()));
        }
    }

    public interface TheraterItemClicketListenter{
        public void OnItemClick(TheraterModel theraterModel);
    }
}
