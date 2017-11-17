package cn.blog.bean;

import java.util.Date;

public class Token {
    private Integer tokenid;

    private String token;

    private Integer userid;

    private Date updatetime;

    private Date expiretime;

    public Token() {
    }

    public Token(String token, Integer userid, Date updatetime, Date expiretime) {
        this.token = token;
        this.userid = userid;
        this.updatetime = updatetime;
        this.expiretime = expiretime;
    }

    public Integer getTokenid() {
        return tokenid;
    }

    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }
}