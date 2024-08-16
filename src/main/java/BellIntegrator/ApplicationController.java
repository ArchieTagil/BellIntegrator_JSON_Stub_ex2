package BellIntegrator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {
    private final KafkaProducerService producerService;

    public ApplicationController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("post-message")
    public void postMessage(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Integer> posted_body) {
        long unixTime = System.currentTimeMillis();
        int value = posted_body.get("msg_id");
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String strToReturn = "{" +
                "\"msg_id\":" + value + "," +
                "\"timestamp\":" + unixTime + "," +
                "\"method\":" + "\"" + method + "\"," +
                "\"uri\":" + "\"" + uri + "\"" +
                "}";
        if (producerService.sendMessage(strToReturn)) {
            response.setStatus(200);
        } else {
            response.setStatus(500);
        }
    }
}
