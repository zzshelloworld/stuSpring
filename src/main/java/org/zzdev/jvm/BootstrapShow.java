package org.zzdev.jvm;

import java.net.URL;

public class BootstrapShow {
    // 查看bootstrap 所有已经加载的类库
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
