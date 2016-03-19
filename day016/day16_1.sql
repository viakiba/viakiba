ALTER TABLE studebt RENAME TO student;-- 更名

ALTER TABLE student ADD COLUMN gender VARCHAR(2);-- 添加字段

ALTER TABLE student ADD COLUMN age INT;-- 添加字段

DESC student;-- 查看具体字段

ALTER TABLE student CHANGE COLUMN stu math INT; -- 更改字段

INSERT INTO student VALUES(1,'李四',32,'男',56);-- 插入数据
INSERT INTO student VALUES(2,'王五',45,'女',21);-- 插入数据
INSERT INTO student VALUES(3,'罗六',78,'男',43);-- 插入数据
INSERT INTO student VALUES(4,'小七',98,'女',43);-- 插入数据
INSERT INTO student VALUES(5,'王八',97,'女',32);-- 插入数据
INSERT INTO student VALUES(6,'小九',54,'男',36);-- 插入数据
INSERT INTO student VALUES(7,'龙九',78,'女',65);-- 插入数据
INSERT INTO student VALUES(8,'二保',89,'女',65);-- 插入数据
INSERT INTO student VALUES(9,'三杀',80,'男',43);-- 插入数据



SELECT * FROM student ORDER BY sid ASC;-- 查看效果





-- test 默认值
CREATE DATABASE day17;

USE day17;

CREATE TABLE test(
	id INT,
	sname VARCHAR(20),
	sgender VARCHAR(2) DEFAULT '男'
	)


INSERT INTO test(id,sname) VALUES(1,'张三');
INSERT INTO test VALUES(1,'张三',NULL);-- 说明插入数据可以为空

SELECT * FROM test;

-- 非空

CREATE TABLE test1(
	id INT,
	sname VARCHAR(20),
	sgender VARCHAR(2) NOT NULL -- 非空
	)

INSERT INTO test1(id,sname) VALUES (15,'张三');
INSERT INTO test1  VALUES (15,'张三',NULL);

SELECT * FROM test1;

