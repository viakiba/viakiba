package com.redis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTx {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("viakiba.cn");
		int balance;// 可用余额
	    int debt;// 欠额
	    int amtToSubtract = 40;// 实刷额度
		jedis.watch("balance");
		balance = Integer.parseInt(jedis.get("balance"));
		if(balance < amtToSubtract){
			jedis.unwatch();
			System.out.println("余额剩余不足");
		}else{
			
			Transaction multi = jedis.multi();
			multi.decrBy("balance", amtToSubtract);
			multi.exec();
			System.out.println("余额扣除结束");
		}
	}
}
