# CURSO JAVA REST

## END-POINTS

- Principal da api - `/api`

***
- [GET] hello world: `/api/hello-world` <br>
- [GET] hello world url completa: ``http://localhost:8080/demo-1.0-SNAPSHOT/api/hello-world`` <br>
***

# Observações

## Jboss (WildFly 26.0.1)

- As informações do banco deverão estar contidas no arquivo `resources/META-INF/persistence.xml`
- O EntityManager ( no arquivo `DAO/GenericDAO.java`) deve ser instânciado da seguinte forma: <br> `EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU");` <br> `EntityManager em = entityManagerFactory.createEntityManager();`
- Se preferir você pode remover o arquivo `resources/META-INF/resources.xml`

## Aplicação Rest

- Está contida na pasta `java`<br>
- As requisições serão feitas apartir do endereço raiz/root ex: 
- [GET] `localhost:8080/demo-1.0-SNAPSHOT/api/`

