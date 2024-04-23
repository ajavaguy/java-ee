- What is Java EE?
    - Set of API specifications.
    - Support development of enterprise: data persistence, building REST API, Dependency Injection, Security... 
- Java EE APIs:
    -  JSF, JSTL, JSP, JAX-RS 2.1, Servlet 4.0, WebSocket 1.0, CDI 2.0, EL 3.0, Bean Validation 2.0, JSON-B 1.0, JSON-P 1.1, JPA 2.2, EJB 3.2, JMS 2.0, Security 1.0
-  Servlet API
    - Servlet run in a Servlet Container, which is a web or an application server for receiving responses and sending requests (HTTP requests sent by browser).
    - Provides request-handing HTTP methods like GET, POST
    - Asynchronous processing of requests.
    - HttpServletRequest, HttpServletResponse, HttpSession, Cookie, ServletContext (communicate with Servlet Container), Filter.
- HTTP Message:
    - Headers
    - Cookies
    - Body
- Filter:
    - Sits in front of Servlet to allow transformations to be applied to request and responses process by Java EE application.
- Asynchronous:
    - asyncSupported = true for @WebServlet.
    - All filters are need to set asyncSupported = true as well.
    - AsyncContext asyncContext = request.startAsync();
    - Task which is processed by async is processed by another thread.
- JSP:
    - JSTL
    - EL (Expression Language)
- JSF:
- EJBs (Enterprise Java Beans): are APIs within Java EE that provide a standard component architecture for building object-oriented business applications.
    - An EJB is Java class or POJO.
    - Isolates system business logic.
    - Managed by an EJB container.
    - Injected into other Java EE components through a JNDI so they can be centralized and reused.
    - EJB Benefits:
        - Transaction
        - Security
        - Concurrency
        - Persistence
    - EJB types:
        - Session Bean:
            - Contains business logic that models an action or use case
            - Stateful: Unique for every client 
            - Stateless: Shared for every client and does not containts any state
            - Singleton: Shared for every client at an application level.
        - Message Driven Bean:
           - Bean that processes messages send by other components
           - Are stateless components that run on the server side for processing messages delivered by Java Messaging Service.
 - CDI (Context and Dependency Injection): Bean and Dependency Injection
     - Bean: Instantiated, managed, and injected by a container. Injected into servlet, other beans, JAX-RS resources
     - CDI: Provides a standard Dependency Injection framework, improves structure of application code, manages beans.
     - Discovery Mode:
         - Explicit: Contains a beans.xml file with bean-discovery-mode=all -> no longer need to annotate any of our classes in order to make them beans, they'll automatically be created as a bean in the CDI container.
         - Implicit: No beans.xml file. Contains one or more classes with a bean-defining annotation.
     - Bean Scope:
         - @Dependent: default
         - @RequestScoped: A single http request
         - @SessionScoped: Spans multiple http requests.
         - @ApplicationScoped: Shared across the entire application.
         - @ConversationScoped:
     - @Qualifier: Used to solve ambiguity among beans of the same types, indicates a particular bean instance should be injected.  
