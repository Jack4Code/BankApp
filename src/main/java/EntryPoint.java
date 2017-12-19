/**
 * Created by Jack on 12/18/2017.
 */
import com.google.gson.Gson;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/entry-point")
public class EntryPoint {

    @Path("get-accounts")
    @GET
    public Response test() throws Exception{
        System.out.println("Connection Established");
        //ArrayList<BankAccountInformationHolder> accounts =
        String test = "test success";
        Gson gson = new Gson();
        return Response.ok(gson.toJson(test)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
//                .allow("OPTIONS").build();
    }




}
