package Regression_PK;

import DarazUniversity.*;
import DarazUniversity.DU_Login;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static DarazUniversity.DU_Wait.driver;

public class RegressionSuite_PK {

    DU_Setup DB = new DU_Setup(driver);
    DU_Teardown DTD = new DU_Teardown(driver);

    // Testing


/*
    public RegressionSuite_PK() throws IOException {
    }
 */

    @BeforeSuite
    public void DU_Setup() throws InterruptedException, IOException {
        DU_Wait.driver = DB.driver();
    }

    @AfterSuite
    public void DU_TearDown() throws InterruptedException
    {
        DU_Teardown DTD = new DU_Teardown(driver);
        DTD.browserclose(driver);
    }



    /*
        @Test (priority = 1)
    @Description ("Access Daraz University URL")
    public void DU_Portal () throws InterruptedException, IOException
    {
        String Venture = DU_Portal.Venture;

       DU_Portal DUP = new DU_Portal(driver);
       String PKURL = DUP.getcellurl1();

        DUP.Portal(driver,PKURL);

    }
     */

    @Test (priority = 1)
    @Description ("Access Daraz University URL")
    public void DU_Portal () throws InterruptedException, IOException
    {
        String Venture = DU_Portal.Venture;

       DU_Portal DUP = new DU_Portal(driver);
       DUP.Portal(driver);

    }


    /*
    Login with credentials from sheet
    @Test (priority = 2)
    @Description ("Verifying Login Functionality")
    public void DU_Login () throws InterruptedException, IOException
    {
        DU_Login DL = new DU_Login(driver);
        String UserID   = DL.getcelldata1();
        String Password = DL.getcelldata2();
        DL.Login(driver,UserID,Password);
    }
     */

