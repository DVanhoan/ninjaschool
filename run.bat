@ECHO OFF
java -server -cp "lib/*;dist/NSO-HOIUC.jar" -Dfile.encoding=UTF-8 -Xms1000M -Xmx1000M com.hoiuc.server.NinjaSchool
PAUSE
