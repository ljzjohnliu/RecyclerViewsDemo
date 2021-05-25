### [����ͶӰЧ��](https://github.com/AnliaLee/android-RecyclerViews/tree/master/library/src/main/java/com/anlia/library/header)

**TopProjectionDecoration**

![](http://upload-images.jianshu.io/upload_images/4909537-e3eb374299e1fa55.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### ���ʹ��
**TopProjectionDecoration**Ŀǰֻ֧��**LinearLayoutManager.VERTICAL**���ͣ�ʹ����������
* ����[package com.anlia.library.header](https://github.com/AnliaLee/android-RecyclerViews/tree/master/library/src/main/java/com/anlia/library/header)·���µ��ļ��������Ŀ��
* **inflate**��д�õĲ���
```java
LayoutInflater layoutInflater = LayoutInflater.from(this);
View groupView = layoutInflater.inflate(R.layout.item_top,null);
```
* ����**recyclerView.addItemDecoration**���**TopProjectionDecoration**
```java
TopProjectionDecoration decoration = new TopProjectionDecoration(this, view, new TopProjectionDecoration.DecorationCallback() {
	@Override
	public void buildHeaderView(View headerView, int position) {
		TextView textView = (TextView) headerView.findViewById(R.id.text_name);
		textView.setText(list.get(position));
	}
});
//decoration.isProjectionChange(false);//����ͶӰ�Ƿ����б������ı�
recyclerView.addItemDecoration(decoration);
```
* ����**HeaderView����볤��**�¼�
```java
recyclerView.addOnItemTouchListener(new TopProjectionClickListener(decoration, new TopProjectionClickListener.OnTopProjectionClickListener() {
	@Override
	public void onTopProjectionClick(View headerView, int position) {
		Toast.makeText(TopProjectionActivity.this, "�����Header����ӦpositionΪ��"+position, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTopProjectionLongClick(View headerView, int position) {
		Toast.makeText(TopProjectionActivity.this, "������Header����ӦpositionΪ��"+position, Toast.LENGTH_SHORT).show();
	}
}));
```
***
������ǲ��������ȥ����demo