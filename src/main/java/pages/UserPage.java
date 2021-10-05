package pages;

import components.Header;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class UserPage extends BasePage{
    Header header;
    public UserPage() {
        PageFactory.initElements(getDriver(), this);
        header = new Header(getDriver());
    }
    public String  getUserNameAsString() {
        log.info("Getting user name as string");
        return header.getUserName().getText();
    }
}
