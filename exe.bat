@echo off

javac -classpath . *.java
javac -cp mysql-connector-java-8.0.29.jar;. SQL.java
javac Main.java
javac Player.java
javac Vars.java
java -cp mysql-connector-java-8.0.29.jar;. Main

pause