-- 唯一
CREATE TABLE test2(
	id INT,
	sname VARCHAR(20),
	sgender VARCHAR(2) UNIQUE -- 唯一	
	）
	
INSERT INTO test2(id,sname,sgender) VALUES (15,'张三','nan');	
INSERT INTO test2(id,sname,sgender) VALUES (13,'张思','na');		


-- 主键
CREATE TABLE test3(
	id INT PRIMARY KEY,
	sname VARCHAR(20)	
	)	
INSERT INTO test3 VALUES (1,'haha');
INSERT INTO test3 VALUES (,'hoho')
INSERT INTO test VALUES (1,'papa');

-- 自增长
CREATE TABLE test4(
	age INT PRIMARY KEY AUTO_INCREMENT ,
	NAME VARCHAR(20)
	) -- Incorrect table definition; there can be only one auto column and it must be defined as a key
INSERT INTO test4(NAME) VALUES('张三');
INSERT INTO test4 VALUES(4,'张三');

DELETE FROM test4 WHERE age=4;	-- 不影响自增长约束
TRUNCATE TABLE test4 ;
	
-- 1.6 外键约束
-- 员工表
CREATE TABLE employee(
	id INT PRIMARY  KEY,
	empName VARCHAR(20),
	deptId INT,-- 把部门名称设置为id，链接 外键dept表
	-- 外键
	CONSTRAINT employee_dept_fk FOREIGN KEY(deptId) REFERENCES dept(id) ON UPDATE CASCADE ON DELETE CASCADE -- ON CASCADE UPDATE ：级联修改
	--          外键名                       外键           参考表（字段）                        
	)
DESC employee

CREATE TABLE dept(
	id INT PRIMARY KEY,
	deptNname VARCHAR(20)
	) 
DESC dept

INSERT INTO dept VALUES (1,'软件开发部');
INSERT INTO dept VALUES (2,'应用维护部');
INSERT INTO dept VALUES (3,'秘书部');

INSERT INTO employee VALUES(1,'张三',1);
INSERT INTO employee VALUES(2,'李四',1);
INSERT INTO employee VALUES(3,'王五',2);
INSERT INTO employee VALUES(4,'陈六',3);


INSERT INTO employee VALUES (5,'陈六',5);-- Cannot add or update a child row: a foreign key constraint fails


-- 1）当有了外键约束，添加数据的顺序： 先添加主表，再添加副表数据
-- 2）当有了外键约束，修改数据的顺序： 先修改副表，再修改主表数据
-- 3）当有了外键约束，删除数据的顺序： 先删除副表，再删除主表数据

UPDATE dept SET id=4 WHERE id=3;  -- dept 从表（副表）emplyee 主表

UPDATE employee SET deptId=2 WHERE id=4;

-- -----  ----- ---- -- --- --- 

DELETE FROM dept WHERE id=2; -- 级联删除

DELETE FROM employee WHERE deptId=2;

UPDATE dept SET id=2 WHERE id=1;

SELECT * FROM employee;
	
SELECT * FROM dept;

--  **************二、关联查询（多表查询）****************----
-- 需求：查询员工及其所在部门(显示员工姓名，部门名称)
-- 2.1 交叉连接查询（不推荐。产生笛卡尔乘积现象：4 * 4=16，有些是重复记录）

SELECT empName,deptNname FROM employee,dept;

-- 需求：查询员工及其所在部门(显示员工姓名，部门名称)
-- 多表查询规则：1）确定查询哪些表   2）确定哪些哪些字段   3）表与表之间连接条件 (规律：连接条件数量是表数量-1)
-- 2.2 内连接查询：只有满足条件的结果才会显示(使用最频繁)
SELECT empName,deptName       -- 2）确定哪些哪些字段
	FROM employee,dept    -- 1）确定查询哪些表
	WHERE employee.deptId=dept.id  -- 3）表与表之间连接条件
-- 其他形式（意义一样，同是内连接）
SELECT empName,deptNname
	FROM employee
	INNER JOIN dept
	ON employee.deptId=dept.id;

-- 使用别名
SELECT e.empName,d.deptNname
	FROM employee e
	INNER JOIN dept d
	ON e.deptId=d.id;


-- 需求： 查询每个部门的员工
-- 预期结果：
--  软件开发部  张三
--  软件开发部  李四
--  应用维护部  王五
--  秘书部      陈六
--  总经办      null 
-- 2.2 左[外]连接查询： 使用左边表的数据去匹配右边表的数据，如果符合连接条件的结果则显示，如果不符合连接条件则显示null
-- （注意： 左外连接：左表的数据一定会完成显示！）

INSERT INTO dept VALUES(5,'');
UPDATE dept SET deptNname='总经办' WHERE id=5;

SELECT e.empName,d.deptNname
FROM dept d
LEFT OUTER JOIN employee e
ON d.id=e.deptId;

-- 2.3 右[外]连接查询: 使用右边表的数据去匹配左边表的数据，如果符合连接条件的结果则显示，如果不符合连接条件则显示null
 -- （注意： 右外连接：右表的数据一定会完成显示！）
SELECT d.deptNname,e.empName
	FROM employee e
	RIGHT OUTER JOIN dept d
	ON d.id=e.deptId;

-- 添加上司ID
ALTER TABLE employee ADD bossId INT;
UPDATE employee SET bossId=1 WHERE id=2;
UPDATE employee SET bossId=2 WHERE id=3;
UPDATE employee SET bossId=3 WHERE id=4;
-- 2.4 自连接查询
-- 需求：查询员工及其上司
-- 预期结果：       
	-- 张三    null
	-- 李四    张三
	-- 王五    李四
	-- 陈六    王五
SELECT e.empName,b.empName
	FROM employee e 
	LEFT OUTER JOIN employee b
	ON e.bossId=b.id;

SELECT * FROM employee;
	
SELECT * FROM dept;

-- **************三、存储过程*******************-
-- 声明结束符
-- 创建存储过程

DELIMITER $
CREATE PROCEDURE pro_test
BEGIN
-- 可以写多个sql语句;
	SELECT * FROM employee;
END $

-- 执行存储过程
CALL pro_test();

-- 3.1 带有输入参数的存储过程
-- 需求：传入一个员工的id，查询员工信息
DELIMITER $
CREATE PROCEDURE pro_t(IN eid INT)
BEGIN
	SELECT * FROM employee WHERE id=eid;

END $

CALL pro_t(2);

-- 3.2 带有输出参数的存储过程

DELIMITER $
CREATE PROCEDURE prot(OUT str VARCHAR(20))
BEGIN
 SET str='hello';
END $

CALL prot;
-- 删除存储过程
DROP PROCEDURE pro_t;
-- 调用
-- 如何接受返回参数的值？？
-- ***mysql的变量******
--  全局变量（内置变量）：mysql数据库内置的变量 （所有连接都起作用）
        -- 查看所有全局变量： show variables
        -- 查看某个全局变量： select @@变量名
        -- 修改全局变量： set 变量名=新值
        -- character_set_client: mysql服务器的接收数据的编码
        -- character_set_results：mysql服务器输出数据的编码
--  会话变量： 只存在于当前客户端与数据库服务器端的一次连接当中。如果连接断开，那么会话变量全部丢失！
        -- 定义会话变量: set @变量=值
        -- 查看会话变量： select @变量
-- 局部变量： 在存储过程中使用的变量就叫局部变量。只要存储过程执行完毕，局部变量就丢失！！
-- 1)定义一个会话变量name, 2)使用name会话变量接收存储过程的返回值

