package utils.network;

import org.bson.BsonDocument;
import utils.ProjectConfig;
import utils.SeleniumDriver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class APIUtils {

    String host = ProjectConfig.getConfig().getProperty("apiHost");
    String key = ProjectConfig.getConfig().getProperty("key");

    //To get keycloak token from the browser's local storage
    private String getKeycloakToken() {

        String itemKey = "keycloak-token";
        //Access LocalStorageUtils
        LocalStorageUtils keyAccess = new LocalStorageUtils(SeleniumDriver.getDriver());

        //Wait until key exists
        while (!keyAccess.isItemPresentInLocalStorage(itemKey)) {
        }

        //Get the keycloak token
        String keycloakToken = keyAccess.getItemFromLocalStorage(itemKey);
        BsonDocument keycloakTokenDoc = BsonDocument.parse(keycloakToken);
        keycloakToken = keycloakTokenDoc.getString("token").getValue();

        return keycloakToken;
    }

    //Requesting an API for authenticated members (for logged in users)
    public Response getAPIResponse(String path) {

        String keycloakToken = getKeycloakToken();
        SeleniumDriver.log.info("Key Cloak Token is: " + keycloakToken);

        //Send the Get Request to the API
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(host).path(path);

        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
                .header("X-APIKey", key)
                .header("Authorization", "Bearer " + keycloakToken);

        return builder.get();
    }

    //Requesting an API for unauthenticated members (for not logged in users)
    public Response getUnAuthAPIResponse(String path) {

        //Send the Get Request to the API
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(host).path(path);

        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
                .header("X-APIKey", key);

        return builder.get();
    }

    public String getResponseValue(String itemKey, Response resp) {
        String respEntity = resp.readEntity(String.class);
        BsonDocument respDoc = BsonDocument.parse(respEntity);
        String responseValue = respDoc.getString(itemKey).getValue();
        return responseValue;
    }

}
