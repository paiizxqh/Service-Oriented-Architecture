import javax.ws.rs.client.Client;

import org.glassfish.jersey.client.*;
import org.glassfish.jersey.client.ClientResponse;



public class Main {
	public static void main(String[] args) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/jersey/rest/services/customers/A");
			
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
				if (response.getStatus() != 200) { 
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());}
				String output = response.getEntity(String.class);
				System.out.println("Output from Server .... \n");
				System.out.println(output);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
