# Spring Boot With Redis

Caching is crucial for building high-performance, scalable applications. 
It helps store frequently accessed data in the cache, reducing the need 
to access slower underlying storage systems like a database. Redis is a 
popular in-memory data structure store used as a cache, database, and 
message broker. Spring Boot seamlessly integrates with Redis for 
caching through its Spring Cache abstraction.

## Annotations to define cache behaviour

``` @EnableCaching ``` : Enables Spring's annotation-driven cache management.

``` @Cacheable ``` : Indicates that the method’s return value should be cached.

``` @CachePut ``` : Updates the cache without interfering with the method execution.

``` @CacheEvict ``` : Removes data from the cache.


