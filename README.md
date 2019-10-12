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
