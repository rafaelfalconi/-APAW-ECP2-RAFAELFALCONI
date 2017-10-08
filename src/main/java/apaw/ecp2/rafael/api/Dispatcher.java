package apaw.ecp2.rafael.api;

import apaw.ecp2.rafael.http.HttpRequest;
import apaw.ecp2.rafael.http.HttpResponse;
import apaw.ecp2.rafael.http.HttpStatus;

public class Dispatcher {

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath("categories")) {
            response.setStatus(HttpStatus.CREATED);

        }
    }

}
