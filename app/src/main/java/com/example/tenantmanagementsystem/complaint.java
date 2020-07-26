package com.example.tenantmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class complaint extends AppCompatActivity {

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_complaint);
    //}

    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        // FirebaseApp.initializeApp(Display.this);
        firebaseFirestore=FirebaseFirestore.getInstance();
        RecyclerView mFirestoreList = (RecyclerView) findViewById(R.id.firestore_list);

        //Query
        Query query = firebaseFirestore.collection("Complaints");
        //RecyclerOptions
        FirestoreRecyclerOptions<complaintModel> options=new FirestoreRecyclerOptions.Builder<complaintModel>().setQuery(query,complaintModel.class).build();

        adapter= new FirestoreRecyclerAdapter<complaintModel, complaintViewHolder>(options) {
            @NonNull
            @Override
            public complaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);
                return new complaintViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull complaintViewHolder holder, int position, @NonNull complaintModel model) {
                holder.list_comp.setText(model.getComp());
            }
        };

        //mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);

    }

    private class complaintViewHolder extends RecyclerView.ViewHolder {

        private TextView list_comp;

        public complaintViewHolder(@NonNull View itemView) {
            super(itemView);

            list_comp = (TextView) itemView.findViewById(R.id.list_comp);
        }
        public void setComp(String comp){
            list_comp.setText(comp);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    public void _post(View view) {
        Intent intent =new Intent(this,post_complaint.class);
        startActivity(intent);
    }

}