package com.example.twipee_sns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.twipee_sns.DataModel.DataModelLike;
import com.example.twipee_sns.DataModel.DataModelSNS;
import com.example.twipee_sns.DataModel.DataModelUser;
import com.example.twipee_sns.DataModel.DataModelUserSetting;
import com.example.twipee_sns.utill.SquareImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SNSListAdapter extends ArrayAdapter<DataModelSNS> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private Intent intent;
    private String currentUsername = "";

    private int temp = 0;

    public SNSListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DataModelSNS> objects) {
        super(context, resource, objects);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutResource = resource;
        this.mContext = context;
    }

    static class ViewHolder{
        CircleImageView mprofileImage;
        TextView username, caption, likes, moreContent, timeDetla;

        SquareImageView image;
        ImageView more, tripticonFill, tripticonEmpty, comment;
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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        if(convertView == null){
            convertView = mInflater.inflate(mLayoutResource, parent, false);
            holder = new ViewHolder();

            holder.mprofileImage = (CircleImageView) convertView.findViewById(R.id.iv_profile_photo);
            holder.username = (TextView) convertView.findViewById(R.id.tv_username);
            holder.more = (ImageView) convertView.findViewById(R.id.iv_more);
            holder.image = (SquareImageView) convertView.findViewById(R.id.iv_post);
            holder.tripticonFill = (ImageView) convertView.findViewById(R.id.iv_tripticon_fill);
            holder.tripticonEmpty = (ImageView) convertView.findViewById(R.id.iv_tripticon_empty);
            holder.comment = (ImageView) convertView.findViewById(R.id.speech_bubble);
            holder.likes = (TextView) convertView.findViewById(R.id.tv_likes);
            holder.caption = (TextView) convertView.findViewById(R.id.tv_caption);
            holder.moreContent = (TextView) convertView.findViewById(R.id.tv_moreContent);
            holder.timeDetla = (TextView) convertView.findViewById(R.id.tv_time_posted);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mprofileImage.setOnClickListener(this);
        holder.more.setOnClickListener(this);
        holder.tripticonEmpty.setOnClickListener(this);
        holder.comment.setOnClickListener(this);
        holder.likes.setOnClickListener(this);
        holder.moreContent.setOnClickListener(this);

        //프로필 사진 설정
        //유저 네임 설정
        //SNS ImageView 채우기


        return convertView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_profile_photo:    //유저 페이지로 이동
                temp = 0;
                break;
            case R.id.iv_more:    //수정/삭제 등 다이얼로그 띄우기
                temp = 1;
                break;
            case R.id.iv_tripticon_empty:    //좋아요 누르기
                temp = 2;
                break;
            case R.id.speech_bubble:    //댓글창으로 이동
                intent = new Intent(view.getContext(), CommentActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_likes:    //좋아요 누른 사람 목록창으로 이동
                temp = 4;
                break;
            case R.id.tv_moreContent:    //더보기 눌러서 내용 더보기
                temp = 5;
                break;
            default:
                break;
        }
    }

}
