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
import com.google.firebase.database.core.Context;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedbackActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference feedbackRef;
    RecyclerView clientRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen
        setContentView(R.layout.activity_feedbacks);

        mAuth = FirebaseAuth.getInstance();

        //String currentUserId = mAuth.getCurrentUser().getUid();

        feedbackRef = FirebaseDatabase.getInstance().getReference().child("Feedbacks");

        clientRecView = (RecyclerView) findViewById(R.id.feedback_recList);
        clientRecView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        clientRecView.setLayoutManager(linearLayoutManager);

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
        Query query = FirebaseDatabase.getInstance().getReference().child("Feedbacks").limitToLast(50);
        FirebaseRecyclerOptions<Feedback> options = new FirebaseRecyclerOptions.Builder<Feedback>().setQuery(query, Feedback.class).build();
        FirebaseRecyclerAdapter<Feedback, FeedbackViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Feedback, FeedbackViewHolder>(options)
        {
            @Override
            protected void onBindViewHolder(@NonNull FeedbackViewHolder holder, final int position, @NonNull Feedback model)
            {
                //final String PostKey = getRef(position).getKey();

                holder.setFullnamee(model.getFullnamee());
                holder.setUIDD(model.getUIDD());
                holder.setFeedbackk(model.getFeedbackk());
                holder.setProfilee(model.getProfilee());
            }

            @NonNull
            @Override
            public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
            {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_feedback_layout,parent,false);
                return new FeedbackViewHolder(view);
            }
        };
        clientRecView.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.startListening();
    }

    /*And this is the static class*/
    public static class FeedbackViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public FeedbackViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mView = itemView;
        }

        public void setFeedbackk(String feedback)
        {
            TextView feedbackk = (TextView) mView.findViewById(R.id.feedback_feedback);
            feedbackk.setText(feedback);
        }

        public void setFullnamee(String fullname)
        {
            TextView name = (TextView) mView.findViewById(R.id.feedback_name);
            name.setText(fullname);
        }


        public void setUIDD(String UID)
        {
            TextView uid= (TextView) mView.findViewById(R.id.feedback_uid);
            uid.setText(UID);
        }

        public void setProfilee(String profile )
        {
            CircleImageView teacherImage = (CircleImageView) mView.findViewById(R.id.feedback_profilephoto);
            Picasso.get().load(profile).placeholder(R.drawable.profilephoto).into(teacherImage);
        }
    }
}
