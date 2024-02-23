package potato.nsfServer.HealthChecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HealthCheckApi {
    @Value("${server.env}")
    private final String env;

    @GetMapping("/getServerInfo")
    public ResponseEntity<Map<String, String>> getServerInfo() {
        Map<String, String> serverInfo = new HashMap<>();
        serverInfo.put("env:", env);
        return ResponseEntity.ok(serverInfo);
    }

    //profile 조회
    @GetMapping("/env")
    public String getEnv() {
        return env;
    }
}
