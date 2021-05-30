package com.example.gymowner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ClientsActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference ClintRef;
    RecyclerView clientRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen
        setContentView(R.layout.activity_clients);

        mAuth = FirebaseAuth.getInstance();

        //String currentUserId = mAuth.getCurrentUser().getUid();

        ClintRef = FirebaseDatabase.getInstance().getReference().child("Clients");

        clientRec = (RecyclerView) findViewById(R.id.ClientRecList);
        clientRec.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        clientRec.setLayoutManager(linearLayoutManager);

        //RECYCLER VIEW FOR Dietecians UPDATE(CLOSE)
        startListen();

    }

    @Override
    protected void onStart() {
        super.onStart();
        startListen();
    }

    private void startListen()
    {
        Query query = FirebaseDatabase.getInstance().getReference().child("Clients").limitToLast(50);
        FirebaseRecyclerOptions<Clients> options = new FirebaseRecyclerOptions.Builder<Clients>().setQuery(query, Clients.class).build();
        FirebaseRecyclerAdapter<Clients, DietViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Clients, DietViewHolder>(options)
        {
            @Override
            protected void onBindViewHolder(@NonNull DietViewHolder holder, final int position, @NonNull Clients model)
            {
                //final String PostKey = getRef(position).getKey();
               holder.setContactt(model.getContactt());
               holder.setDateofjoiningg(model.getDateofJoiningg());
               holder.setEmaill(model.getEMaill());
               holder.setFullnamee(model.getFullnamee());
               holder.setWeightt(model.getWeightt());
            }

            @NonNull
            @Override
            public DietViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
                return new DietViewHolder(view);
            }
        };
        clientRec.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    /*And this is the static class*/
    public static class DietViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public DietViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mView = itemView;
        }

        public void setWeightt(String weightt)
        {
            TextView weight = (TextView) mView.findViewById(R.id.Weight);
            weight.setText(weightt);
        }

        public void setDateofjoiningg(String dateofjoiningg)
        {
            TextView doj = (TextView) mView.findViewById(R.id.Dateofjoining);
            doj.setText(dateofjoiningg);
        }

        public void setFullnamee(String fullnamee)
        {
            TextView name = (TextView) mView.findViewById(R.id.Name);
            name.setText(fullnamee);
        }

        public void setEmaill(String emaill)
        {
            TextView email = (TextView) mView.findViewById(R.id.Email);
            email.setText(emaill);
        }

        public void setContactt(String contactt)
        {
            TextView contact= (TextView) mView.findViewById(R.id.contact);
            contact.setText(contactt);
        }
    }
}