CALL prot(@NAME);
-- 查看变量值
SELECT @NAME;
-- 3.3 带有输入输出参数的存储过程
DELIMITER $
CREATE PROCEDURE porte(INOUT ide INT)-- INOUT： 输入输出参数
BEGIN
 -- 查看变量
	SELECT ide;
	SET ide=30;
END $

SET @ide=10;
CALL porte(@ide)
SELECT @ide;

-- 3.4 带有条件判断的存储过程
-- 需求：输入一个整数，如果1，则返回“星期一”,如果2，返回“星期二”,如果3，返回“星期三”。其他数字，返回“错误输入”;
DELIMITER $
CREATE PROCEDURE proji(IN num INT,OUT str VARCHAR(20))
BEGIN
	IF num=1 THEN
	SET str='星期一';
	ELSEIF num=2 THEN
	SET str='星期二';
	ELSEIF num=3 THEN
		SET str='星期三';
	ELSE
		SET str='输入错误';
	END IF;

END $

CALL proji(1,@str);
SELECT @str;

-- 3.5 带有循环功能的存储过程
-- 需求： 输入一个整数，求和。例如，输入100，统计1-100的和
DELIMITER $
CREATE PROCEDURE pro_testWhile(IN num INT,OUT result INT)
BEGIN
	-- 定义一个局部变量
	DECLARE i INT DEFAULT 1;
	DECLARE vsum INT DEFAULT 0;
	WHILE i<=num DO
	      SET vsum = vsum+i;
	      SET i=i+1;
	END WHILE;
	SET result=vsum;
END $


DROP PROCEDURE pro_testWhile;


CALL pro_testWhile(100,@result);

SELECT @result;

-- 3.6 使用查询的结果赋值给变量（INTO）

DELIMITER $
CREATE PROCEDURE pro_findById2(IN eid INT,OUT vname VARCHAR(20) )
BEGIN
	SELECT empName INTO vname FROM employee WHERE id=eid;
END $

CALL pro_findById2(1,@NAME);

SELECT @NAME;
-- 练习： 编写一个存储过程 
-- 	如果学生的英语平均分小于等于70分，则输出'一般'
-- 	如果学生的英语平均分大于70分，且小于等于90分，则输出‘良好’
-- 	如果学生的英语平均分大于90分，则输出‘优秀’

DELIMITER $
CREATE PROCEDURE stu(IN avgs INT,OUT str VARCHAR(20))
BEGIN
	IF avgs<=70 THEN
		SET str='一般';
	ELSEIF avgs>70 AND avgs<=90 THEN
		SET str='良好';
	ELSE
		SET str='优秀';
	END IF;

END $

SET @str='默认';

CALL stu(80,@str);

SELECT @str;

-- ************四、触发器*****************
SELECT * FROM employee;

ALTER TABLE employee DROP COLUMN bossId;

-- 日志表
CREATE TABLE test_log(
	id INT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(100)
)
-- 需求： 当向员工表插入一条记录时，希望mysql自动同时往日志表插入数据
-- 创建触发器(添加)

-- INSERT INTO employee VALUES(6,'哈哈哈',2); 回顾

CREATE TRIGGER tri_empAdd AFTER INSERT ON employee FOR EACH ROW    -- 当往员工表插入一条记录时
     INSERT INTO test_log(content) VALUES('员工表插入了一条记录');

INSERT INTO employee VALUES(7,'哈哈哈',2);

SELECT * FROM test_log;

-- 创建触发器(修改)
CREATE TRIGGER tri_empUp AFTER UPDATE ON employee FOR EACH ROW
	INSERT INTO test_log(content) VALUES ('员工更新了一条数据');
	
UPDATE employee SET empName='hoho' WHERE id=4;

-- 创建触发器(删除)
CREATE TRIGGER test_empDel AFTER DELETE ON employee FOR EACH ROW
	INSERT INTO test_log(content) VALUES('员工删除了一条数据');

DELETE FROM employee WHERE id=4;

 -- ***********五、mysql权限问题****************
 -- mysql数据库权限问题：root ：拥有所有权限（可以干任何事情）
 -- 权限账户，只拥有部分权限（CURD）例如，只能操作某个数据库的某张表
 -- 如何修改mysql的用户密码？
 -- password: md5加密函数(单向加密)
 SELECT PASSWORD('root'); -- *81F5E21E35407D884A6CD4A731AEBFB6AF209E1B
 --  mysql数据库，用户配置 : user表
USE mysql;

SELECT * FROM USER;
-- 修改密码
UPDATE USER SET PASSWORD=PASSWORD('123456') WHERE USER='root';
-- 分配权限账户
GRANT SELECT ON day16.employee TO 'eric'@'localhost' IDENTIFIED BY '123456';
GRANT DELETE ON day16.employee TO 'eric'@'localhost' IDENTIFIED BY '123456';
 -- ****** 六，mysql备份和还原********
 
 
 
 
 