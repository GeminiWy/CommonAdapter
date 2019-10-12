package com.wy.example.administrator.testeventdispatch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wy.example.administrator.testeventdispatch.abAdapter.CommonAdapter;

import java.util.List;

public class DemoTestCommonAdapter extends CommonAdapter<String,DemoTestCommonAdapter.TestCommonViewHolder> {


    public DemoTestCommonAdapter(Context context) {
        super(context);
    }

    public DemoTestCommonAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.test_common_adapter_item;
    }

    @Override
    public TestCommonViewHolder getViewHolder(View itemView) {
        return new TestCommonViewHolder(itemView);
    }

    public class TestCommonViewHolder extends CommonAdapter.CommonViewHolder<String>{
        private TextView mTextView;

        public TestCommonViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(View v, String eachItemData, int position) {
            Toast.makeText(getContext(), "this is position:"+position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void bindItemData(String eachItemData, int position) {
            mTextView.setText(eachItemData);
        }

        @Override
        public void findView(View itemView) {
            mTextView = itemView.findViewById(R.id.tv_item);
        }
    }
}
