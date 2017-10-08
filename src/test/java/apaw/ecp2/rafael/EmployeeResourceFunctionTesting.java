package apaw.ecp2.rafael;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import apaw.ecp2.rafael.api.daos.DaoFactory;
import apaw.ecp2.rafael.api.daos.memory.DaoMemoryFactory;
import apaw.ecp2.rafael.api.resources.CategoryResource;
import apaw.ecp2.rafael.api.resources.EmployeeResource;
import apaw.ecp2.rafael.http.HttpClientService;
import apaw.ecp2.rafael.http.HttpMethod;
import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpRequestBuilder;

public class EmployeeResourceFunctionTesting {
    private HttpRequest request;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    public void createCategory() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(CategoryResource.CATEGORIES).body("1:1:Marketing").build();
        new HttpClientService().httpRequest(request);
    }

    public void createEmployee() {
        this.createCategory();
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.Employee).body("1:Rafael:1").build();
        new HttpClientService().httpRequest(request);
    }
    
    public void createEmployees() {
        this.createCategory();
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.Employee).body("1:Rafael:1").build();
        new HttpClientService().httpRequest(request);
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.Employee).body("2:Rafael:1").build();
        new HttpClientService().httpRequest(request);
    }
    @Test
    public void testCreateUser() {
        this.createEmployee();
    }
    @Test
    public void testReadEmployee() {
        this.createEmployee();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(EmployeeResource.Employee).path(EmployeeResource.ID).expandPath("1")
                .build();
        assertEquals("{\"id\":1,\"surname\":\" Rafael \",\"category\":\" Marketing\"}", new HttpClientService().httpRequest(request).getBody());
    }
    @Test 
    public void testListEmployee() {
        this.createEmployees();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(EmployeeResource.Employee).build();
        assertEquals("[{\"id\":1,\"surname\":\" Rafael \",\"category\":\" Marketing\"}, {\"id\":2,\"surname\":\" Rafael \",\"category\":\" Marketing\"}]", new HttpClientService().httpRequest(request).getBody());
    }

}
