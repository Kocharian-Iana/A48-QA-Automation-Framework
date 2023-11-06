import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest{
    @Test
    public void renamePlaylist() {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        provideEmail("iana.kocharian@testpro.io");
        providePassword("CwqOPgQw");
        loginButton.click();
        WebElement createNewPlaylistButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        clickToElement(createNewPlaylistButton);
        WebElement newPlaylistContextMenuButton = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickToElement(newPlaylistContextMenuButton);
        WebElement inputFieldPlaylist = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        sendKeyToElement(inputFieldPlaylist,"testPlaylist");
        actions.sendKeys(Keys.RETURN).perform();
        WebElement pleylist = driver.findElement(By.xpath("//a[contains(text(), 'testPlaylist')]"));
        actions.doubleClick(pleylist).perform();
        String newName = generateName();
//        pleylist.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END, generateName()));

        pleylist.sendKeys(newName);
        pleylist.sendKeys(Keys.ENTER);

// НЕ ВОЗМОЖНО проивзоимодействовать с pleylist ! Как отчистить строку и вставить сгенерированное значение?
    }
}