package com.atguigu.join;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TableJoinDemo {
    // 学生表 姓名 班级编号
    public static final String[] student_relation = new String[]{
            "xiaowang 1",
            "xiaoli 2",
            "zhangsan 2",
            "wangwu 1",
    };

    // 班级表 班级名 班级编号
    public static final String[] class_relation = new String[]{
            "A001 1",
            "A002 2",
            "A003 3",
    };

    public static void main(String[] args) {
        // 每张表加一个字段 —— 表名
        Stream<String> students = Arrays.stream(student_relation).map(s -> s + " student_relation");
        Stream<String> classes = Arrays.stream(class_relation).map(s -> s + " class_relation");

        // 两张表合并
        Stream<String> combined = Stream.concat(students, classes);

        // 按照共同字段分组，即”班级编号“
        combined.collect(Collectors.groupingBy(s -> s.split(" ")[1]))
                // 找到每组的班级名，然后把学生记录中班级编号改为班级名
                .values().stream().map(list -> {
            String className = list.stream().filter(s -> s.split(" ")[2].equals("class_relation")).findAny().orElse("").split(" ")[0];
            return list.stream().map(s -> s.split(" ")[0] + " " + className + " " + s.split(" ")[2]).collect(Collectors.toList());
        })
                // 把每组的 value，即 string 数组展开
                .flatMap(Collection::stream)
                // 把学生的班级编号替换为班级名
                // 过滤，只需要学生信息
                .filter(s -> s.split(" ")[2].equals("student_relation"))
                // 取出姓名和班级名
                .map(s -> s.split(" ")[0] + " " + s.split(" ")[1])
                .forEach(System.out::println);

    }
}

