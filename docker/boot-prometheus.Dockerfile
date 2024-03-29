#该镜像需要依赖的基础镜像
#FROM fabric8/java-alpine-openjdk11-jre
FROM openjdk:8u302-jre
#调整时区
RUN rm -f /etc/localtime\
&& ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo "Asia/Shanghai" > /etc/timezone
# 将当前目录下的jar包复制到docker容器的/目录下
ADD boot-middleware/boot-prometheus/target/boot-prometheus.jar /app/boot-prometheus.jar
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","app/boot-prometheus.jar"]