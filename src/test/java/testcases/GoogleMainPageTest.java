package testcases;

import basepage.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GoogleSearchResult;
import util.TestUtility;

public class GoogleMainPageTest extends BasePage {

    GoogleMainPage googlesearch;
    GoogleSearchResult googleresult;

    String sheetname = "data";

    public GoogleMainPageTest ()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        System.out.println("starting test");
    }

    //data used to start driven
    @DataProvider
    public Object [][] getdata()
    {
        Object data [][] = TestUtility.gettestdata("data");
        return data;
    }

    //test page title to validate if it's right with the expected
    @Test(priority = 1, dataProvider = "getdata")
    public void GooglePageTitle (String URL, String Browser,String Word)
    {
        browserinitialization(URL,Browser);
        googlesearch = new GoogleMainPage();
        String actualtitle = googlesearch.ValidatePageTitle();
        Assert.assertEquals(actualtitle,"Google");

    }

    //test the logo by boolean assertion
    @Test(priority = 2, dataProvider = "getdata")
    public void GoogleLogo (String URL, String Browser,String Word)
    {
        browserinitialization(URL,Browser);
        googlesearch = new GoogleMainPage();
        boolean logo = googlesearch.validategooglepage();
        Assert.assertTrue(logo);
    }


    //send a word and search with it in google
    @Test(priority = 3, dataProvider = "getdata")
    public void Searchingoogletest (String URL, String Browser, String Word)
    {
        browserinitialization(URL,Browser);
        googlesearch = new GoogleMainPage();
        googleresult = googlesearch.SearchinGoogle(Word);

    }

    @AfterMethod
    public void teardown ()
    {
        driver.quit();
    }

}
