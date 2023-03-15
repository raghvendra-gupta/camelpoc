package com.techcanopy.camelpoc.processor;

import com.techcanopy.camelpoc.pojo.FinzyLender;
import com.techcanopy.camelpoc.pojo.IfaLender;
import com.techcanopy.camelpoc.pojo.IfaResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class IFAResponseProcessor implements Processor {

  @Override
  public void process(Exchange exchange) {

    Object body = exchange.getIn().getBody();

    FinzyLender finzyLender = exchange.getIn().getBody(FinzyLender.class);
    IfaResponse ifaResponse = new IfaResponse();

    ifaResponse.setUuid(finzyLender.getLenderId());
    ifaResponse.setPortfolioAmount(finzyLender.getPortfolioValue());
    ifaResponse.setPortfolioId(finzyLender.getLenderId());

    System.out.println(finzyLender);

    exchange.getIn().setBody(ifaResponse);
  }
}
