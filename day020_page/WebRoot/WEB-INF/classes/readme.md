#分页技术项目联系
###0.准备工作
###.	环境准备
####a.	引入jar文件及引入配置文件
	1.	数据库驱动包
	2.	C3P0连接池jar文件 及 配置文件
	3.	DbUtis组件:    QueryRunner qr = new QueryRuner(dataSouce);
	4).		qr.update(sql);
####b.公用类: JdbcUtils.java
###1.	先设计：PageBean.java
###2.	Dao接口设计/实现：   2个方法
###3.	Service/servlet
###4.	JSP
