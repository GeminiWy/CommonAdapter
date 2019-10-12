# CommonAdapter
通用的RecyclerView的适配器，只要实现几个暴露出来的方法就可轻松实现列表布局。
## 使用方式
### 1.1 创建自己的Adapter继承自CommonAdapter
### 1.2 创建自己的ViewHolder继承自CommonAdapter.CommonViewHolder
### 2.1 定义好CommonAdapter.CommonViewHolder的泛型（列表数据的类型）,实现几个必须实现的方法，例：
```
public class TestCommonViewHolder extends CommonAdapter.CommonViewHolder<String>{
        public TestCommonViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
        * 每个item的点击事件
        * @param v itemView
        * @param eachItemData 列表数据集合的position位置的数据
        * @param position 点击的position
        */
        @Override
        public void onItemClick(View v, String eachItemData, int position) {
            
        }

        /**
        * 绑定视图数据
        * @param eachItemData 列表数据集合的position位置的数据
        * @param position 绑定的是哪个位置的viewHolder
        */
        @Override
        public void bindItemData(String eachItemData, int position) {
        }

        /**
        * 在这里做findViewById操作
        * @param itemView 
        */
        @Override
        public void findView(View itemView) {
            mTextView = itemView.findViewById(R.id.tv_item);
        }
}
```
### 2.2 定义好CommonAdapter的泛型（参数一：列表数据的类型；参数二：自己的ViewHolder）,实现必须实现的几个方法，例：
```
public class DemoTestCommonAdapter extends CommonAdapter<String,DemoTestCommonAdapter.TestCommonViewHolder>{
public DemoTestCommonAdapter(Context context) {
        super(context);
    }

    public DemoTestCommonAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    /**
     * 返回layout的resId，例：R.layout.test
     * @return
     */
    @Override
    public int getLayout() {
    }

     /**
     * 返回继承自{@link CommonViewHolder}的自定义ViewHolder
     * @param itemView
     * @return
     */
    @Override
    public TestCommonViewHolder getViewHolder(View itemView) {
    }
}
```

## 例子：
```
// 自己的Adapter，列表数据的类型为String
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

    // 自己的ViewHolder
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
