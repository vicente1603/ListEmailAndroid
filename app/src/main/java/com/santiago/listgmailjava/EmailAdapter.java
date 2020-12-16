package com.santiago.listgmailjava;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santiago.listgmailjava.model.Email;

import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private final List<Email> emails;

    public EmailAdapter(List<Email> emails) {
        this.emails = emails;
    }

    public List<Email> getEmails() {
        return emails;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item, parent, false);

        return new EmailViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.bind(email);


    }

    class EmailViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        TextView txtIcon;
        TextView txtSubject;
        TextView txtPreview;
        TextView txtDate;
        ImageView imgStar;

        public EmailViewHolder(View view) {
            super(view);
            txtUser = view.findViewById(R.id.txt_user);
            txtIcon = view.findViewById(R.id.txt_icon);
            txtSubject = view.findViewById(R.id.txt_subject);
            txtPreview = view.findViewById(R.id.txt_preview);
            txtDate = view.findViewById(R.id.txt_date);
            imgStar = view.findViewById(R.id.img_star);
        }

        public void bind(Email email) {

            int hash = email.getUser().hashCode();

            txtUser.setText(email.getUser());
            txtIcon.setText(String.valueOf(email.getUser().charAt(0)));
            txtIcon.setBackground(oval(Color.rgb(hash, hash / 2, 0), txtIcon));
            txtSubject.setText(email.getSubject());
            txtPreview.setText(email.getPreview());
            txtDate.setText(email.getDate());

            txtUser.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            txtSubject.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);
            txtDate.setTypeface(Typeface.DEFAULT, email.isUnread() ? Typeface.BOLD : Typeface.NORMAL);

            imgStar.setImageResource(email.isStared() ? R.drawable.ic_baseline_star_24 : R.drawable.ic_baseline_star_border_24);
        }
    }

    private static ShapeDrawable oval(@ColorInt int color, View view) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(view.getHeight());
        shapeDrawable.setIntrinsicWidth(view.getWidth());
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

}

