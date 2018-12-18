package com.example.bugfreeram.samyak.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bugfreeram.samyak.Custom.Product;
import com.example.bugfreeram.samyak.R;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx){//}, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

    //   Product product = productList.get(position);


//        holder.textViewTitle.setText(product.getTitle());
//        holder.textViewShortDesc.setText(product.getShortdesc());

//        holder.tv_coment.setText(String.valueOf(product.getComents()));
//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));
//        holder.img_back_card.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return 6;
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

      // TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice , tv_like, tv_coment;
//        ImageView imageView, img_back_card;
     //   ImageView img_like;

        public ProductViewHolder(View itemView) {
            super(itemView);
//            textViewTitle = itemView.findViewById(R.id.textViewTitle);
//            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            tv_coment = itemView.findViewById(R.id.tv_coment);
//            imageView = itemView.findViewById(R.id.imageView);
//            img_back_card = itemView.findViewById(R.id.img_back_card);
        }
    }
}