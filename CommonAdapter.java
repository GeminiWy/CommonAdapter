package com.wy.example.administrator.testeventdispatch.abAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wy.example.administrator.testeventdispatch.FirstAdapter;

import java.util.List;

public abstract class CommonAdapter<T,VH extends CommonAdapter.CommonViewHolder<T>> extends RecyclerView.Adapter implements CommonAdapterInterface<T>{
    private Context mContext;
    private List<T> mDatas;

    public CommonAdapter(Context context){
        this(context,null);
    }
    public CommonAdapter(Context context, List<T> testDatas) {
        this.mContext = context.getApplicationContext();
        this.mDatas = testDatas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //创建View的持有者
        return getViewHolder(LayoutInflater.from(mContext).inflate(getLayout(),viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //绑定View的持有者
        if (mDatas ==null) {
            return;
        }
        T eachData = mDatas.get(i);
        ((VH)viewHolder).bindData(eachData,i);
    }



    @Override
    public int getItemCount() {
        return mDatas ==null?0: mDatas.size();
    }


    public abstract int getLayout();
    public abstract VH getViewHolder(View itemView);

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public List<T> getData() {
        return mDatas;
    }

    @Override
    public void setDatas(List<T> datas) {
        this.mDatas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public void addDatas(List<T> datas) {
        if (datas==null) {
            return;
        }
        this.mDatas.addAll(datas);
        this.notifyDataSetChanged();
    }

   public static abstract class CommonViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener{
       private T data;
       private int position;

        public CommonViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.findView(itemView);
        }

        public void bindData(T data,int position){
            if (data == null) {
                return;
            }
            this.data = data;
            this.position = position;
            this.bindItemData(data,this.position);
        }

        @Override
        public void onClick(View v) {
            this.onItemClick(v,data,position);
        }


       public abstract void onItemClick(View v,T eachItemData,int position);
       public abstract void bindItemData(T eachItemData,int position);
       /**
        * 在这里做findViewById操作
        * @param itemView
        */
       public abstract void findView(View itemView);

    }
}
