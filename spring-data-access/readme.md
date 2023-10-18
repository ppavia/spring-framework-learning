url server distant

jdbc:h2:tcp://localhost//home/ppierre/Development/dbs/db-h2/db/TENANT1

start h2 server allowing remote creation (WARNING !! not in production)  
<code>java -cp h2*.jar org.h2.tools.Server -ifNotExists</code>

# Custom autoconfiguration (starter)
Dans le fichier <code>resources/META-INF/org.springframework.boot.autoconfigure.AutoConfiguration.imports</code> :  
ajout des classes de configuration (full qualified name)

La classe root de configuration doit être annotée par @AutoConfiguration


# Fonctionnalités 

## multitenancy

## aop 

## gestion exception

