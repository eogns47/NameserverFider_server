package potato.nsfServer.Global.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LogUtils {
    private String getClientIpAddress(HttpServletRequest request) {
        // X-Forwarded-For 헤더를 통한 클라이언트 IP 추출
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            // X-Forwarded-For 헤더가 없을 경우, RemoteAddr 사용
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
