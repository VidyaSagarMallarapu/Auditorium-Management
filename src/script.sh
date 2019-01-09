mv *.class ../WEB-INF/classes/
sh ../../../bin/./catalina.sh stop
sh ../../../bin/./catalina.sh start
firefox 127.0.0.1:8080/Sigma