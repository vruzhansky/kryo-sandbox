package com.wr.sandbox.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class PriceTick {
    private InstrumentType instrumentType;
    private InstrumentClass instrumentClass;

    private Date timestamp;

    private CurrencyPair currencyPair;

    private QuoteContainer quoteContainer;

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public InstrumentClass getInstrumentClass() {
        return instrumentClass;
    }

    public void setInstrumentClass(InstrumentClass instrumentClass) {
        this.instrumentClass = instrumentClass;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(CurrencyPair currencyPair) {
        this.currencyPair = currencyPair;
    }

    public QuoteContainer getQuoteContainer() {
        return quoteContainer;
    }

    public void setQuoteContainer(QuoteContainer quoteContainer) {
        this.quoteContainer = quoteContainer;
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
        PriceTick that = (PriceTick) other;
        return new EqualsBuilder()
                .append(this.instrumentType, that.instrumentType)
                .append(this.instrumentClass, that.instrumentClass)
                .append(this.timestamp, that.timestamp)
                .append(this.currencyPair, that.currencyPair)
                .append(this.quoteContainer, that.quoteContainer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.instrumentType)
                .append(this.instrumentClass)
                .append(this.timestamp)
                .append(this.currencyPair)
                .append(this.quoteContainer)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("instrumentType", instrumentType)
                .append("instrumentClass", instrumentClass)
                .append("timestamp", timestamp)
                .append("currencyPair", currencyPair)
                .append("quoteContainer", quoteContainer)
                .toString();
    }
}
