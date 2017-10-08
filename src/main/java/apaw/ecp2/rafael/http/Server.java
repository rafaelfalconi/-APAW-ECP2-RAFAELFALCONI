package apaw.ecp2.rafael.http;

import apaw.ecp2.rafael.api.Dispatcher;

public class Server {
    private Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
        case POST:
            dispatcher.doPost(request, response);
            break;
        case GET:
            dispatcher.doGet(request, response);
            break;

        default:
            break;
        }
        return response;
    }

}