    @Test (priority = 2,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Login Functionality")
    public void DU_Login () throws InterruptedException, IOException
    {
        DU_Login DL = new DU_Login(driver);
        DL.Login2(driver);
    }


    @Test (priority = 3,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Scrolling from Footer to Header")
    public void DU_HPScroll () throws InterruptedException
    {
        DU_ScrollHP DSHP = new DU_ScrollHP(driver);
        DSHP.ScrolltoContLib(driver);
    }

    @Test (priority = 4)
    @Description ("Verifying Search Functionality")
    public void DU_SearchContent () throws InterruptedException
    {
        DU_SearchContent DUSC = new DU_SearchContent(driver);
        DUSC.Search(driver);
    }

    @Test (priority = 5,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the content of Get Started Section on Home Page")
    public void DU_GetStartedSection () throws InterruptedException
    {
        DU_GetStartedSection DUGSS = new DU_GetStartedSection(driver);
        DUGSS.GetStartSec();
    }

    @Test (priority = 6,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Scrolling to Operational Performance & Standards Section on Home Page")
    public void DU_ScrollOSSSection() throws InterruptedException
    {
        DU_ScrollOSSSection DUOSS = new DU_ScrollOSSSection(driver);
        DUOSS.ScrolltoOSS(driver);
    }

    @Test (priority = 7,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Content of Operational Performance & Standards Section on Home Page")
    public void DU_OperationalStandardSection () throws InterruptedException
    {
        DU_OperationalStandardSection DUOSS = new DU_OperationalStandardSection (driver);
        DUOSS.OperationalStandardSec();
    }

    @Test (priority = 8,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Scrolling to Seller Tools Section on Home Page")
    public void DU_ScrolltoSellersTool () throws InterruptedException
    {
        DU_ScrolltoSellersTool DUSST = new DU_ScrolltoSellersTool(driver);
        DUSST.ScrolltoST(driver);
    }

    @Test(priority = 9,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the content of Seller Tools Section on Home Page")
    public void DU_SellerToolSection () throws InterruptedException
    {
        DU_SellerToolsSection DUSTS = new DU_SellerToolsSection(driver);
        DUSTS.SellerToolsSec();
    }

    @Test(priority = 10,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the content of Policies & Guidelines Section on Home Page")
    public void DU_PoliciesAndGuidelines () throws InterruptedException
    {
        DU_PoliciesAndGuidelines DUPAG = new DU_PoliciesAndGuidelines(driver);
        DUPAG.PoliciesAndGuidlinesSec(driver);
    }

    @Test (priority = 11,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the content of Need More Help Section on Home Page")
    public void DU_NeedMoreHelp () throws InterruptedException
    {
        DU_NeedMoreHelp DUNMH = new DU_NeedMoreHelp(driver);
        DUNMH.NeedMoreHelpSection(driver);
    }

    @Test (priority = 12,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Order Fulfillment Category under the Categories Module")
    public void DU_CatOrderFulfillment() throws InterruptedException
    {
        DU_CatOrderFulfillment DUCOF = new DU_CatOrderFulfillment(driver);
        DUCOF.OrderFulfill(driver);
    }


    @Test (priority = 13,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Getting Started Category under the Categories Module")
    public void DU_CatGettingStarted() throws InterruptedException
    {
        DU_CatGettingStarted DCGS = new DU_CatGettingStarted(driver);
        DCGS.GettingStarted(driver);
    }


    @Test (priority = 14,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Listing Products Category under the Categories Module")
    public void DU_CatListingProducts() throws InterruptedException
    {
        DU_CatListingProducts DCLP = new DU_CatListingProducts(driver);
        DCLP.ListingProducts(driver);
    }

    @Test (priority = 15,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Maximising Sales Category under the Categories Module")
    public void DU_CatMaximisingSales () throws InterruptedException
    {
        DU_CatMaximisingSales DCMS = new DU_CatMaximisingSales(driver);
        DCMS.MaximisingSales(driver);
    }

    @Test (priority = 16,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Finance Category under the Categories Module")
    public void DU_CatFinance() throws InterruptedException
    {
        DU_CatFinance DCF = new DU_CatFinance(driver);
        DCF.Finance(driver);
    }

    @Test (priority = 17,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Streamlining Opearations Category under the Categories Module")
    public void DU_CatStreamliningOps () throws InterruptedException
    {
        DU_CatStreamliningOps DCSL = new DU_CatStreamliningOps(driver);
        DCSL.StreamOps(driver);
    }


    @Test (priority = 18,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Policies & Guidelines Category under the Categories Module")
    public void DU_CatPoliciesAndGuidlines () throws InterruptedException
    {
        DU_CatPoliciesAndGuidlines DCPG = new DU_CatPoliciesAndGuidlines(driver);
        DCPG.PoliciesAndGuideline(driver);
    }


    @Test (priority = 19,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the View All Courses Option under the Categories Module")
    public void DU_CatViewAllCourses() throws InterruptedException
    {
        DU_CatViewAllCourses DCVAC = new DU_CatViewAllCourses(driver);
        DCVAC.ViewAllCourses(driver);
    }

    @Test (priority = 20,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Recommended Courses Section in Content Library Module")
    public void DU_CatRecommendedCourses() throws InterruptedException
    {
        DU_CatRecommendedCourses DCRC = new DU_CatRecommendedCourses(driver);
        DCRC.RecommendedCourseSec(driver);
    }

    @Test (priority = 21,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Content Library Module in the Navigation Bar")
    public void DU_ContentLibrary() throws InterruptedException
    {
        DU_ContentLibrary DCL = new DU_ContentLibrary(driver);
        DCL.ContentLib(driver);
    }

    @Test (priority = 22,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Content Library Module in the Navigation Bar")
    public void DU_EventCalendar () throws InterruptedException
    {
        DU_EventCalendar DEC = new DU_EventCalendar(driver);
        DEC.Event_Calendar(driver);
    }

    @Test (priority = 23,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Growth Assistant Module in the Navigation Bar")
    public void DU_GrowthAssistant() throws InterruptedException
    {
        DU_GA_SellersAcheivement DGA = new DU_GA_SellersAcheivement(driver);
        DGA.GrowthAssistant(driver);
    }




    @Test (priority = 24,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Daraz Live Sub Module under the Growth Assistant Module")
    public void DU_DarazLive() throws InterruptedException
    {
        String Venture = DU_Portal.Venture;
        switch (Venture)
        {
            case "PK":

            DU_GA_DarazLive DGDL = new DU_GA_DarazLive(driver);
            DGDL.Daraz_Live(driver);

            break;

            case "LK":

                System.out.println("Daraz Live Module is not available in LK Venture");

                break;

            case "BD":

                System.out.println("Daraz Live Module is not available in BD Venture");

                break;

        }
    }


    @Test (priority = 26,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Seller Support Module in the Navigation Bar")
    public void DU_SellerSupport() throws InterruptedException
    {

        DU_SellerSupport DSS = new DU_SellerSupport(driver);
        DSS.SellerSupport(driver);

    }

    @Test (priority = 27,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Policies & Guidelines Sub Module under the Seller Support Module")
    public void DU_SS_PoliciesAndGuidline() throws InterruptedException
    {
        DU_SS_PoliciesAndGuidelines DSSPAG = new DU_SS_PoliciesAndGuidelines(driver);
        DSSPAG.DU_PoliciesAndGuideline(driver);
    }

    @Test (priority = 28,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the Contact Us Sub Module under the Seller Support Module")
    public void DU_SS_ContactUS() throws InterruptedException
    {
        DU_SS_ContactUs DSSCU = new DU_SS_ContactUs(driver);
        DSSCU.DU_ContactUs(driver);
    }


    @Test (priority = 30,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying About Us Module")
    public  void DU_AboutUs () throws InterruptedException
    {
        DU_FT_AboutUs DUAU = new DU_FT_AboutUs(driver);
        DUAU.AboutUs(driver);
    }


    @Test (priority = 31,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Daraz Care Module")
    public  void DU_DarazCares () throws InterruptedException
    {
        DU_FT_DarazCares DDC = new DU_FT_DarazCares(driver);

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "PK":

                DDC.DarazCares(driver);

                break;

            case "LK":

                DDC.DarazCares(driver);

                break;

            case "NP":

                DDC.DarazCares(driver);

                break;

            case "BD":

                System.out.println("This Module is not available in BD Venture");

                break;

        }

    }


    @Test (priority = 32,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Terms & Conditions Module")
    public void DU_FT_TermsAndConditions() throws InterruptedException
    {
        DU_FT_TermsAndConditions DFTTAC = new DU_FT_TermsAndConditions(driver);
        DFTTAC.TermsAndConditions(driver);
    }

    @Test (priority = 33,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Facebook Redirection from the footer")
    public void DU_FT_Facebook() throws InterruptedException
    {
        DU_FT_Facebook DFFB = new DU_FT_Facebook(driver);
        DFFB.FT_Facebook(driver);
    }

    @Test (priority = 34,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Facebook Redirection from the footer")
    public void DU_FT_Playstore() throws InterruptedException
    {
        DU_FT_Playstore DFTP = new DU_FT_Playstore(driver);
        DFTP.FT_Playstore(driver);
    }

    @Test (priority = 35,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Appstore Redirection from the footer")
    public void DU_FT_Appstore() throws InterruptedException
    {
        DU_FT_AppStore DFTA = new DU_FT_AppStore(driver);
        DFTA.FT_Appstore(driver);
    }

    @Test (priority = 36,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Appstore Redirection from the footer")
    public void DU_FT_HelpCenter() throws InterruptedException
    {
        DU_FT_HelpCenter DFHC = new DU_FT_HelpCenter(driver);
        DFHC.FT_HelpCenter(driver);
    }

    @Test (priority = 37,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Appstore Redirection from the footer")
    public void DU_FT_DarazBlog () throws InterruptedException
    {
        DU_FT_DarazBlog DFDB = new DU_FT_DarazBlog(driver);
        DFDB.DarazBlog(driver);
    }

    @Test (priority = 38,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Sell On Daraz module from the footer")
    public void DU_FT_SellOnDaraz () throws InterruptedException
    {
        DU_FT_SellOnDaraz DFSOD = new DU_FT_SellOnDaraz(driver);
        DFSOD.SellonDaraz(driver);
    }


    @Test (priority = 39,retryAnalyzer = DU_AutoRetry.class)
    public void DU_VerifPlayButton() throws InterruptedException
    {
        DU_VerifyPlayButton DUPB = new DU_VerifyPlayButton(driver);
        DUPB.OrderFulfill(driver);
    }

/*    // not in use
    @Test (priority = 40,enabled = false)
    public void DU_OrderFulfillment() throws InterruptedException
    {
        DU_OrderFulfillment DUOF = new DU_OrderFulfillment(driver);
        DUOF.OrderFulfill(driver);
    }

 */


    @Test (priority = 41,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Course Detail Page functionality")
    public void CourseDetail_Page() throws InterruptedException
    {
        DU_CourseDetailsPage CDP = new DU_CourseDetailsPage(driver);
        CDP.CourseDetailsPage(driver);
    }


    @Test (priority = 42,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Course Detail Page functionality")
    public void CourseStatistics() throws InterruptedException
    {
        DU_CourseDetailsPage CDP = new DU_CourseDetailsPage(driver);
        CDP.CourseStatistics(driver);
    }


    @Test (priority = 43,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Course Detail Page functionality")
    public void CourseDetail_ReviewSection() throws InterruptedException
    {
        DU_CourseDetailsPage CDP = new DU_CourseDetailsPage(driver);
        CDP.CourseReviewSection(driver);
    }

    @Test (priority = 44,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Course Detail Page functionality")
    public void CourseDetailListPage() throws InterruptedException
    {
        DU_CourseDetailsListPage CDLP = new DU_CourseDetailsListPage(driver);
        CDLP.ModuleListPage(driver);
    }

    @Test (priority = 45,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying Course Detail Page functionality")
    public void ActionDetailsPage() throws InterruptedException
    {
        DU_CourseActionPage CAP = new DU_CourseActionPage(driver);
        CAP.ActionPage(driver);
    }

    @Test (priority = 46,retryAnalyzer = DU_AutoRetry.class)
    @Description ("Verifying the logout functionality")
    public void DU_Logout() throws InterruptedException
    {
        DU_Logout DULog = new DU_Logout(driver);
        DULog.Logout(driver);
    }

    //End
    //====================================================================================================================================\\
}


