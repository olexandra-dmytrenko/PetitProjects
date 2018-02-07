package strings;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Oleksandra_Dmytrenko on 01/12/2017.
 */
public class ParsingTest {
    @Test
    public void splitMiddle2() {
        String myString = "![CDATA[pdf|pdf.txt]]";
        String[] split = StringUtils.remove(myString, "![CDATA[").split("[\\[|\\]|\\|]");
        assertEquals(2, split.length);
        assertEquals("pdf", split[0]);
        assertEquals("pdf.txt", split[1]);
        assertEquals("txt", split[2]);
        assertTrue(Arrays.asList(split).contains("txt"));
        String bestTxt = Stream.of(split).filter(format -> format.contains("txt")).findAny().orElse("pdf.txt");
        assertEquals("pdf.txt", bestTxt);
    }

    @Test
    public void splitMiddle3Txt() {
        String myString = "![CDATA[pdf|zip.txt|zip]]";
        String[] split = StringUtils.remove(myString, "![CDATA[").split("[\\[|\\]|\\|]");
        assertEquals(3, split.length);
        assertEquals("pdf", split[0]);
        String bestTxt = Arrays.asList(split).contains("txt") ? "txt"
                : Stream.of(split).filter(format -> format.contains("txt")).findAny().orElse("pdf.txt");
//        String bestTxt = Stream.of(split).filter(format -> format.contains("txt")).findAny().orElse("pdf.txt");
        assertEquals("zip.txt", bestTxt);
    }

    @Test
    public void splitMiddle3PdfTxt() {
        String myString = "![CDATA[pdf|orm.mtt|zip.txr]]";
        String[] split = StringUtils.remove(myString, "![CDATA[").split("[\\[|\\]|\\|]");
        assertEquals(3, split.length);
        assertEquals("pdf", split[0]);
        String bestTxt = Arrays.asList(split).contains("txt") ? "txt"
                : Stream.of(split).filter(format -> format.contains("txt")).findAny().orElse("pdf.txt");
//        String bestTxt = Stream.of(split).filter(format -> format.contains("txt")).findAny().orElse("pdf.txt");
        assertEquals("pdf.txt", bestTxt);
    }

}