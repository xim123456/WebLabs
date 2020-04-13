package lab6client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;
import lav6client.SimpleObjects.SimpleData;

public class SimpleService {
    List<SimpleData> Select(SimpleData data) {
        String URL = "http://localhost:8080/Lab6/webresources/Metods/SelectData"; 
        GenericType<List<SimpleData>> type = new GenericType<List<SimpleData>>() {}; 
        return SendMessage(URL, new String[] {"id", "fild1", "fild2", "fild3", "fild4"}, new String[] {data.getId(), data.getFild1() , data.getFild2() , data.getFild3() , data.getFild4()}).getEntity(type);
    } 
    
    String Insert(SimpleData data) {
        String URL = "http://localhost:8080/Lab6/webresources/Metods/InsertData"; 
        GenericType<String> type = new GenericType<String>() {}; 
        return SendMessage(URL, new String[] {"id", "fild1", "fild2", "fild3", "fild4"}, new String[] {data.getId(), data.getFild1() , data.getFild2() , data.getFild3() , data.getFild4()}).getEntity(type);
    } 
    
    String Update(SimpleData data) {
        String URL = "http://localhost:8080/Lab6/webresources/Metods/UpdateData"; 
        GenericType<String> type = new GenericType<String>() {}; 
        return SendMessage(URL, new String[] {"id", "fild1", "fild2", "fild3", "fild4"}, new String[] {data.getId(), data.getFild1() , data.getFild2() , data.getFild3() , data.getFild4()}).getEntity(type);
    } 
    
    String Delete(String id) {
        String URL = "http://localhost:8080/Lab6/webresources/Metods/DeleteData"; 
        GenericType<String> type = new GenericType<String>() {}; 
        return SendMessage(URL, new String[] {"id"}, new String[] {id}).getEntity(type);
    } 
    
    ClientResponse SendMessage(String URL , String[] name, String[] param) {
        Client client = Client.create(); 
        WebResource webResource = client.resource(URL); 

        for(int i = 0; i < name.length; i++)  {
            webResource = webResource.queryParam(name[i], param[i]); 
        }
        ClientResponse response = webResource.accept(MediaType.APPLICATION_ATOM_XML).get(ClientResponse.class); 
        
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) { 
            GenericType<String> type = new GenericType<String>() {}; 
            String responseS = response.getEntity(type);
            throw new IllegalStateException(responseS); 
        } 
        return response;
    }   
}
