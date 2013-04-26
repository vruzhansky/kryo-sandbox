package com.wr.sandbox.model;

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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("ccy1", ccy1)
                .append("ccy2", ccy2)
                .toString();
    }
}
