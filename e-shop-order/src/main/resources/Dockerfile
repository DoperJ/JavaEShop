#基于哪个镜像
FROM java:8

# 将本地文件夹挂载到当前容器
VOLUME /tmp

# 拷贝文件到容器，也可以直接写成ADD chu-eureka-0.0.1-SNAPSHOT.jar /app.jar
ADD e-shop-order-0.0.1.jar app.jar

RUN bash -c 'touch /app.jar'

#环境变量 设置上海时区
ENV TZ=Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 开放8083端口
EXPOSE 8083

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
