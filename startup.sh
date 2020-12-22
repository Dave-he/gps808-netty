#! /bin/bash
if [ ${RUN_MODE}x = "test"x ]
then
    echo "NOTICE: you are running this application in test mode!"
    java -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=GB18030 -jar /app.jar --spring.profiles.active=test --server.port=8080
elif [ ${RUN_MODE}x = "prod"x ]
then
    echo "NOTICE: you are running this application in prod mode!"
    java -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=GB18030 -jar  /app.jar --spring.profiles.active=prod --server.port=8080
else
    echo "NOTICE: you are running this application in dev mode!"
    java -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=GB18030 -jar /app.jar --spring.profiles.active=dev --server.port=8080
fi
