
cd D:\tools\java\tomcat\jakarta-tomcat-5.0.28\webapps\adrm\reports\applets

keytool -genkey -keystore vriche.store -alias vriche

keytool -export -keystore vriche.store -alias vriche -file vriche.cer

Jar -cvf report.jar *.class

jarsigner -keystore vriche.store report.jar vriche

jarsigner -keystore vriche.store jasperreports-1.2.8-applet.jar vriche
