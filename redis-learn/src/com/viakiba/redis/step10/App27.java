package com.viakiba.redis.step10;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @description: 
 * 		Lua Script（脚本）
 * 			从 Redis 2.6.0 版本开始，通过内置的 Lua 5.1解释器，可以使用 EVAL 命令对 Lua 脚本进行求值。
 * 		参考：http://redisdoc.com/script/index.html
 * 		主要演示命令：EVAL,EVALSHA,SCRIPT EXISTS,SCRIPT FLUSH,SCRIPT KILL,SCRIPT LOAD
 * 				
 * @author viakiba
 * @date 2017年8月17日
 */
public class App27 {
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
	
	/**
	 * @description:EVAL/EVALSHA
	 * 		仅提供一个建议示范
	 * 		需要lua知识
	 * 			http://luadist.org/
	 * 		参考: 
	 * 			http://redisdoc.com/script/eval.html
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		/*
		 * EVAL:
		 * 		EVAL script numkeys key [key ...] arg [arg ...]
		 * 		numkeys 参数用于指定键名参数的个数。
		 * 		键名参数 key [key ...] 从 EVAL 的第三个参数开始算起，表示在脚本中所用到的那些 Redis 键(key)，
		 * 		这些键名参数可以在 Lua 中通过全局变量 KEYS 数组，用 1 为基址的形式访问( KEYS[1] ， KEYS[2] ，以此类推)。
		 * 		在命令的最后，那些不是键名参数的附加参数 arg [arg ...] ，可以在 Lua 中通过全局变量 ARGV 数组访问，
		 * 		访问的形式和 KEYS 变量类似( ARGV[1] 、 ARGV[2] ，诸如此类)。
		 */
		//java  执行  命令： eval "return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}" 2 k1 k2 a b
//		System.out.println(jedis.ping());
//		String str1 = "return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}";
//		Object eval1 = jedis.eval(str1, 2,"k1","k2","a1","a2");
//		System.out.println(eval1);
//		List a = (ArrayList) eval1;
//		System.out.println(a.get(1));
		
		
		
		/*
		  在 Lua 脚本中，可以使用两个不同函数来执行 Redis 命令，它们分别是：redis.call(),redis.pcall()
		  这两个函数的唯一区别在于它们使用不同的方式处理执行命令所产生的错误，在后面的『错误处理』部分会讲到这一点。
		 	redis.call()
		 		当 redis.call() 在执行命令的过程中发生错误时，脚本会停止执行，并返回一个脚本错误，错误的输出信息会说明错误造成的原因，例如：
		 			lpush foo2 a
		 			eval "return redis.call('get', 'foo2')" 0
		 			(error) ERR Error running script (call to f_9f940e4b715e855705c618305be7aeed2c4d
					572f): @user_script:1: WRONGTYPE Operation against a key holding the wrong kind
					of value
		 	redis.pcall()
		 		 redis.pcall() 出错时并不引发(raise)错误，而是返回一个带 err 域的 Lua 表(table)，用于表示错误,例如：
		 		 lpush foo3 a
		 		 EVAL "return redis.pcall('get', 'foo3')" 0
		 		 (error) WRONGTYPE Operation against a key holding the wrong kind of value
		 */
		//call
//		System.out.println(jedis.ping());
//		String str1 = "return redis.call('set',KEYS[1],'bar')";//设置键k1的值为bar
//		Object eval1 = jedis.eval(str1, 1,"k1");
//		System.out.println(eval1);
//		System.out.println(jedis.get("k1"));//查看执行情况
		
