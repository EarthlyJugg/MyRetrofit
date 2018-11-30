package com.lingtao.myretrofit;

public class News  {


    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
//
//    @Override
//    public int getItemType() {
//        return 0;
//    }
//
//    @Override
//    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.d("nongyulian", "22222222222222");
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_layout, parent, false);
//        return new RVBaseViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
//        holder.setText(R.id.time, "2018:02:101111");
////        holder.setText(R.id.content, "随便什么东兴随便什么东兴随便什么东兴随便随便什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴随便什么东兴");
//    }
}
