package apaw.ecp2.rafael;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.rafael.api.resources.CategoryResource;
import apaw.ecp2.rafael.api.resources.daos.DaoFactory;
import apaw.ecp2.rafael.api.resources.daos.memory.DaoMemoryFactory;
import apaw.ecp2.rafael.http.HttpClientService;
import apaw.ecp2.rafael.http.HttpMethod;
import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpRequestBuilder;

public class CategoryResourceFunction {
    private HttpRequest request;
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    public void createCategory() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(CategoryResource.CATEGORIES).body("1:1:Marketing").build();
        new HttpClientService().httpRequest(request);

    }
    @Test
    public void testCreateCategory() {
        this.createCategory();
    }
    @Test
    public void testReadCategory() {
        this.createCategory();
       request= new HttpRequestBuilder().method(HttpMethod.GET).path(CategoryResource.CATEGORIES)
               .path(CategoryResource.ID).expandPath("1").build();
       assertEquals("{\"id\":1,\"rank\":1,\"title\":\"Marketing\"}",new HttpClientService().httpRequest(request).getBody());
    }
}
