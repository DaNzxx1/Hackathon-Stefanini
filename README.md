## Branch master
Contém um projeto Maven comum. <br>
Criação: Java Overview do VSCODE e opção ```Create a Maven project```

## Branch maven-web
Projeto Maven-WEB com servidor Wildfly. <br>
Comando de criação: <br>
```mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4``` <br> 
Outra alternativa: <br>
```mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:generate -DarchetypeArtifactId="maven-archetype-webapp" -DarchetypeGroupId="org.apache.maven.archetypes" -DarchetypeVersion="1.4"```