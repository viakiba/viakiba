package com.viakiba.redis.step9;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: GEO（地理位置）
 * 			参考：Redis版本3.2
 * 				http://redisdoc.com/geo/index.html
 * 			GEOADD GEOPOS GEODIST GEORADIUS GEORADIUSBYMEMBER GEOHASH
 * @author viakiba
 * @date 2017年8月17日
 */
public class App24 {
	static interface RedisConfig {
		public final static String HOST = "viakiba.cn";
		public final static int PORT = 6379;
	}
	
	/**
	 * @description: 测试连接是否通过
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		//连接测试是否通过
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		System.out.println(jedis.ping());//pong则通过
		jedis.close();
	}
	
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		
	/*
		将给定的空间元素（纬度、经度、名字）添加到指定的键里面。 这些数据会以有序集合的形式被储存
		在键里面， 从而使得像 GEORADIUS 和 GEORADIUSBYMEMBER 这样的命令可以在之后通过位置查询取得这些元素。
		GEOADD 命令以标准的 x,y 格式接受参数， 所以用户必须先输入经度， 然后再输入纬度。
		GEOADD 能够记录的坐标是有限的： 非常接近两极的区域是无法被索引的。
		精确的坐标限制由 EPSG:900913 / EPSG:3785 / OSGEO:41001 等坐标系统定义， 具体如下：
			有效的经度介于 -180 度至 180 度之间。
			有效的纬度介于 -85.05112878 度至 85.05112878 度之间。
		当用户尝试输入一个超出范围的经度或者纬度时， GEOADD 命令将返回一个错误。
	*/
		//返回值：新添加到键里面的空间元素数量， 不包括那些已经存在但是被更新的元素。
//		Long geoadd = jedis.geoadd("Sicily", 13.361389, 38.115556, "Palermo");
//		Map<String,GeoCoordinate> sicilys = new HashMap<String,GeoCoordinate>();
//		sicilys.put("s1", new GeoCoordinate(13.361385, 38.115555));
//		sicilys.put("s2", new GeoCoordinate(13.361383, 37.115553));
//		Long geoadd2 = jedis.geoadd("Sicilys",sicilys);
//		
//		System.out.println(geoadd+":"+geoadd2);
		
		
		
//		从键里面返回所有给定位置元素的位置（经度和纬度）。
//		因为 GEOPOS 命令接受可变数量的位置元素作为输入， 所以即使用户只给定了一个位置元素，
//		命令也会返回数组回复。
//		返回值：
//			GEOPOS 命令返回一个数组， 数组中的每个项都由两个元素组成： 
//				第一个元素为给定位置元素的经度， 而第二个元素则为给定位置元素的纬度。
//				当给定的位置元素不存在时， 对应的数组项为空值。
//		List<GeoCoordinate> geopos = jedis.geopos("Sicily", "Palermo");
//		System.out.println(geopos);
		
		
	/*
		返回两个给定位置之间的距离。
		如果两个位置之间的其中一个不存在， 那么命令返回空值。
		指定单位的参数 unit 必须是以下单位的其中一个：
			m 表示单位为米。
			km 表示单位为千米。
			mi 表示单位为英里。
			ft 表示单位为英尺。
		===>如果用户没有显式地指定单位参数， 那么 GEODIST 默认使用m作为单位。
		GEODIST 命令在计算距离时会假设地球为完美的球形， 在极限情况下， 这一假设最大会造成 0.5% 的误差。
		返回值：
		计算出的距离会以双精度浮点数的形式被返回。 如果给定的位置元素不存在， 那么命令返回空值。
	*/
		Double geodist = jedis.geodist("Sicilys", "s1", "s2");
		System.out.println(geodist);
		jedis.close();
	}
}
