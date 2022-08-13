/*
SPDX-FileCopyrightText: Copyright (c) 2022 Andrea Binello ("andbin")
SPDX-License-Identifier: MIT
*/

package dev.andbin.springboot.demo.model;

public class AppInfo {
    private String javaRuntimeVersion;
    private String springVersion;
    private String springBootVersion;
    private String pebbleVersion;
    private String serverInfo;

    public String getJavaRuntimeVersion() {
        return javaRuntimeVersion;
    }

    public void setJavaRuntimeVersion(String javaRuntimeVersion) {
        this.javaRuntimeVersion = javaRuntimeVersion;
    }

    public String getSpringVersion() {
        return springVersion;
    }

    public void setSpringVersion(String springVersion) {
        this.springVersion = springVersion;
    }

    public String getSpringBootVersion() {
        return springBootVersion;
    }

    public void setSpringBootVersion(String springBootVersion) {
        this.springBootVersion = springBootVersion;
    }

    public String getPebbleVersion() {
        return pebbleVersion;
    }

    public void setPebbleVersion(String pebbleVersion) {
        this.pebbleVersion = pebbleVersion;
    }

    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "["
                + "javaRuntimeVersion=" + javaRuntimeVersion + ", "
                + "springVersion=" + springVersion + ", "
                + "springBootVersion=" + springBootVersion + ", "
                + "pebbleVersion=" + pebbleVersion + ", "
                + "serverInfo=" + serverInfo
                + "]";
    }
}
