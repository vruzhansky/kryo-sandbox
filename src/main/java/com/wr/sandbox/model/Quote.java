package com.wr.sandbox.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Quote that = (Quote) other;
        return new EqualsBuilder()
                .append(this.price, that.price)
                .append(this.quoteRef, that.quoteRef)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.price)
                .append(this.quoteRef)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("price", price)
                .append("quoteRef", quoteRef)
                .toString();
    }
}
