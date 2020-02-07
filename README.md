- Postgres Docker
    
    ````
    docker run --name=jko-test -e POSTGRES_USER=jko -e POSTGRES_PASSWORD=123 -e POSTGRES_DB=jko-test -d -p 5432:5432 postgres
    ````

- Api Test
    
    After running application, run this on command line  
    
    ````
    http localhost:8080/books title='the java' author='jko'
    ````
