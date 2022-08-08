package testcases;

import basepage.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleMainPage;
import pages.GooglePageTwo;
import pages.GoogleSearchResult;
import util.TestUtility;

public class GoogleSearchResultTest extends BasePage {

    GoogleMainPage googlesearch;
    GoogleSearchResult result;
    GooglePageTwo pagetwo;

    public GoogleSearchResultTest ()
    {
        super();
    }

    @BeforeMethod
    public void setup()
    {
        System.out.println("starting test");
    }


    @DataProvider
    public Object [][] getdata()
    {
        Object data [][] = TestUtility.gettestdata("data");
        return data;
    }

    @Test(dataProvider = "getdata")
    public void scrollandnextpage (String URL, String Browser,String Word)
    {
        browserinitialization(URL,Browser);
        googlesearch = new GoogleMainPage();
        result = googlesearch.SearchinGoogle(Word);
        result.scrolldown();
        pagetwo = result.clickonnext();

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
