package com.techcanopy.camelpoc.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techcanopy.camelpoc.pojo.FinzyLender;
import com.techcanopy.camelpoc.pojo.IfaLender;
import com.techcanopy.camelpoc.pojo.IfaResponse;
import com.techcanopy.camelpoc.processor.IFAInputProcessor;
import com.techcanopy.camelpoc.processor.IFAResponseProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
class CamelRouter extends RouteBuilder {

        @Override
        public void configure() throws JsonProcessingException {
                restConfiguration().component("servlet").host("localhost").port(8090);

                //json request
                rest()
                        .consumes("application/json")
                        .produces("application/json")
                        .post("/transform")
                        .to("direct:transform");


                //json transformation
                from("direct:transform")
                        .unmarshal()
                        .json(JsonLibrary.Jackson, IfaLender.class)
                        .process(new IFAInputProcessor())
                        .transform()
                        .body()
                        .marshal()
                        .json()
                        .log("IFA Lender details : \n ${body}")
                        .to("direct:callApi");

                //calling finzy core api
                from("direct:callApi")
                        .routeId("callApi")

                        .log("The requestbody : ${body}")
                        .removeHeaders("CamelHttp*") // removing camel type headers
                        .setHeader("CamelHttpMethod", constant("POST"))
                        .to("http://localhost:8080/addLender").unmarshal()
                        .json(JsonLibrary.Jackson, FinzyLender.class)
                        .process(new IFAResponseProcessor())
                        .transform()
                        .body()
                        .marshal()
                        .json()
                        .log("Response from Finzy Core API : \n${body}");
        }
}
