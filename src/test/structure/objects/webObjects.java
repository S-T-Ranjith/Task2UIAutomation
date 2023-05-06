package src.test.structure.objects;

public class webObjects {

    public static String listUser = "//a[contains(text(),'List users')]";
    public static String singleUsers = "//a[contains(text(),' Single user')]";
    public static String goodResponse = "//*[@class='response-code']";
    public static String badResponse = "//*[@class='response-code bad']";
    public static String outPutRequest = "//div/*[@data-key='output-request']";
    public static String requestURL= "//span[@class='url']";
    public static String outPutData = "//*[@data-key='output-response']";
    public static String requestJson = "//*[@data-key='output-request']";
    public static String singleUserNotFound = "//a[contains(text(),' Single user not found ')]";
    public static String createUser = "//a[contains(text(),'Create')]";
    public static String registerUser = "//a[contains(text(),'Register - successful')]";
    public static String updateUser = "//a[contains(text(),' Update')]";
}
