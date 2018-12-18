package com.example.bugfreeram.samyak.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bugfreeram.samyak.Activity.UserDetailActivity;
import com.example.bugfreeram.samyak.Models.UserNew;

public class ItemUserViewModel extends BaseObservable {

    private UserNew user;
    private Context context;

    public ItemUserViewModel(UserNew user, Context context){
        this.user = user;
        this.context = context;
    }

    public String getProfileThumb() {
        return user.picture.medium;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public String getCell() { return user.cell; }

    public String getEmail() { return user.email; }
    public String getFullName() {

        user.fullName = user.name.title + "." + user.name.first + " " + user.name.last;
        return user.fullName;

    }

    public void onItemClick(View v){
        context.startActivity(UserDetailActivity.fillDetail(v.getContext(), user));
    }

    public void setUser(UserNew user) {
        this.user = user;
        notifyChange();
    }
}
