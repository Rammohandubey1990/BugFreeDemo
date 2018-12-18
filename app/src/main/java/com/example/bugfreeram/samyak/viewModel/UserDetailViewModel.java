package com.example.bugfreeram.samyak.viewModel;


import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bugfreeram.samyak.Models.UserNew;

import java.util.Observable;


public class UserDetailViewModel extends Observable {

    private UserNew user;

    public UserDetailViewModel(UserNew user) {this.user = user;}

    public String getFullUserName(){
        user.fullName = user.name.title + "." + user.name.first + " " + user.name.last ;
        return user.fullName;
    }

    public String getUserName(){return user.login.username;}

    public String getEmail() { return user.email; }

    public int getEmailVisibility() {return user.hasEmail() ? View.VISIBLE : View.GONE ;}

    public String getCell() { return user.cell; }

    public String getProfileThumb() { return user.picture.large ;}

    public String getAddress() {
        return user.location.street
                + " "
                + user.location.city
                + " "
                + user.location.state;
    }

    public String getGender() { return user.gender;}

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }


}
