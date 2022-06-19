package main

import (
	"context"
	"time"

	"github.com/gin-gonic/gin"
	redis "github.com/go-redis/redis/v9"
)

func main() {
	rdb := redis.NewClient(&redis.Options{
		Addr:     "redis:6379",
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
