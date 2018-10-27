package com.sxt.t025.oracle;

public class Oracle {
//    --递归查下级
//    select * from emp
//    start with empno = 7839
//    connect by prior empno = mgr;
//
//--递归查上级
//    select * from emp
//    start with empno = 7839
//    connect by prior mgr = empno;
//
//    select deptno,ename,sal,
//    sum(sal) over (order by deptno) 连续求和,
//    sum(sal) over() 总和,
//            100*round(sal/sum(sal) over(),5) "份额(%)"
//    from emp;
//
//--分区求和
//    select deptno,ename,sal,
//    sum(sal) over (partition by deptno order by ename) 部门连续求和,
//    sum(sal) over (partition by deptno) 部门求和,
//    avg(sal) over (partition by deptno) 部门平均,
//    sum(sal) over (order by deptno,ename) 连续求和,
//    sum(sal) over() 总和
//    from emp;
//
//    select e.*,Row_Number() over (partition by deptno order by sal desc) rank from emp e;
//--并列排名会跳跃 11345
//    select e.*,Rank() over (partition by deptno order by sal desc) rank from emp e;
//--并列排名不会跳跃 11234
//    select e.*,dense_rank() over (partition by deptno order by sal desc) rank from emp e;
//--小计
//    select deptno,job,sum(sal) from emp e group by rollup (deptno,job)
//--分别小计
//    select deptno,job,sum(sal) from emp e group by cube (deptno,job)
//
//--本身的返回0 总计的返回1
//    select deptno,
//(
//        case when ((grouping(deptno) = 0) and (grouping(job) = 1)) then '部门小计'
//    when ((grouping(deptno) = 1) and (grouping(job) = 1)) then '总计'
//            else job
//            end
//) as job,
//    sum(sal)
//    from emp e group by rollup (deptno,job)
//
//    select * from emp;

}
