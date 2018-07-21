package com.viakiba.redis.step10;

import java.util.List;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @description: Transaction（事务）
 * 				DISCARD，EXEC，MULTI，UNWATCH，WATCH
 * @author viakiba
 * @date 2017年8月17日
 */
public class App26 {
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
	
	//知识准备
	/*
	 参考：http://redisdoc.com/transaction/index.html
	 DISCARD:
	 	取消事务，放弃执行事务块内的所有命令。
	 	如果正在使用 WATCH 命令监视某个(或某些) key，那么取消所有监视，等同于执行命令 UNWATCH 。
	 EXEC:
		 执行所有事务块内的命令。
		 假如某个(或某些) key 正处于 WATCH 命令的监视之下，且事务块中有和这个(或这些) key
		 相关的命令，那么 EXEC 命令只在这个(或这些) key 没有被其他命令所改动的情况下执行并
		 生效，否则该事务被打断(abort)。
	 MULTI:
	 	标记一个事务块的开始。
	 	事务块内的多条命令会按照先后顺序被放进一个队列当中，最后由 EXEC 命令原子性(atomic)地执行。
	 UNWATCH:
	 	取消 WATCH 命令对所有 key 的监视。
		如果在执行 WATCH 命令之后， EXEC 命令或 DISCARD 命令先被执行了的话，
		那么就不需要再执行 UNWATCH 了。
		因为 EXEC 命令会执行事务，因此 WATCH 命令的效果已经产生了；而 DISCARD 
		命令在取消事务的同时也会取消所有对 key 的监视，因此这两个命令执行之后，就没有必要执行 UNWATCH 了。
	 WATCH:
	 	监视一个(或多个) key ，如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断。
	 */
	
	/**
	 * @description: 接下来演示一个事务进行操作的步骤
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
//		jedis.set("k", "100");
		jedis.set("k", "100");
		
		System.out.println("数据准备完成");
		jedis.watch("k");
		int k = Integer.parseInt(jedis.get("k"));
		
		if(k<50){
			jedis.unwatch();
			System.out.println("k值小于50");
			jedis.close();
			return;
		}
		Transaction multi = jedis.multi();
		System.out.println(multi.ping());
		multi.decrBy("k", 50);
		multi.ping();
		List<Object> exec = multi.exec();
		for(Object str : exec){
			System.out.println(str);
		}
		System.out.println("削减结束");
		jedis.close();
	}
}
