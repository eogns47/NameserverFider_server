package potato.nsfServer.HealthChecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckApi {
    @Autowired
    private Environment environment;

    @GetMapping("/getServerInfo")
    public ResponseEntity<Map<String, String>> getServerInfo() {
        String env = environment.getProperty("server.env");
        Map<String, String> serverInfo = new HashMap<>();
        serverInfo.put("env:", env);
        return ResponseEntity.ok(serverInfo);
    }
    String env;
    //profile 조회
    @GetMapping("/env")
    public String getEnv() {
        env = environment.getProperty("server.env");
        return env;
    }
}
