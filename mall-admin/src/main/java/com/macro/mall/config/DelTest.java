package com.macro.mall.config;

import com.macro.mall.domain.WorkerDistance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 一些测试方法
 *
 * @author Paradise
 */
public class DelTest {
    public static void main(String[] args) {
        String targetLocation = "";
        List<WorkerDistance> list = new ArrayList<>();
        list.add(new WorkerDistance(1L, "", new BigDecimal("20")));
        list.add(new WorkerDistance(1L, "", new BigDecimal("200")));
        list.add(new WorkerDistance(1L, "", new BigDecimal("2")));
        System.out.println(list);
        list.sort(WorkerDistance::compareTo);
        System.out.println(list);

        List<WorkerDistance> list2 = new ArrayList<>();
        list2.add(new WorkerDistance(2L, "", new BigDecimal("30")));
        list2.add(new WorkerDistance(2L, "", new BigDecimal("3")));
        list2.add(new WorkerDistance(2L, "", new BigDecimal("300")));
        list2.sort(WorkerDistance::compareTo);

        list.addAll(list2);
        System.out.println(list);
    }
}
