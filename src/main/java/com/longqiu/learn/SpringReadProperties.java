package com.longqiu.learn;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by QIUJ003 on 2017/12/15.
 */
@PropertySource(value={"classpath:application.properties"})
@ConfigurationProperties(prefix = "test")
@Component
public class SpringReadProperties {

    private String port;
    private String siteName;

    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getSiteName() {
        return siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    @Override
    public String toString() {
        return "SpringReadProperties{" +
                "port='" + port + '\'' +
                ", siteName='" + siteName + '\'' +
                '}';
    }
}
