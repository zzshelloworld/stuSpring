package com.zhangzhe.conditional;

public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {
        return "ls";
    }

}
