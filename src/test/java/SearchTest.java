import com.opencart.navigation.Navigation;
import com.opencart.steps.MainPageBL;
import com.opencart.steps.SearchResultPageBL;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class SearchTest extends BaseTest {

    @Test
    public void SearchWithValidParameters() {
        new Navigation().navigateToUrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        SearchResultPageBL searchResultPageBL = mainPageBL.getHeaderPageBL()
                .searchProduct("mac");
        searchResultPageBL.verifySearchResult("mac");
    }
}