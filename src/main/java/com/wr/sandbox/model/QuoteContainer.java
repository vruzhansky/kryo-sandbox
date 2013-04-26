package com.wr.sandbox.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class QuoteContainer {
    private Quote quoteAsk;
    private Quote quoteBid;

    public QuoteContainer() {
    }

    public QuoteContainer(Quote quoteAsk, Quote quoteBid) {
        this.quoteAsk = quoteAsk;
        this.quoteBid = quoteBid;
    }

    public Quote getQuoteAsk() {
        return quoteAsk;
    }

    public void setQuoteAsk(Quote quoteAsk) {
        this.quoteAsk = quoteAsk;
    }

    public Quote getQuoteBid() {
        return quoteBid;
    }

    public void setQuoteBid(Quote quoteBid) {
        this.quoteBid = quoteBid;
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
        QuoteContainer that = (QuoteContainer) other;
        return new EqualsBuilder()
                .append(this.quoteAsk, that.quoteAsk)
                .append(this.quoteBid, that.quoteBid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.quoteAsk)
                .append(this.quoteBid)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("quoteAsk", quoteAsk)
                .append("quoteBid", quoteBid)
                .toString();
    }
}
