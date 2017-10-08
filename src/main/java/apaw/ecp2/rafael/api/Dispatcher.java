package apaw.ecp2.rafael.api;

import apaw.ecp2.rafael.api.resources.CategoryResource;
import apaw.ecp2.rafael.api.resources.EmployeeResource;
import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpResponse;
import apaw.ecp2.rafael.http.HttpStatus;

public class Dispatcher {
    private CategoryResource categoryResource = new CategoryResource();

    private EmployeeResource employeeResorce = new EmployeeResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CategoryResource.CATEGORIES + CategoryResource.ID)) {
                response.setBody(categoryResource.readCategory(Long.valueOf(request.paths()[1])).toString());

            }
            if (request.isEqualsPath(CategoryResource.CATEGORIES)) {
                response.setBody(categoryResource.categoryList().toString());
            }
            if (request.isEqualsPath(EmployeeResource.Employee + EmployeeResource.ID)) {
                response.setBody(employeeResorce.readEmployee(Long.valueOf(request.paths()[1])).toString());
            }
            if (request.isEqualsPath(EmployeeResource.Employee)) {
                response.setBody(employeeResorce.employeeList());
            }
        } catch (Exception e) {
            responseError(response, e);
        }

    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(CategoryResource.CATEGORIES)) {
                String categoryId = request.getBody().split(":")[0];
                String categoryRank = request.getBody().split(":")[1];
                String categoryTitle = request.getBody().split(":")[2];
                categoryResource.createCategory(Long.valueOf(categoryId), Integer.valueOf(categoryRank), categoryTitle);
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(EmployeeResource.Employee)) {
                String id = request.getBody().split(":")[0];
                String name = request.getBody().split(":")[1];
                String category = request.getBody().split(":")[2];
                employeeResorce.createUsuario(Long.valueOf(id), name, Long.valueOf(category));
                response.setStatus(HttpStatus.CREATED);
            }
        } catch (Exception e) {
            responseError(response, e);
        }

    }

}
