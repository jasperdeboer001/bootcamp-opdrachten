package restAssured;

import org.assertj.core.api.Assertions;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FormulaOneTest {

    private String season = "2017";
    private String race = "last";
    private String driver = "verstappen";

    @Test
    public void getLastResults() {
        given().pathParam("season", season).
                and().pathParam("race", race).
                when().get("http://ergast.com/api/f1/{season}/{race}/results.json").
                then().log().everything().
                and().statusCode(200);
    }

    @Test
    public void getVerstappenResults() {
        given().pathParam("driver", driver).
                when().get("http://ergast.com/api/f1/drivers/{driver}/results.json").
                then().log().everything().
                and().body("MRData.RaceTable.driverId", equalTo("verstappen"));
    }

    @Test
    public void pathParam() {
        given().pathParam("season",2017).
                when().get("http://ergast.com/api/f1/{season}/last/results.json").
                then().log().everything().
                and().statusCode(200);
    }
}
