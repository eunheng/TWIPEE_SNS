package com.example.twipee_sns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.twipee_sns.DataModel.DataModelComment;
import com.example.twipee_sns.DataModel.DataModelLike;
import com.example.twipee_sns.DataModel.DataModelSNS;
import com.example.twipee_sns.DataModel.DataModelUser;
import com.example.twipee_sns.DataModel.DataModelUserSetting;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentListAdapter extends ArrayAdapter<DataModelComment> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;

    private int temp = 0;

    public CommentListAdapter(@NonNull Context context, int resource, @NonNull List<DataModelComment> objects) {
        super(context, resource, objects);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource = resource;
        this.mContext = context;
    }

    static class ViewHolder{
        CircleImageView mprofileImage;
        TextView username, comment, timeDetla;
        ImageView like;
        boolean likeByCurrentUser;

        DataModelUserSetting DMuserSetting = new DataModelUserSetting();
        DataModelUser DMuser = new DataModelUser();
        DataModelLike DMLike = new DataModelLike();
        DataModelSNS DMSNS = new DataModelSNS();

        //String likesString;
        //StringBuilder users;
        //String mLikesString;
        //GestureDetector detector;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder commentHolder;

        if(convertView == null){
            convertView = mInflater.inflate(mLayoutResource, parent, false);
            commentHolder = new ViewHolder();

            commentHolder.mprofileImage = (CircleImageView) convertView.findViewById(R.id.iv_profile_photo);
            commentHolder.username = (TextView) convertView.findViewById(R.id.tv_username);
            commentHolder.like = (ImageView) convertView.findViewById(R.id.iv_like);
            commentHolder.comment = (TextView) convertView.findViewById(R.id.tv_comment);
            commentHolder.timeDetla = (TextView) convertView.findViewById(R.id.tv_commentCreated);

            convertView.setTag(commentHolder);
        }
        else{
            commentHolder = (ViewHolder) convertView.getTag();
        }

        commentHolder.mprofileImage.setOnClickListener(this);
        commentHolder.like.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_profile_photo:    //유저 페이지로 이동
                temp = 0;
                break;
            case R.id.iv_like:    //좋아요 누르기
                temp = 2;
                break;
            default:
                break;
        }
    }
}
