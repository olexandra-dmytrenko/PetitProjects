package strings;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 * Created by Oleksandra_Dmytrenko on 24/11/2017.
 */
public class Parsing {
    private static String submissionInfoStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<doclibglobalsearch_searchSubmissionsResp xmlns=\"http://schemas.reuters.com/ns/2006/10/doclibglobalsearch\">\n" +
            "    <ESindexServer>ES fusion server</ESindexServer>\n" +
            "    <totalHit>2794073</totalHit>\n" +
            "    <resultSize>2</resultSize>\n" +
            "    <submissionStatusAndInfo commonID=\"39401552\">\n" +
            "        <submissionInfo\n" +
            " DCN=\"151316320\"\n" +
            " arriveDate=\"2016-01-01T00:05:11.690+0000\"\n" +
            " categoryID=\"16\"\n" +
            " commonID=\"39401552\"\n" +
            " countryCode=\"US\"\n" +
            " feedID=\"Edgar\"\n" +
            " fileType=\"edgar\"\n" +
            " formName=\"4\"\n" +
            " formType=\"113\"\n" +
            " isRestricted=\"false\"\n" +
            " languageCode=\"en\"\n" +
            " originalFileName=\"0001287271-15-000009.dissem\"\n" +
            " periodEndDate=\"2015-12-31T00:00:00.000+0000\" releaseDate=\"2015-12-31T00:00:00.000+0000\"\n" +
            " size=\"4830\"\n" +
            " accessionNumber=\"0001287271-15-000009\">\n" +
            "            <companyInfo mxid=\"100050323\" OAPermID=\"4295906628\" CIK=\"0000788965\" Role=\"ISSUER\"/>\n" +
            "            <docType>4</docType>\n" +
            "            <IsHTMLDocumentAvailable>Y</IsHTMLDocumentAvailable>\n" +
            "            <IsPDFDocumentAvailable>R</IsPDFDocumentAvailable>\n" +
            "            <IsRTFDocumentAvailable>R</IsRTFDocumentAvailable>\n" +
            "            <companyNames>\n" +
            "                <company>\n" +
            "                    <companyName>\n" +
            "                        <![CDATA[Hallador Energy Co]]>\n" +
            "                    </companyName>\n" +
            "                    <RIC>\n" +
            "                        <![CDATA[HNRG.OQ]]>\n" +
            "                    </RIC>\n" +
            "                    <IndustryPermId>4294952001</IndustryPermId>\n" +
            "                    <IndustryCode>5010101010</IndustryCode>\n" +
            "                    <IndustryName>\n" +
            "                        <![CDATA[Coal (NEC)]]>\n" +
            "                    </IndustryName>\n" +
            "                </company>\n" +
            "            </companyNames>\n" +
            "        </submissionInfo>\n" +
            "    </submissionStatusAndInfo>\n" +
            "    <submissionStatusAndInfo commonID=\"39401561\">\n" +
            "        <submissionInfo\n" +
            " DCN=\"151316321\"\n" +
            " arriveDate=\"2016-01-01T00:07:00.930+0000\"\n" +
            " categoryID=\"16\"\n" +
            " commonID=\"39401561\"\n" +
            " countryCode=\"US\"\n" +
            " feedID=\"Edgar\"\n" +
            " fileType=\"edgar\"\n" +
            " formName=\"4\"\n" +
            " formType=\"113\"\n" +
            " isRestricted=\"false\"\n" +
            " languageCode=\"en\"\n" +
            " originalFileName=\"0001209191-15-087538.dissem\"\n" +
            " periodEndDate=\"2015-12-29T00:00:00.000+0000\" releaseDate=\"2015-12-31T00:00:00.000+0000\"\n" +
            " size=\"7768\"\n" +
            " accessionNumber=\"0001209191-15-087538\">\n" +
            "            <companyInfo mxid=\"100393034\" OAPermID=\"4295905486\" CIK=\"0000004127\" Role=\"ISSUER\"/>\n" +
            "            <docType>4</docType>\n" +
            "            <IsHTMLDocumentAvailable>Y</IsHTMLDocumentAvailable>\n" +
            "            <IsPDFDocumentAvailable>R</IsPDFDocumentAvailable>\n" +
            "            <IsRTFDocumentAvailable>R</IsRTFDocumentAvailable>\n" +
            "            <companyNames>\n" +
            "                <company>\n" +
            "                    <companyName>\n" +
            "                        <![CDATA[Skyworks Solutions Inc]]>\n" +
            "                    </companyName>\n" +
            "                    <RIC>\n" +
            "                        <![CDATA[SWKS.OQ]]>\n" +
            "                    </RIC>\n" +
            "                    <IndustryPermId>4294951260</IndustryPermId>\n" +
            "                    <IndustryCode>5710101011</IndustryCode>\n" +
            "                    <IndustryName>\n" +
            "                        <![CDATA[Integrated Circuits]]>\n" +
            "                    </IndustryName>\n" +
            "                </company>\n" +
            "            </companyNames>\n" +
            "        </submissionInfo>\n" +
            "    </submissionStatusAndInfo>\n" +
            "</doclibglobalsearch_searchSubmissionsResp>";

