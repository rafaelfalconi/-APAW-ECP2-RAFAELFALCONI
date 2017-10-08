package apaw.ecp2.rafael;

import static org.junit.Assert.*;

import org.junit.Test;

import apaw.ecp2.rafael.http.HttpClientService;
import apaw.ecp2.rafael.http.HttpMethod;
import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpRequestBuilder;

public class CategoryResourceFunction {
    private HttpRequest request;

    public void createCategory() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("categories").body("1:test").build();
        new HttpClientService().httpRequest(request);

    }
    @Test
    public void testCreateCategory() {
        this.createCategory();
    }

}
