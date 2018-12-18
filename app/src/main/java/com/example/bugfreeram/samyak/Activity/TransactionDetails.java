package com.example.bugfreeram.samyak.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.example.bugfreeram.samyak.Adapter.ContactAdapter;
import com.example.bugfreeram.samyak.Models.TransList;
import com.example.bugfreeram.samyak.R;

import java.util.ArrayList;
import java.util.List;

public class TransactionDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
/*
        llm.setOrientation(LinearLayoutManager.VERTICAL);
*/
        recList.setLayoutManager(llm);
        ContactAdapter ca = new ContactAdapter(createList(8));
        recList.setAdapter(ca);
    }
    private List<TransList> createList(int size) {

        List<TransList> result = new ArrayList<TransList>();
        for (int i=1; i <= size; i++) {
            TransList ci = new TransList();
           /* ci.name = ContactInfo.NAME_PREFIX + i;
            ci.surname = ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";*/

            result.add(ci);

        }

        return result;
    }
}