package com.wy.example.administrator.testeventdispatch.abAdapter;

import android.content.Context;

import java.util.List;

public interface CommonAdapterInterface<T> {
    Context getContext();
    List<T> getData();
    void setDatas(List<T> datas);
    void addDatas(List<T> datas);
}
