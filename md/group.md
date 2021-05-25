### [�б�����ճ��ͷ��](https://github.com/AnliaLee/android-RecyclerViews/tree/master/library/src/main/java/com/anlia/library/group)
**GroupItemDecoration**���̳̲��ͣ�[���㿪ʼʵ��RecyclerView���鼰ճ��ͷ��Ч��](https://juejin.im/post/5a4551ce51882512d82305cb)��

![](https://user-gold-cdn.xitu.io/2017/12/29/160a15f16236cba8?w=208&h=300&f=gif&s=162696)

**SideGroupItemDecoration**

![](http://upload-images.jianshu.io/upload_images/4909537-e56a2587f6d07cee.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### ���ʹ��
**GroupItemDecoration��SideGroupItemDecoration��**Ŀǰֻ֧��**LinearLayoutManager.VERTICAL**���ͣ�ʹ����������
* ����[package com.anlia.library.group](https://github.com/AnliaLee/android-RecyclerViews/tree/master/library/src/main/java/com/anlia/library/group)·���µ��ļ��������Ŀ��
* **inflate**��д�õĲ���
```java
LayoutInflater layoutInflater = LayoutInflater.from(this);
View groupView = layoutInflater.inflate(R.layout.item_group,null);
```
* ����**recyclerView.addItemDecoration**���**GroupItemDecoration**��**SideGroupItemDecoration**
```java
GroupItemDecoration groupItemDecoration = new GroupItemDecoration(this, view, new GroupItemDecoration.DecorationCallback() {
	@Override
	public void setGroup(List<GroupItem> groupList) {
		//���÷��飬GroupItem(int startPosition)�����磺
		GroupItem groupItem = new GroupItem(0);
		groupItem.setData("name","��1��");
		groupList.add(groupItem);

		groupItem = new GroupItem(5);
		groupItem.setData("name","��2��");
		groupList.add(groupItem);
	}

	@Override
	public void buildGroupView(View groupView, GroupItem groupItem) {
		//����groupView��ͨ��groupView.findViewById�ҵ��ڲ��ؼ����ݲ�֧�ֵ���¼��ȣ�������
		TextView textName = (TextView) groupView.findViewById(R.id.text_name);
		textName.setText(groupItem.getData("name").toString());
	}
});
recyclerView.addItemDecoration(groupItemDecoration);
```
* ����**GroupItem����볤��**�¼�
```java
recyclerView.addOnItemTouchListener(new GroupItemClickListener(groupItemDecoration,new GroupItemClickListener.OnGroupItemClickListener() {
	@Override
	public void onGroupItemClick(GroupItem groupItem) {
		Toast.makeText(MainActivity.this, "�����Group:"+groupItem.getData("name"), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onGroupItemLongClick(GroupItem groupItem) {
		Toast.makeText(MainActivity.this, "������Group:"+groupItem.getData("name"), Toast.LENGTH_SHORT).show();
	}
}));
```
***
������ǲ��������ȥ����demo