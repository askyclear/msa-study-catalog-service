### docker

docker build -t askyclear/user-service:1.0 .

docker run -d --network ecommerce-network \
-e "spring.cloud.config.uri=http://config-service:8888" \
-e "spring.rabbitmq.host=rabbitmq" \
-e "spring.zipkin.base-url=http://zipkin:9411" \
-e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" \
-e "logging.file=/api-logs/catalog-ws.log" \
--name catalog-service askyclear/catalog-service:1.0