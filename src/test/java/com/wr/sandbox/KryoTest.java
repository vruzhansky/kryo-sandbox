package com.wr.sandbox;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.wr.sandbox.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

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

        Quote quoteA = new Quote();
        Quote quoteB = new Quote();
        quoteA.setPrice(new BigDecimal("1.31"));
        quoteA.setQuoteRef("ref_quote_a");
        quoteB.setPrice(new BigDecimal("1.41"));
        quoteB.setQuoteRef("ref_quote_b");

        QuoteContainer quoteContainer = new QuoteContainer();
        quoteContainer.setQuoteAsk(quoteA);
        quoteContainer.setQuoteBid(quoteB);

        CurrencyPair currencyPair = new CurrencyPair();
        currencyPair.setCcy1("USD");
        currencyPair.setCcy2("CHF");

        priceTick.setInstrumentClass(InstrumentClass.FX);
        priceTick.setInstrumentType(InstrumentType.SPOT);
        priceTick.setCurrencyPair(currencyPair);
        priceTick.setTimestamp(new Date());
        priceTick.setQuoteContainer(quoteContainer);
    }

    @Test
    public void testName() throws Exception {
        logger.info("Created price tick {}", priceTick);
        Kryo kryo = new Kryo();


        Output output = new Output(new DeflaterOutputStream(new FileOutputStream("file.bin")));
        kryo.writeObject(output, priceTick);
        output.close();

        logger.info("Serialized by kryo: {}", output);

        Input input = new Input(new InflaterInputStream(new FileInputStream("file.bin")));
        PriceTick restoredPriceTick = kryo.readObject(input, PriceTick.class);
        input.close();

        logger.info("Restored price tick: {}", restoredPriceTick);

    }
}
