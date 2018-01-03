package com.longqiu.learn.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

/**
 * Created by QIUJ003 on 2017/12/15.
 */
@Config.Sources({"classpath:application.properties"})
public interface ConfigCenter extends Config {
    @Key("server.port")
    @DefaultValue("")
    String getPort();

    @Key("com.longqiu.learn.author")
    @DefaultValue("")
    String getAuthor();

    @Key("com.longqiu.learn.title")
    @DefaultValue("")
    String getTitle();
}
