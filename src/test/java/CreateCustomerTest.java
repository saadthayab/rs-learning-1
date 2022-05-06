import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateCustomerTest extends BaseTest{

    @Test
    public void testHelloWorld() {
        log.debug("Sample DEBUG message");
        log.error("Sample ERROR message");
        log.info("Sample INFO message");
        log.warn("Sample WARN message");

//        Response getResponse = given().auth().
//                basic("sk_test_51Khvw2GTgkJWXw9cI55xUDmrbpr3cJsRBjWA9mkGpd6vhBxoOfvf0Va5Pi5wRLzu09IrimThyuwRbQxq7wqmj9kF003Ai1umBE", "")
//                .formParams("limit", 3).get("https://api.stripe.com/v1/customers");
//        //getResponse.prettyPrint();
//        Assert.assertEquals(getResponse.getStatusCode(), 200);
//        getResponse.prettyPrint();
//
//        // System.out.println(data.get("id").toString());
//        System.out.println(getResponse.jsonPath().get("data.id").toString());


        Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
                .formParam("email", "saad@newConfic.ca").formParam("description", "hello")
                .post(config.getProperty("customerAPIEndPoint"));
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(),200);

//        // post request using parm only
//        Response response = given().auth().basic("sk_test_51Khvw2GTgkJWXw9cI55xUDmrbpr3cJsRBjWA9mkGpd6vhBxoOfvf0Va5Pi5wRLzu09IrimThyuwRbQxq7wqmj9kF003Ai1umBE", "")
//                .formParam("name", "Rahul Arora").formParam("email", "trainer@way2automation.com")
//                .formParam("description", "This is new POST request from Rest Assured API").post("https://api.stripe.com/v1/customers");

        // response.prettyPrint();
        //System.out.println(response);

    }

    @Test
    public  void  getAccessTokenPayPal() {
        String client_id = "AZpanHwXXqjUngz7K2G1j4wfRH6IyjpxAA7V5uKQ3hj3E6ecZGkqYw7YdNTte1h-gy8Y8H2UWGskhG_H";
        String secret ="EAz-njmDSl6jjC-wZwuuqM0TsFonlPw9Db255Dvg02HDuCl1NLluW1Ln0EKKoorPjstJyX-niRl1fDP2";

        Response access_token = given().param("grant_type", "client_credentials")
                .auth().preemptive()
                .basic(client_id, secret)
                .post("https://api-m.sandbox.paypal.com/v1/oauth2/token");
//                .jsonPath()
//                .get("access_token").toString();
        System.out.println(access_token.prettyPrint());
        System.out.println(access_token);
        //return access_token;

    }
}