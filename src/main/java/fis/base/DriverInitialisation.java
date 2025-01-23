package fis.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInitialisation {
    private static DriverInitialisation instance;
    private static ThreadLocal<WebDriver> threaddriver = new ThreadLocal<>();

    private DriverInitialisation(){

    }

    private void startDriver(String browser){
        if(browser.equals("chrome")){
            threaddriver.set(new ChromeDriver());
        }else{
            throw new IllegalArgumentException("Browser not supported");
        }

    }

    public WebDriver fetchDriver(){
        return threaddriver.get();
    }

    public static DriverInitialisation getInstance(String browser){
        if(instance == null){
            synchronized (DriverInitialisation.class){
                if(instance == null){
                    instance = new DriverInitialisation();
                }
            }
        }
        if(threaddriver.get() == null){
            instance.startDriver(browser);
        }
        return instance;
    }
}
