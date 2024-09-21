package com.leetcode.stackTest;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: DongShaowei
 * @create: 2024-09-21 15:52
 * @description: 简化路径
 */
public class T71SimplifiedPath {

    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Deque<String> resQueue = new ArrayDeque<>();


        for (String directory : directories) {
            if ("..".equals(directory)) {
                // 弹出最后一个，表示返回上一层
                if (resQueue.size() != 0) resQueue.pollLast();

            } else if (!".".equals(directory) && !"".equals(directory)) {
                resQueue.addLast(directory);
            }
        }
        if (resQueue.size() == 0) return "/";
        StringBuilder newPath = new StringBuilder();
        while (resQueue.size() != 0) {
            newPath.append("/").append(resQueue.pollFirst());
        }
        return newPath.toString();
    }

    @Test
    public void testSolution() {
        String path = "/a/../../b/../c//.//";
        System.out.println(simplifyPath(path));
    }
}
