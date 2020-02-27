package com.example.twipee_sns;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eschao.android.widget.elasticlistview.ElasticListView;
import com.eschao.android.widget.elasticlistview.LoadFooter;
import com.eschao.android.widget.elasticlistview.OnLoadListener;
import com.eschao.android.widget.elasticlistview.OnUpdateListener;
import com.example.twipee_sns.DataModel.DataModelUserSetting;

import java.util.ArrayList;

public class SNSView extends Fragment implements OnUpdateListener, OnLoadListener, View.OnClickListener{

    //widget
    private EditText et_feedSearchBox;
    private Button btn_feedSearch;
    private TextView tv_favorite;
    private ElasticListView SNSListView;

    private SNSListAdapter adapter;
    private Intent intent;
    private int resultsCount = 0;
    private ArrayList<DataModelUserSetting> DMUserSetting;

    public SNSView() {
        // Required empty public constructor
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onUpdate() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snsview, container, false);
        btn_feedSearch = (Button) view.findViewById(R.id.btn_feedSearch);
        tv_favorite = (TextView) view.findViewById(R.id.tv_favorite);
        btn_feedSearch.setOnClickListener(this);
        tv_favorite.setOnClickListener(this);
        SNSListView = (ElasticListView) view.findViewById(R.id.SNSListView);
        initListViewRefresh();

        return view;
    }

    private void initListViewRefresh(){
        SNSListView.setHorizontalFadingEdgeEnabled(true);
        SNSListView.setAdapter(adapter);
        SNSListView.enableLoadFooter(true)
                .getLoadFooter().setLoadAction(LoadFooter.LoadAction.RELEASE_TO_LOAD);
        SNSListView.setOnUpdateListener(this).setOnLoadListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_feedSearch:
                intent = new Intent(getActivity(), SNSSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_favorite:
                intent = new Intent(getActivity(), FavoriteActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


}
