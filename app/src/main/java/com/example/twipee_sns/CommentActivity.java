package com.example.twipee_sns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {

    //widget
    private CircleImageView iv_profile_photo;
    private ImageView iv_back;
    private EditText et_addComment;
    private Button btn_addComment;
    private TextView tv_title, tv_done;
    private ListView CommentListView;

    private CommentListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_done = (TextView) findViewById(R.id.tvDone);
        tv_done.setVisibility(View.GONE);
        CommentListView = (ListView) findViewById(R.id.CommentListView);
        iv_profile_photo = (CircleImageView) findViewById(R.id.iv_profile_photo);
        et_addComment = (EditText) findViewById(R.id.et_addComment);
        btn_addComment = (Button) findViewById(R.id.btn_addComment);
        CommentListView.setAdapter(adapter);

        iv_back.setOnClickListener(this);
        btn_addComment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backArrow:    //댓글창 끄기
                finish();
                break;
            case R.id.btn_addComment:    //댓글 달기
                break;
            default:
                break;
        }

    }
}
