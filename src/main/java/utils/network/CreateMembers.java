package utils.network;

import org.bson.BsonDocument;
import org.bson.BsonString;
import utils.FileReaderUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Date;

public class CreateMembers extends APIUtils {

    //Create a member using API
    public String createMember() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("").path("");

        //Read JSON file
        FileReaderUtils reader = new FileReaderUtils();
        BsonDocument personDoc = reader.readJson("./src/main/resources/test-data/create-members.json");
        //populate dynamic member details in json format
        personDoc.getDocument("createMemberProfile").getDocument("travellerProfile").getDocument("memberInformation").getDocument("person").put("givenName", new BsonString(generateGivenName()));
        personDoc.getDocument("createMemberProfile").getDocument("travellerProfile").getDocument("profileInformation").put("lastMemberDetailReviewDate", new BsonString(LocalDate.now().toString()));

        Response resp = target.request(MediaType.APPLICATION_JSON_TYPE).header("X-ApiKey", "").post(Entity.json(personDoc.toJson()));

        String memberID = getResponseValue("", resp);
        return memberID;
    }

    //Generate random given name for member to be created
    private String generateGivenName() {
        StringBuilder sb = new StringBuilder();
        long timestamp = new Date().getTime();
        String timestampStr = "" + timestamp;
        byte digit = 0;
        for (int i = 0; i < timestampStr.length(); i++) {
            digit = timestampStr.charAt(i) == '0' ? 10 : Byte.parseByte(timestampStr.charAt(i) + "");
            sb.append((char) (digit + 64));
        }
        return sb.toString();
    }
}
