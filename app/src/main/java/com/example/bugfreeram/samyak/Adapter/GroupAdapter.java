package com.example.bugfreeram.samyak.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bugfreeram.samyak.Activity.GroupDetails;
import com.example.bugfreeram.samyak.Custom.Product;
import com.example.bugfreeram.samyak.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private Context mCtx;
    private List<Product> productList;


    public GroupAdapter(Context mCtx) {//}, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public GroupAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.group_items, null);
        return new GroupAdapter.GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupAdapter.GroupViewHolder holder, int position) {

//        Product product = productList.get(position);
//        holder.textViewTitle.setText(product.getTitle());
//        holder.textViewShortDesc.setText(product.getShortdesc());
//        holder.tv_like.setText(String.valueOf(product.getLikes()));
//        holder.tv_coment.setText(String.valueOf(product.getComents()));
//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
//        holder.img_back_card.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return 7;
    }


    class GroupViewHolder extends RecyclerView.ViewHolder {

//        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice , tv_like, tv_coment;
//        ImageView imageView, img_back_card;

        public GroupViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, GroupDetails.class);
                    context.startActivity(intent);
                }
            });
//            textViewTitle = itemView.findViewById(R.id.textViewTitle);
//            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            tv_like = itemView.findViewById(R.id.tv_like);
//            tv_coment = itemView.findViewById(R.id.tv_coment);
//            imageView = itemView.findViewById(R.id.imageView);
//            img_back_card = itemView.findViewById(R.id.img_back_card);
        }
    }
}