    private static String commonIdXml = "<submissionStatusAndInfo commonID=\"39650152\"> <submissionInfo  DCN=\"sd04299453\"  arriveDate=\"2016-02-06T04:02:34.667+0000\"  categoryID=\"2\"  commonID=\"39650152\"  countryCode=\"CA\"  feedID=\"SEDAR\"  fileType=\"pdf\"  formName=\"News Releases\"  formType=\"001089\"  isRestricted=\"false\"  languageCode=\"en\"  nativePdfFlag=\"true\"  originalFileName=\"02441775-00000001-00021598-C@#Company#birdriver#pr020516-PDF.pdf\"  periodEndDate=\"2016-02-05T00:00:00.000+0000\" releaseDate=\"2016-02-05T00:00:00.000+0000\"  size=\"56303\">  <companyInfo mxid=\"100506760\" OAPermID=\"4297727699\" AsReportedName=\"Bird River Resources Inc.\"/>   <documentTitle><![CDATA[News release - English]]></documentTitle>   <formatsAvailableinRepository><![CDATA[pdf|pdf.txt|sedar]]></formatsAvailableinRepository>   <IsHTMLDocumentAvailable>N</IsHTMLDocumentAvailable>   <IsPDFDocumentAvailable>Y</IsPDFDocumentAvailable>   <IsRTFDocumentAvailable>N</IsRTFDocumentAvailable>   <IsXBRLZIPDocumentAvailable>N</IsXBRLZIPDocumentAvailable>   <IsTXTDocumentAvailable>N</IsTXTDocumentAvailable>   <IsEdgarDocumentAvailable>N</IsEdgarDocumentAvailable>  <companyNames><company> <companyName><![CDATA[Bird River Resources Inc]]></companyName>   <RIC><![CDATA[BDR.CD]]></RIC>   <IndustryPermId>4294951997</IndustryPermId>   <IndustryCode>5010202010</IndustryCode>   <IndustryName><![CDATA[Oil & Gas Exploration and Production (NEC)]]></IndustryName>  </company></companyNames></submissionInfo></submissionStatusAndInfo>";

    public static void main(String[] args) {
        String submissionInfo = "<submissionStatusAndInfo (.*?)</submissionStatusAndInfo>";
        String commonId = "commonID=\"(\\d*?)\">";
        String input = commonIdXml;
//        String input = "FOO<submissionStatusAndInfo BAR\n</submissionStatusAndInfo>BOO<submissionStatusAndInfo MAR</submissionStatusAndInfo>";
//        findMatches(submissionInfo, submissionInfoStr);
        findMatches(commonId, commonIdXml);

      /*  Pattern submissionStatusAndInfoRegExp = Pattern.compile("[<submissionStatusAndInfo (.*?)</submissionStatusAndInfo>]");
        Matcher submissionMatcher = submissionStatusAndInfoRegExp.matcher(xmlToParse);
//        String submissionStatusAndInfoRegExp = "[<submissionStatusAndInfo .+</submissionStatusAndInfo>]";
//        String[] parsed = xmlToParse.(submissionStatusAndInfoRegExp);
        ArrayList<String> parsed = new ArrayList<>();
        while (submissionMatcher.find()){
            parsed.add(submissionMatcher.group());
        }
        System.out.println(parsed);*/
    }

    private static void findMatches(String submissionInfo, String input) {
        Pattern textInFrames = Pattern.compile(submissionInfo);
        input = input.replaceAll("\n", " ");
        Matcher m = textInFrames.matcher(input);
        String s ;
        while (m.find()) {
            s = m.group(1);
            // s now contains "BAR"
            System.out.println(s);
            System.out.println("==========================================================");
        }
    }
}
