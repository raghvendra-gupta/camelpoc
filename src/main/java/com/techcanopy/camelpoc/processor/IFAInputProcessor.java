package com.techcanopy.camelpoc.processor;

import com.techcanopy.camelpoc.pojo.FinzyLender;
import com.techcanopy.camelpoc.pojo.IfaLender;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class IFAInputProcessor implements Processor {

  @Override
  public void process(Exchange exchange) {

    Object body = exchange.getIn().getBody();

    IfaLender ifaLender = exchange.getIn().getBody(IfaLender.class);
    FinzyLender finzyLender = new FinzyLender();

    finzyLender.setLenderId(ifaLender.getUuid());
    finzyLender.setLenderName(ifaLender.getFirstName() + " " + ifaLender.getLastName());
    finzyLender.setPanNumber(ifaLender.getPan());
    finzyLender.setPortfolioValue(ifaLender.getInvestmentAmount());
    finzyLender.setFullAddress(ifaLender.getAddress1() + " " + ifaLender.getAddress2());
//    finzyLender.setCreatedAt(LocalDateTime.now());
//    finzyLender.setUpdatedAt(LocalDateTime.now());

    System.out.println(finzyLender);

    exchange.getIn().setBody(finzyLender);
  }
}
