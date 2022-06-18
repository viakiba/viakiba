package main

import (
	"context"
	"time"

	"github.com/gin-gonic/gin"
	redis "github.com/go-redis/redis/v9"
)

func main() {
	// host.docker.internal 这个 地址 是 docker的一个特性，可以访问宿主机端口。
	// 直连宿主机
	// rdb := redis.NewClient(&redis.Options{
	// 	Addr:     "host.docker.internal:6380",
	// 	Password: "", // no password set
	// 	DB:       0,  // use default DB
	// })

	// 连接redis容器（非直连宿主机）
	// docker network inspect bridge
	// Containers 标签下 redis 对应的 ip 地址 172 开头
	// rdb := redis.NewClient(&redis.Options{
	// 	Addr:     "172.17.0.3:6379",
	// 	Password: "", // no password set
	// 	DB:       0,  // use default DB
	// })

	// redisnet
	// docker run -d --name redis-test-net --network test-redis-net --network-alias redisnet redis:latest
	// --network-alias 声明的别名
	rdb := redis.NewClient(&redis.Options{
		Addr:     "redisnet:6379",
		Password: "", // no password set
		DB:       0,  // use default DB
	})

	sc := rdb.Ping(context.Background())
	print(sc)
	r := gin.New()
	r.GET("/ping", func(c *gin.Context) {

		c.JSON(200, gin.H{
			"message": "pong",
		})
	})

	r.GET("/setRedisKey", func(c *gin.Context) {
		rdb.Set(context.Background(), "key1", "value111", 10*time.Second)
		c.JSON(200, gin.H{
			"message": "pong1",
		})
	})

	r.GET("/getRedisKey", func(c *gin.Context) {
		value := rdb.Get(context.Background(), "key1")
		println(value.String())
		c.JSON(200, gin.H{
			"message": "pong2",
		})
	})

	r.Run(":8001") // listen and serve on
}
