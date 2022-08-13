/*
SPDX-FileCopyrightText: Copyright (c) 2022 Andrea Binello ("andbin")
SPDX-License-Identifier: MIT
*/

package dev.andbin.springboot.demo.service;

import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import dev.andbin.springboot.demo.model.AppInfo;

@Service
public class AppInfoService {
    private static final Logger logger = LoggerFactory.getLogger(AppInfoService.class);

    @Autowired
    private ServletContext servletContext;

    public AppInfo getAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setJavaRuntimeVersion(getJavaRuntimeVersion());
        appInfo.setSpringVersion(getSpringVersion());
        appInfo.setSpringBootVersion(getSpringBootVersion());
        appInfo.setPebbleVersion(getPebbleVersion());
        appInfo.setServerInfo(getServerInfo());
        return appInfo;
    }

    private String getJavaRuntimeVersion() {
        return Runtime.version().toString();   // Java 9+
    }

    private String getSpringVersion() {
        return SpringVersion.getVersion();
    }

    private String getSpringBootVersion() {
        return SpringBootVersion.getVersion();
    }

    private String getPebbleVersion() {
        // Note: this is the only way I found to get Pebble version ...
        Properties props = new Properties();

        try (var is = getClass().getResourceAsStream("/META-INF/maven/io.pebbletemplates/pebble/pom.properties")) {
            props.load(is);
        } catch (Exception e) {
            logger.error("Failed loading of Pebble pom.properties", e);
        }

        return props.getProperty("version");
    }

    private String getServerInfo() {
        return servletContext.getServerInfo();
    }
}
