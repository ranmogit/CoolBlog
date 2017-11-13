package cn.blog.bean;

import java.util.Date;

public class Token {
    private Integer userid;

    private String token;

    private Date expiretime;

    private Date updatetime;

    public Token() {
    }

    public Token(Integer userid, String token) {
        this.userid = userid;
        this.token = token;
    }

    public Token(Integer userid, String token, Date expiretime, Date updatetime) {
        this.userid = userid;
        this.token = token;
        this.expiretime = expiretime;
        this.updatetime = updatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}