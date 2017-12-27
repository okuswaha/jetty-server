# jetty-server
[https://maven.apache.org/archetypes-archives/maven-archetype-quickstart-LATEST/]


running apache mq as a docker container for testing
---------------------	
``
docker run --name='activemq' -it --rm -d -e 'ACTIVEMQ_ADMIN_LOGIN=admin' -e 'ACTIVEMQ_ADMIN_PASSWORD=apple123' -p 8161:8161 -p 61616:61616 -p 61613:61613 webcenter/activemq:latest
docker exec -it 0b51d8e0f2d9289efcd9b22c363f6b1b85efbf314ed6536502c6d620667d7041 /bin/bash
``