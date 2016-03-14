7.1 查询所有列
-- 2.1 查询所有列
SELECT * FROM student;

7.2 查询指定列
-- 2.2 查询指定列
SELECT id,NAME FROM student;

7.3 查询时添加常量列
-- 2.4 查询时添加常量列
-- 需求： 在查询student表时添加一个班级列，内容为“java就业班”
SELECT id,NAME,"java就业班"  FROM student;
SELECT id,NAME,"java就业班" AS "年级" FROM student;

7.4 查询时合并列
-- 2.5 查询时合并列
-- 需求： 查询每个学生的servlet和jsp的总成绩
//前期修改
ALTER TABLE student ADD COLUMN servlet INT;
ALTER TABLE student ADD COLUMN jsp INT;
UPDATE student SET jsp=10 WHERE id=7;
//BEGIN
SELECT id,NAME,(servlet+jsp) FROM student WHERE id <>3;

7.5 查询时去除重复记录
-- 2.6 查询时去除重复记录(DISTINCT)
-- 需求： 查询学生的性别     男 女
前期准备：
ALTER TABLE student ADD COLUMN gender VARCHAR(2);
UPDATE student SET gender='男' WHERE id BETWEEN 2 AND 5;
UPDATE student SET gender='女' WHERE gender IS NULL;
开始：
SELECT gender FROM student;

SELECT DISTINCT gender FROM student;
7.6 条件查询
-- 2.7 条件查询(where)
-- 2.7.1 逻辑条件： and(与)     or(或)
-- 需求： 查询id为2，且姓名为李四的学生
SELECT * FROM student WHERE id=4 AND NAME='李一';
--需求： 查询id为2，或姓名为张三的学生
SELECT * FROM student WHERE id=2 OR NAME='王五';

-- 2.7.2 比较条件： >   <   >=  <=  =  <>(不等于)     between and (等价于>= 且 <=)
-- 需求： 查询servlet成绩大于70分的学生
SELECT * FROM student WHERE servlet>30;

-- 2.7.3 判空条件(null 空字符串)：  is null / is not null / =''  / <>''
-- 需求： 查询地址为空的学生（包括null和空字符串）
-- null vs  空字符串
-- null：表示没有值
-- 空字符串：有值的！
-- 判断null
INSERT INTO student VALUES(8,"",56,89,78,89,56,'男');
INSERT INTO student VALUES(9,"哈哈",NULL,89,78,89,56,'男');
SELECT id,math FROM student WHERE chinese IS NULL;
-- 判断空字符串
SELECT id,math FROM student WHERE NAME='';


-- 2.7.4 模糊条件： like
-- 通常使用以下替换标记：
-- % : 表示任意个字符
-- _ : 表示一个字符
-- 需求： 查询姓‘张’的学生
SELECT * FROM student WHERE NAME LIKE '王';
-- 需求： 查询姓‘王’，且姓名只有两个字的学生
SELECT * FROM student WHERE NAME LIKE '王_';
-- 需求： 查询姓‘王’，且姓名只有三个字的学生
SELECT * FROM student WHERE NAME LIKE '王__';
-- 需求： 查询姓‘王’，且姓名只有多个字的学生
SELECT * FROM student WHERE NAME LIKE '王%';


7.7 聚合查询
-- 2.8 聚合查询（使用聚合函数的查询）
-- 常用的聚合函数： sum()  avg()  max()  min()  count()
-- 需求：查询学生的jsp的总成绩 (sum() :求和函数)
SELECT SUM(jsp) FROM student WHERE id<2;
-- 需求： 查询学生的jsp的平均分(id<3)
SELECT AVG(jsp) AS 'jsp的平均分' FROM student WHERE id<3;
-- 需求: 查询当前servlet最高分
SELECT MAX(jsp)FROM student WHERE id<7;
-- 需求： 查询最低分
SELECT MIN(jsp)FROM student WHERE id<7;
-- 需求： 统计当前有多少学生(count(字段))
SELECT COUNT(*) FROM student;
SELECT COUNT(id) FROM student;
SELECT COUNT(chinese) FROM student;
-- 注意：count（）函数统计的数量不包含null的数据
-- 使用count统计表的记录数，要使用不包含null值的字段
7.8 分页查询
-- 2.9 分页查询（limit 起始行,查询几行）
-- 起始行从0开始
-- 分页：当前页  每页显示多少条
-- 分页查询当前页的数据的sql: SELECT * FROM student LIMIT (当前页-1)*每页显示多少条,每页显示多少条;
-- 需求： 查询第1,2条记录（第1页的数据）

SELECT * FROM student LIMIT 0,5
SELECT * FROM student LIMIT 5,1
7.9 查询排序
-- 2.10 查询排序（order by ）
-- 语法 ：order by 字段 asc/desc
-- asc: 顺序，正序。数值：递增，字母：自然顺序（a-z）
-- desc: 倒序，反序。数值：递减，字母：自然反序(z-a)
-- 默认情况下，按照插入记录顺序排序
SELECT * FROM student ORDER BY id DESC;

SELECT * FROM student ORDER BY id ;
SELECT * FROM student ORDER BY id ASC;
-- 注意：多个排序条件
-- 需求： 按照servlet正序，按照jsp的倒序

SELECT * FROM student ORDER BY servlet ASC,jsp DESC;

7.10 分组查询
-- 2.11 分组查询(group by)
-- 需求： 查询男女的人数
-- 预期结果：
--  男   3
-- 女   2
-- 1) 把学生按照性别分组(GROUP BY gender)
-- 2) 统计每组的人数(COUNT(*))
SELECT gender,COUNT(*) FROM student GROUP BY gender;





7.11 分组查询后筛选
-- 2.12 分组查询后筛选
-- 需求： 查询总人数大于2的性别
-- 1) 查询男女的人数
-- 2）筛选出人数大于2的记录(having)
--- 注意： 分组之前条件使用where关键字，分组之前条件使用having关键字

SELECT gender,COUNT(*) FROM student WHERE GROUP BY gender HAVING COUNT(*)>2;













SELECT * FROM student