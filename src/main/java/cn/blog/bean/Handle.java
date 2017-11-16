package cn.blog.bean;

public class Handle {
    private Integer handleid;

    private String handle;

    public Handle() {
    }

    public Handle(String handle) {
        this.handle = handle;
    }

    public Integer getHandleid() {
        return handleid;
    }

    public void setHandleid(Integer handleid) {
        this.handleid = handleid;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }
}