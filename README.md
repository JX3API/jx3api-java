# jx3api-java
The Java SDK to the JX3API.

使用说明 

1、需要先本地安装一下，方便通过pom引入
```
mvn clean install -DskipTests
```
2、在pom.xml中引入
```
<dependency>
    <groupId>org.jx3api</groupId>
    <artifactId>jx3-api-autoconfigure</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>            
```
3、实现`jx3api.api.ws.IWsDataPushService`该接口

4、在启动类添加相关注解
```
// 其中 jx3api.api 是配置扫描路径
@ComponentScan(basePackages = {"jx3api.api","com.example.demo"})

// 下列三个Enable注解，可以看需使用，EnableJX3Api包含后续三个
@EnableJX3Api
@EnableJX3ApiWS
@EnableJX3ApiHttp

```