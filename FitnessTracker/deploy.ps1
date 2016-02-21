param(
  [String]$buildNumber,
  [String]$jdk_path
)




$tomcat = "D:\worek\apache-tomcat-9.0.0.M1"
$tomcatBin = $tomcat + "\bin"
$tomcatApps = $tomcat + "\webapps"
$warFileFolder = "D:\worek\gitHub\IdeaProjects\playground\FitnessTracker\target"

copy-item "$warFileFolder\*" -include "*.war" -Destination "$tomcatApps"


$env:CATALINA_HOME = $tomcat
#$env:CATALINA_OPTS = "-Dproperties=$batchfixedlistPropertiesFile -DTropicsProperties=$tropicsPropertiesFile -Dlog4j.configuration=$log4jconfigPropertiesFile -Doracle.jdbc.V8Compatible=true -Djavax.xml.transform.TransformerFactory=org.apache.xalan.processor.TransformerFactoryImpl -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
$env:CATALINA_OPTS = "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

& $tomcatBin\startup