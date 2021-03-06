package cn.blog.bean;

import java.util.Date;

public class Blog {
    private Integer blogid;

    private String title;

    private String label;

    private String content;

    private Date updatetime;

    private Integer userid;

    private Integer status;

    public Blog() {
    }

    public Blog(String title, String label, String content, Date updatetime, Integer userid, Integer status) {
        this.title = title;
        this.label = label;
        this.content = content;
        this.updatetime = updatetime;
        this.userid = userid;
        this.status = status;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}