package com.example.bugfreeram.samyak.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.bugfreeram.samyak.Adapter.UserAdapter;
import com.example.bugfreeram.samyak.R;
import com.example.bugfreeram.samyak.databinding.ActivityUsersBinding;
import com.example.bugfreeram.samyak.viewModel.UserViewModel;

import java.util.Observable;
import java.util.Observer;

public class UsersActivity extends AppCompatActivity implements Observer {
    private ActivityUsersBinding userActivityBinding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(userActivityBinding.toolbar);
        setUpListOfUsersView(userActivityBinding.listUser);
        setUpObserver(userViewModel);
    }

    private void initDataBinding() {


        userActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_users);
        userViewModel = new UserViewModel(this);
        userActivityBinding.setUserViewModel(userViewModel);
    }

    private void setUpListOfUsersView(RecyclerView listUser) {
        UserAdapter userAdapter = new UserAdapter();
        listUser.setAdapter(userAdapter);
        listUser.setLayoutManager(new LinearLayoutManager(this));
    }
    public void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof  UserViewModel) {
            UserAdapter userAdapter = (UserAdapter) userActivityBinding.listUser.getAdapter();
            UserViewModel userViewModel = (UserViewModel) o;
            userAdapter.setUserList(userViewModel.getUserList());
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        userViewModel.reset();
    }
}
