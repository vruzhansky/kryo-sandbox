package com.wr.sandbox.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class QuoteContainer {
    private Quote quoteAsk;
    private Quote quoteBid;

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
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("quoteAsk", quoteAsk)
                .append("quoteBid", quoteBid)
                .toString();
    }
}
