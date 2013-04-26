package com.wr.sandbox.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class CurrencyPair {
    private String ccy1;
    private String ccy2;

    public CurrencyPair() {
    }

    public CurrencyPair(String ccy1, String ccy2) {
        this.ccy1 = ccy1;
        this.ccy2 = ccy2;
    }

    public String getCcy1() {
        return ccy1;
    }

    public void setCcy1(String ccy1) {
        this.ccy1 = ccy1;
    }

    public String getCcy2() {
        return ccy2;
    }

    public void setCcy2(String ccy2) {
        this.ccy2 = ccy2;
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
        CurrencyPair that = (CurrencyPair) other;
        return new EqualsBuilder()
                .append(this.ccy1, that.ccy1)
                .append(this.ccy2, that.ccy2)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.ccy1)
                .append(this.ccy2)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("ccy1", ccy1)
                .append("ccy2", ccy2)
                .toString();
    }
}
