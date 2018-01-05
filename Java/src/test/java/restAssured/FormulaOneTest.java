package restAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FormulaOneTest {

    @Test
    public void getLastResults() {
            when().get("http://ergast.com/api/f1/current/last/results.json").
            then().statusCode(200);
    }

}
