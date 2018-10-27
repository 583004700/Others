package com.sxt.t029.oracle;

public class Oracle {
    //创建表时指定分区（范围分区）
//    create table graderecord
//    (
//            sno varchar2(10),
//    sname varchar2(20),
//    dormitory varchar2(3),
//    grade int
//  )
//         8 partition by range(grade)
//  (
//         10   partition bujige values less than(60), --不及格
//   partition jige values less than(85), --及格
//   partition youxiu values less than(maxvalue) --优秀
//  )
    //查询分区数据
//    select * from graderecord;
// select * from graderecord partition(bujige);
// select * from graderecord partition(jige);
// select * from graderecord partition(youxiu);
    //查询用户分区
//    select * from user_tab_partitions
}
