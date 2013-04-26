package com.wr.sandbox.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class Quote {
    private BigDecimal price;
    private String quoteRef;

    public Quote() {
    }

    public Quote(BigDecimal price, String quoteRef) {
        this.price = price;
        this.quoteRef = quoteRef;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getQuoteRef() {
        return quoteRef;
    }

    public void setQuoteRef(String quoteRef) {
        this.quoteRef = quoteRef;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("price", price)
                .append("quoteRef", quoteRef)
                .toString();
    }
}
