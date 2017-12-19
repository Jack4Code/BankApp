import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception{
        //BankAccountInformationHolder account1 = AccountCreaterDestroyer.createNewAccount("Jack", "Giannini", 10000);
        //BankAccountInformationHolder account2 = AccountCreaterDestroyer.createNewAccount("Julia", "kiningham", 10000);
        start();

    }


    public static void start() throws Exception{

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8081);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                EntryPoint.class.getCanonicalName());

        try {
            jettyServer.start();
            System.out.println("Server started on: " + jettyServer.getURI());
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }


}