		//pcall
		System.out.println(jedis.ping());
		String str1 = "return redis.pcall('set',KEYS[1],'bar')";//设置键k1的值为bar
		Object eval1 = jedis.eval(str1, 1,"k1");
		System.out.println(eval1);
		System.out.println(jedis.get("k1"));//查看执行情况
		jedis.close();
	}
	
	/**
	 * @description: 
	 * 		EVALSHA
	 * 			根据给定的 sha1 校验码，对缓存在服务器中的脚本进行求值。
	 * 			将脚本缓存到服务器的操作可以通过 SCRIPT LOAD 命令进行。
	 * 			这个命令的其他地方，比如参数的传入方式，都和 EVAL 命令一样。
	 * 		SCRIPT LOAD:
	 * 			将脚本 script 添加到脚本缓存中，但并不立即执行这个脚本。
	 * 			EVAL 命令也会将脚本添加到脚本缓存中，但是它会立即对输入的脚本进行求值。
	 * 			如果给定的脚本已经在缓存里面了，那么不做动作。
	 * 			在脚本被加入到缓存之后，通过 EVALSHA 命令，可以使用脚本的 SHA1 校验和来调用这个脚本。
	 * 			脚本可以在缓存中保留无限长的时间，直到执行 SCRIPT FLUSH 为止。
	 * 		SCRIPT FLUSH:
	 * 			清除所有 Lua 脚本缓存。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.ping();
		//System.out.println(jedis.scriptLoad("return 'hello world'"));
		System.out.println(jedis.evalsha("5332031c6b470dc5a0dd9b4bf2030dea6d65de91",0));
		String scriptFlush = jedis.scriptFlush();
		System.out.println(scriptFlush);
//		System.out.println(jedis.evalsha("5332031c6b470dc5a0dd9b4bf2030dea6d65de91",0));//在执行就会报错了 因为所有 Lua 脚本缓存已经被清除了
		jedis.close();
	}
	
	/**
	 * @description: SCRIPT EXISTS
	 * 		给定一个或多个脚本的 SHA1 校验和，返回一个包含 0 和 1 的列表，表示校验和所指定的脚本是否已经被保存在缓存当中
	 * 例如：
	 * 	SCRIPT LOAD "return 'hello moto'"
	 *  SCRIPT EXISTS 232fd51614574cf0867b83d384a5e898cfd24e5a
	 *  SCRIPT FLUSH
	 *  SCRIPT EXISTS 232fd51614574cf0867b83d384a5e898cfd24e5a
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.ping();
		System.out.println(jedis.scriptLoad("return 'hello moto'"));
		System.out.println(jedis.scriptExists("232fd51614574cf0867b83d384a5e898cfd24e5a"));
		System.out.println(new String(jedis.scriptFlush()));
		System.out.println(jedis.scriptExists("232fd51614574cf0867b83d384a5e898cfd24e5a"));
		jedis.close();
	}
	
	/**
	 * @description: SCRIPT KILL
	 * 		杀死当前正在运行的 Lua 脚本，当且仅当这个脚本没有执行过任何写操作时，这个命令才生效。
	 * 		这个命令主要用于终止运行时间过长的脚本，比如一个因为 BUG 而发生无限 loop 的脚本，诸如此类。
	 * 		SCRIPT KILL 执行之后，当前正在运行的脚本会被杀死，执行这个脚本的客户端会从 EVAL 命令的阻塞当中退出，并收到一个错误作为返回值。
	 * 		另一方面，假如当前正在运行的脚本已经执行过写操作，那么即使执行 SCRIPT KILL ，也无法将它杀死，因为这是违反 Lua 脚本的原子性执行原则的。
	 * 		在这种情况下，唯一可行的办法是使用 SHUTDOWN NOSAVE 命令，通过停止整个 Redis 进程来停止脚本的运行，并防止不完整(half-written)的信息被写入数据库中。
	 * @author: viakiba
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Jedis jedis = new Jedis(RedisConfig.HOST,RedisConfig.PORT);
		jedis.ping();
		try{
			System.out.println(new String(jedis.scriptKill()));
			jedis.close();
			//成功杀死脚本时 返回ok
			//处理异常   NOTBUSY No scripts in execution right now.
		}catch(Exception e){
			e.printStackTrace();
		}
		jedis.close();
	}
}
