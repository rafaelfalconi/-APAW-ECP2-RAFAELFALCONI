package apaw.ecp2.rafael;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.rafael.api.daos.DaoFactory;
import apaw.ecp2.rafael.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.rafael.api.resources.CategoryResource;
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

    public void createCategories() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(CategoryResource.CATEGORIES).body("1:1:Marketing").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(CategoryResource.CATEGORIES).body("2:2:Logistica").build();
        new HttpClientService().httpRequest(request);

    }

    @Test
    public void testCreateCategory() {
        this.createCategory();
    }

    @Test
    public void testReadCategory() {
        this.createCategory();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(CategoryResource.CATEGORIES).path(CategoryResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":1,\"rank\":1,\"title\":\"Marketing\"}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test
    public void testCategoryList() {
        this.createCategories();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(CategoryResource.CATEGORIES).build();
        assertEquals("[{\"id\":1,\"rank\":1,\"title\":\"Marketing\"}, {\"id\":2,\"rank\":2,\"title\":\"Logistica\"}]",
                new HttpClientService().httpRequest(request).getBody());
    }
}
