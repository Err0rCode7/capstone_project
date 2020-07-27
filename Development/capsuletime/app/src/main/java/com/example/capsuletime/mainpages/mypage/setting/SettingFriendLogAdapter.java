package com.example.capsuletime.mainpages.mypage.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.capsuletime.R;
import com.example.capsuletime.core.preferences.LockNickNameSharedPreferences;
import com.example.capsuletime.core.preferences.NickNameSharedPreferences;
import com.example.capsuletime.mainpages.followpage.Follow;
import com.example.capsuletime.mainpages.userpage.userpage;

import java.util.ArrayList;
import java.util.HashSet;

;


public class SettingFriendLogAdapter extends RecyclerView.Adapter<SettingFriendLogAdapter.FolloewLogAdapter> {

    private  ArrayList<Locked_Capsule> arrayList;
    private Context context;
    private static final String TAG = "FollowLogAdapterPage";
    private int count = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;

    public SettingFriendLogAdapter(ArrayList<Locked_Capsule> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FolloewLogAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lock_capsule_log,parent,false);

        FolloewLogAdapter holder = new FolloewLogAdapter(view);


        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull FolloewLogAdapter holder, int position) {

        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);

        holder.tv_nick.setText(arrayList.get(position).getNick_name());
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.chkSelected.setSelected(arrayList.get(position).isSelected());


        LockNickNameSharedPreferences lockNickNameSharedPreferences = LockNickNameSharedPreferences.getInstanceOf(context.getApplicationContext());
        ArrayList<String> nickName = new ArrayList<String>();

        holder.chkSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    count++;

                    /*if(nickName.size() != 0) {*/
                        for (int i = 0; i < count; i++) {
                                nickName.add(i, arrayList.get(position).getNick_name());
                        }
                    Log.d(TAG, nickName.toString());


                    /*}*/
                    /*nickName.add(arrayList.get(position).getNick_name());
                    lockNickNameSharedPreferences.putHashSet(LockNickNameSharedPreferences.NICKNAME_SHARED_PREFERENCES_KEY2, nickName);*/



                    Log.d(TAG,arrayList.get(position).getNick_name()+" " + count);
                } else {
                    for (int i = 0; i < count; i++) {
                        if (!isChecked) {
                            nickName.remove(arrayList.get(i).getNick_name());

                            count--;
                            Log.d(TAG, nickName.toString());
                        }
                    }
                }
                lockNickNameSharedPreferences.putHashSet(LockNickNameSharedPreferences.NICKNAME_SHARED_PREFERENCES_KEY2, nickName);
            }
        });



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(holder.chkSelected.isChecked()){
                    holder.chkSelected.setChecked(holder.chkSelected.isChecked());
                } else {
                    holder.chkSelected.setChecked(holder.chkSelected.isChecked());
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class FolloewLogAdapter extends RecyclerView.ViewHolder {

        ImageView iv_profile;
        TextView tv_nick;
        TextView tv_name;
        CheckBox chkSelected;

        public FolloewLogAdapter(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_nick = itemView.findViewById(R.id.tv_nick);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.chkSelected = itemView.findViewById(R.id.chkSelected);
        }

    }
}
