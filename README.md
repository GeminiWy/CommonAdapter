# CommonAdapter
通用的RecyclerView的适配器
## 使用方式
### 1.1 创建自己的Adapter继承自CommonAdapter
### 1.2 创建自己的ViewHolder继承自CommonAdapter.CommonViewHolder
### 2.1 定义好CommonAdapter.CommonViewHolder的泛型（列表数据的类型）,例：
```
public class TestCommonViewHolder extends CommonAdapter.CommonViewHolder<String>{
……
}
```
### 2.2 定义好CommonAdapter的泛型（参数一：列表数据的类型；参数二：自己的ViewHolder）,例：
```
public class DemoTestCommonAdapter extends CommonAdapter<String,DemoTestCommonAdapter.TestCommonViewHolder>{
……
}
```

## 例子：
```
public class DemoTestCommonAdapter extends CommonAdapter<String,DemoTestCommonAdapter.TestCommonViewHolder> {


    public DemoTestCommonAdapter(Context context) {
        super(context);
    }

    public DemoTestCommonAdapter(Context context, List<String> testDatas) {
        super(context, testDatas);
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
```
