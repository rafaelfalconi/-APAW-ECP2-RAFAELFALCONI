package apaw.ecp2.rafael;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.rafael.http.HttpClientService;
import apaw.ecp2.rafael.http.HttpMethod;
import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpRequestBuilder;

public class UserResourceFunctionTesting {
    private HttpRequest request;

    @Before
    public void createUser() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("users").body("1:Rafel:true:1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateUser() {
        this.createUser();
    }

}
