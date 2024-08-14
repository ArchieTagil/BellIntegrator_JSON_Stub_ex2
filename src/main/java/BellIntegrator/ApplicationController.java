package BellIntegrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApplicationController {
    private Logger log = LoggerFactory.getLogger(Application.class);
    private Map<String, Integer> counter = new HashMap<>();

    private Map<String, SomeAbstractUser[]> someMap = new HashMap<>();

    @GetMapping("/test")
    public Map<String, SomeAbstractUser[]> get1() {
        SomeAbstractUser users[] = new SomeAbstractUser[100];
        for (int i = 0; i < 100; i++) {
            users[i] = new SomeAbstractUser(i);
        }
        someMap.put("data", users);
        return someMap;
    }

    @PostMapping("/test")
    public Map<String, SomeAbstractUser[]> post1(@RequestBody Map<String, Integer> countObj) {
        if (countObj.size() == 1) {
            int count = countObj.entrySet().stream().findFirst().get().getValue();
            SomeAbstractUser[] users = new SomeAbstractUser[count];
            for (int i = 0; i < count; i++) {
                users[i] = new SomeAbstractUser(i);
            }
            someMap.put("data", users);
            return someMap;
        } else {
            throw new CustomException("Invalid body of JSON");
        }
    }

    @GetMapping("test/teapot")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String get2() {
        return "{\"response\": \"I'm a teapot -_@\"}";
    }
}
