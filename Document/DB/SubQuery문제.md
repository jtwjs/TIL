1. 급여가 1000 이상인 사원들의 부서별 평균 급여를 출력해보세요 단, 부서별 평균 급여가 2000 이상인 부서만 출력하시오.

select avg(sal),deptno 
from emp
where sal>=1000
group by deptno
having avg(sal)>=2000;

2. 각 부서별 같은 업무(job)를 하는 사람의 인원수를 구해서 부서번호, 업무(job), 
인원수를 부서번호에 대해서 오름차순 정렬해서 출력시오.

select deptno,job,count(*)
from emp
group by deptno,job
order by deptno;

3. 부서별로, 업무별로 그룹을 지어서 부서번호, 업무, 인원수, 급여의 평균, 합계 구하시오.

select deptno,job,count(*),avg(sal),sum(sal)
from emp
group by deptno,job;

4. 부서별로 사원의 수가 4명 이상인 사원의 부서번호, 급여의 합계를 구하시오.

SELECT deptno,sum(sal)
from emp
group by deptno
having count(*)>=4;


5. emp테이블에서 직급이 SALESMAN이 아닌 사원에 대한 부서별로 급여의 합이
4000 이상인 부서의 정보를 출력하시오.(부서번호, 급여의 합계순으로)

select deptno,sum(sal)
from emp
where job<>'SALESMAN'
group by deptno
having sum(sal)>=4000;

6. emp테이블에서 전체 급여가 5000을 초과하는 각 업무에 대해서 업무와 월급여의 합계를 출력하시오
.(업무중에서 CLERK는 제외, 월급여의 합계로 내림차순)

select job,sum(sal)
from emp
where job <> 'CLERK'
group by job
order by sum(sal) desc;

7. EMP와 DEPT TABLE을 JOIN하여 부서 번호, 부서명, 이름, 급여를 출력하시오.

select dept.deptno,dept.dname,emp.ename,emp.sal
from emp,dept
where emp.deptno=dept.deptno;


8. 이름이 'ALLEN'인 사원의 부서명을 출력하시오.

select dept.dname
from emp,dept
where emp.ename='ALLEN' and emp.deptno=dept.deptno;

9. EMP Table의 데이터를 출력하되 해당사원에 대한 상관번호와 상관의 성명을 함께 출력하시오.

select A.*,B.empno 상관번호,B.ename 상관이름
from emp A, emp B
where A.mgr=B.empno;

10. 10번 부서에 근무하는 사원의 사원번호, 이름, 부서명, 지역, 급여를 급여가 많은 순으로 출력하시오.

select empno,ename,job,loc,sal
from emp,dept
where emp.deptno=10 and emp.deptno=dept.deptno
order by sal desc;

11. 사원번호,부서번호,부서명을 출력하세요 단, 사원이 근무하지 않는 부서명도 같이 출력하시오.

select emp.empno,emp.deptno,dname
from emp right outer join dept
ON emp.deptno = dept.deptno;

12. DEPT Table 에는 존재하는 부서코드이지만 해당부서에 근무하는 사람이 존재하지 않는 경우의 결과를 출력하시오.

-X모르겟다X-

13. 'ALLEN'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 출력하시오.

select ename,dname,sal,job
from emp,dept
where emp.deptno=dept.deptno and emp.job=( select job
                from emp
                where ename='ALLEN')
            and emp.ename<>'ALLEN';


14. 'JONES'가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일자, 급여를 출력하시오.

select emp.deptno,emp.ename,emp.hiredate,emp.sal
from emp,dept
where emp.deptno= (select deptno
                    from emp
                    where ename='JONES');
                

15. 전체 사원의 평균 임금보다 많은 사원의 사우너번호, 이름, 부서명, 입사일, 지역, 급여를 출력하시오.

select empno,ename,dname,hiredate,loc,sal
from emp,dept
where sal>(select avg(sal)
                from emp)
                and emp.deptno=dept.deptno;


16. 10번 부서 사람들 중에서 20번 부서의 사원과 같은 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 출력하시오.

select empno,ename,dname,hiredate,loc
from emp A,dept B
where A.deptno=10 and A.deptno =B.deptno and A.job IN ( select job
                                from emp
                                where deptno=20);

17. 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일자, 지역을 출력하시오.

select empno,ename,dname,hiredate,loc,emp.deptno
from emp,dept
where emp.deptno=10 and emp.deptno=dept.deptno and emp.job not in(select job
from emp where deptno=30);


18. 'MARTIN'이나 'SCOTT'의 급여와 같은 사원의 사원번호, 이름, 급여를 출력하시오.

select empno,ename,sal
from emp
where sal in(select sal
                from emp
                where ename='MARTIN' or ename='SCOTT')
                and ename not in('MARTIN','SCOTT');

19. 30번 부서의 사원중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력하시오.

1)
select ename,sal
from emp
where sal > (select max(sal)
                from emp
                where deptno=30);
2)
select ename,sal
from emp
where sal >any (select max(sal)
                from emp
                where deptno=30);


20. 부서번호가 30번인 사원들의 급여중 최저 급여보다 높은 급여를 받는 사원의 이름, 급여를 출력하시오.

select ename,sal
from emp
where sal >( select min(sal)
            from emp
            where deptno=30);
21. 'DALLAS' 에서 근무하는 사원의 이름, 부서번호를 출력하시오.

select ename,emp.deptno,loc
from emp,dept
where dept.loc =ALL ( select loc
                        from dept
                        where loc='DALLAS')
                        and emp.deptno=dept.deptno;

22. 급여를 3000 이상받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 이름과 급여, 부서번호를 출력하시오.

select ename,sal,emp.deptno
from emp,dept
where emp.deptno in ( select deptno
                from emp
                where sal>=3000
group by deptno
);

23. IN 연산자를 이용하여 부서별로 가장 급여를 많이 받는 사원의 사원번호, 급 여, 부서번호를 출력하시오.

select deptno ,empno,sal
from emp
where  sal IN (select  max(sal)
                from emp
                group by deptno);

24. 30번 부서의 사원중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력하시오.

select ename, sal
from emp
where sal >(select max(sal)
                from emp
                where deptno=30);


