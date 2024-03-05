@echo off
javac src/*.java
jar cfvm passwordencrypt.jar manifest.mf src/*.class
del "src\\*.class"