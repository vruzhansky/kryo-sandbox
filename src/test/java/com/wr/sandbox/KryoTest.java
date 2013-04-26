package com.wr.sandbox;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.wr.sandbox.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Vladimir Ruzhansky
 *         Date: 4/26/13
 */
public class KryoTest {

    private PriceTick priceTick;
    private final static Logger logger = LoggerFactory.getLogger(KryoTest.class);

    @BeforeMethod
    public void setUp() throws Exception {
        priceTick = new PriceTick();

        Quote quoteA = new Quote(new BigDecimal("1.31"), "ref_quote_a");
        Quote quoteB = new Quote(new BigDecimal("1.41"), "ref_quote_b");

        priceTick.setInstrumentClass(InstrumentClass.FX);
        priceTick.setInstrumentType(InstrumentType.SPOT);
        priceTick.setCurrencyPair(new CurrencyPair("USD", "CHF"));
        priceTick.setTimestamp(new Date());
        priceTick.setQuoteContainer(new QuoteContainer(quoteA, quoteB));
    }

    @Test
    public void testName() throws Exception {
        logger.info("Created price tick {}", priceTick);
        Kryo kryo = new Kryo();


        Output output = new Output(4096);
        kryo.writeObject(output, priceTick);
        output.close();

        logger.info("Serialized by kryo, size: {}", output.total());

        Input input = new Input(output.getBuffer());
        PriceTick restoredPriceTick = kryo.readObject(input, PriceTick.class);
        input.close();

        logger.info("Restored price tick: {}", restoredPriceTick);

        Assert.assertEquals(priceTick, restoredPriceTick);
    }
}
