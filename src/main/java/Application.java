import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        port(8090);
        get("/", (req, res) -> {
            System.out.println(req.queryParams("q"));
            final String question = req.queryParams("q");

            Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
            if(sumMatcher.matches()) {
                return handleTheQuestion();
            }

            return "ROFLCOPTER";
        });
    }

    private static Object handleTheQuestion() {
        throw new UnsupportedOperationException();
    }
}

