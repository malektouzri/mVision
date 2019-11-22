package com.mVision.myProject.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mVision.myProject.Entities.Passport;
import com.mVision.myProject.R;
import com.mVision.myProject.utils.CircleGlide;

import java.util.List;

public class PassportAdapter extends RecyclerView.Adapter<PassportAdapter.MyViewHolder> {
    private List<Passport> items;

    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName, lastName, nationality, dateOfBirth, dateCreated;
        public RelativeLayout passportLayout;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            firstName = (TextView) view.findViewById(R.id.firstNameTv);
            lastName = (TextView) view.findViewById(R.id.lastNameTv);
            nationality = (TextView) view.findViewById(R.id.nationalityTv);
            dateOfBirth = (TextView) view.findViewById(R.id.dateOfBirthTv);
            dateCreated = (TextView) view.findViewById(R.id.dateCreated);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            passportLayout = (RelativeLayout) view.findViewById(R.id.passportLayout);
        }
    }

    public PassportAdapter(List<Passport> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public PassportAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_passport, parent, false);
        return new PassportAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PassportAdapter.MyViewHolder holder, int position) {
        Passport passport = items.get(position);
        holder.firstName.setText(passport.getInfo().getFirstName());
        holder.lastName.setText(passport.getInfo().getLastName());
        holder.nationality.setText(passport.getInfo().getNationality());
        holder.dateOfBirth.setText(passport.getInfo().getDateOfBirth());
        holder.dateCreated.setText(passport.getDate().toString());
        Glide.with(context)
                .load(Uri.parse(( passport).getImage()))
                .transform(new CircleGlide(context))
                .into(holder.imageView);
        /*
        OfferActivity.StopBackPressed=false;
        MyPostsActivity.StopBackPressed=false;

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                "http://"+ip+"/Shopping_Assistant/web/app_dev.php/user/findImage/"+offer.getUserEmail(),
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray j =new JSONArray(response);
                            Glide.with(context)
                                    .load(Uri.parse(((JSONObject)j.get(0)).getString("token")))
                                    .transform(new CircleGlide(context))
                                    .into(holder.userImage);

                            OfferActivity.StopBackPressed=true;
                            MyPostsActivity.StopBackPressed=true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("delete shopproduct didn't work !");
            }
        });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);

        holder.offerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,OfferDetailsActivity.class);
                intent.putExtra("offer_id",offer.getId());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}