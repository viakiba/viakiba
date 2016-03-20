CREATE DATABASE test1;

-- 要求 --
-- 需求：
-- 	1）一个工程可以由多个职工负责
-- 	2）一个职工可以负责多个工程
-- 	3）职工的工资率由职务决定

-- 工程职工工时表
--       工程号  工程名称  职工号  姓名  职务  薪水 工时

-- 工程表：
-- 	工程ID  工程号  工程名称 
--           1             花园酒店   
--           2             立交桥     	

-- 职工表：
-- 	职工ID 职工号  姓名  职务ID 
--           1      1    张三                
--           2      2    李四

-- 职务表：
-- 	职务ID  职务名称  薪水

-- 中间表（工程职工表）
-- 	 职工ID  工程ID   工时 
--          1      1        13
--          1      2        20
--          2      1
--          2      2

-- ************** 开始  **************
USE test1;
-- 职务表
CREATE TABLE employee_zw(
	zwId INT,
	ezwName VARCHAR(20),
	zwCl INT
	)
	
-- 职工表
CREATE TABLE zg(
	zgId INT,
	zgH INT,
	zgName VARCHAR(20),
	zwId INT
	)

-- 工程表
CREATE TABLE gc(
	gcId INT,
	gch INT,
	gcName VARCHAR(20)
	)

-- 工程职工工时表
CREATE TABLE gs(
	gsId INT,
	gcName VARCHAR(20),
	zwId INT,
	zgName VARCHAR(20),
	zuCl INT,
	gs INT
	)

-- 工程职工表
CREATE	TABLE gcz(
	zwId INT,
	gcId INT,
	gs INT
	)
	

