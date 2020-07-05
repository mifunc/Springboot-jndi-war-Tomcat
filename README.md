# springboot-jndi

This is springboot war deployed to third party app server
for tomcat:

server.xml:

<Resource name="sachin/db" 
	      global="sachin/db" 
	      auth="Container" 
	      type="javax.sql.DataSource" 
	      driverClassName="com.mysql.jdbc.Driver" 
	      url="jdbc:mysql://localhost:3306/test1" 
	      username="sachin" 
	      password="Sachin@123" 
	      maxActive="100" 
	      maxIdle="20" 
	      minIdle="5" 
	      maxWait="10000"/>
        
For context.xml

<ResourceLink name="sachin/db"
                global="sachin/db"
                auth="Container"
                type="javax.sql.DataSource" />
                
create war of this springboot. put in webapps folder and start server.
Its done!!!
