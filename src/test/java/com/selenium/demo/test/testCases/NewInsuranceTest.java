package com.selenium.demo.test.testCases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.selenium.demo.page.*;
import com.selenium.demo.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;


public class NewInsuranceTest extends TestBase {
    private static final Logger logger = Logger.getLogger(NewInsuranceTest.class.getName());

    @Test(dataProvider = "loginData")
    public void verifyValidUserLogin(String email, String password) {
        logger.info("Starting verifyValidUserLogin test...");
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals(basePage.getBrowserTabTitle(), "Insurance Manager");
        loginPage.login(email, password);
        Assert.assertEquals(basePage.getBrowserTabTitle(), "Insurance Manager");
        logger.info("verifyValidUserLogin test completed successfully.");
    }

    @Test(dataProvider = "loginData")
    public void createNewInsurance(String email, String password) throws InterruptedException {
        verifyValidUserLogin(email, password);
        logger.info("Starting createNewInsurance test...");
        Random random = new Random();
        int randomSerialNumber = random.nextInt(10000);

        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        UserDetailPage userDetailPage = new UserDetailPage(driver);
        confirmationPage confirmationPage = new confirmationPage(driver);
        //Thread.sleep(3000);
        homePage.clickOnNewBtn();
        Thread.sleep(2000);
        productDetailPage.selectFromCustomDropdownCountry(5);
        productDetailPage.selectFromCustomDropdownProduct(1);
        productDetailPage.selectFromCustomDropdownRates(1);
        productDetailPage.selectFromCustomDropdownCategory(1);
        productDetailPage.selectFromCustomDropdownDuration(1);
        productDetailPage.selectFromCustomDropdownPayment(1);
        productDetailPage.selectFromCustomDropdownPayment(1);
        productDetailPage.selectFromCustomDropdownClass(1);
        productDetailPage.setSerialNoEntry(Integer.toString(randomSerialNumber));
        productDetailPage.setDeviceEntry("Nokia");
        productDetailPage.setInvoiceEntry(Integer.toString(randomSerialNumber));
        productDetailPage.setFurtherClick();

        userDetailPage.setFirstName("User First");
        userDetailPage.setLastName("User Last");
        userDetailPage.setEmail("email@abc.com");
        userDetailPage.setStreetName("Flankens");
        userDetailPage.setStreetNumber("345");
        userDetailPage.setZipcode("13434");
        userDetailPage.setCity("Berlin");
        userDetailPage.setCountry("DE");
        productDetailPage.setFurtherClick();
        //Thread.sleep(2000);
        confirmationPage.clickAllMessages();
        //Thread.sleep(3000);
        logger.info("createNewInsurance test completed successfully.");
    }

    @Test(dataProvider = "loginData")
    public void createNewInsuranceBatch(String email, String password) throws InterruptedException {
        verifyValidUserLogin(email, password);
        logger.info("Starting createNewInsuranceBatch test...");

        HomePage homePage = new HomePage(driver);
        ImportPage importPage = new ImportPage(driver);

        Thread.sleep(2000);
        homePage.clickOnImportBtn();
        importPage.selectCSVFile("C:\\Users\\Poorn\\OneDrive\\Desktop\\SimpleSurance\\selenium-testng-page-factory-csv-data-driven\\src\\test\\resources\\testdata.csv");
//        Thread.sleep(1000);
        importPage.clickCreateInsuranceButton();
        Thread.sleep(2000);
        importPage.isImportErrorDisplayed();
        importPage.isDataVerificationDisplayed();
        logger.info("createNewInsuranceBatch test completed successfully.");
    }

    @Test(dataProvider = "loginData")
    public void verifyFilterSort(String email, String password) throws InterruptedException {
        verifyValidUserLogin(email, password);
        logger.info("Starting verifyFilterSort test...");

        HomePage homePage = new HomePage(driver);
        ImportPage importPage = new ImportPage(driver);

        //Thread.sleep(2000);
        homePage.setPolicyNumberSortElementClick();
        homePage.sampleEmailDisplayedElementDisplayed();
        homePage.setPolicyNumberSortElementClick();
        homePage.setEmailDisplayedElement();
        homePage.setLabelElementClick();
        homePage.setEmailOptionElementClick();
        homePage.setInputElement("email");
        homePage.setEmailDisplayedElement();
        logger.info("verifyFilterSort test completed successfully.");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException, CsvValidationException {
        String csvFilePath = "./src/test/resources/users.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        String[] csvCell;
        int rowCount = 0;
        while ((csvCell = csvReader.readNext()) != null) {
            rowCount++;
        }
        csvReader.close();

        Object[][] data = new Object[rowCount][2];
        csvReader = new CSVReader(new FileReader(csvFilePath));
        for (int i = 0; i < rowCount; i++) {
            csvCell = csvReader.readNext();
            data[i][0] = csvCell[0]; // Email
            data[i][1] = csvCell[1]; // Password
        }
        return data;
    }

}
