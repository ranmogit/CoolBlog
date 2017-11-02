package cn.lxt.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liuwen on 2017/10/27.
 */


@ConfigurationProperties(prefix = "cn.lxt")
public class configBean {
    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
