package okhttp;

import okhttp3.*;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2021/01/08 15:24
 * @description
 */
public class WebSocketDemo1 {
    private static String applicationId;
    private static String URL = "ws://192.168.128.18:19999/common/log/";
    private static WebSocket webSocket;

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).build();
        applicationId = UUID.randomUUID().toString();
        Request request = new Request.Builder().url(URL).build();
        WebSocketListener webSocketListener = new CustomWebSocketListener();
        webSocket = client.newWebSocket(request, webSocketListener);
    }

    private static class CustomWebSocketListener extends WebSocketListener {
        public CustomWebSocketListener() {
            super();
        }

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            System.out.println("webSocket success, applicationId: " + applicationId);
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);

        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
            super.onFailure(webSocket, t, response);
        }
    }
}
