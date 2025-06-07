package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.payment.OrderVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// 외부 주문 api 호출 유틸리티
public class OrderAPIClient {
    public static String createOrder(OrderVO vo) throws IOException {
        // 외부 api 주소
        String apiUrl = "http://125.180.87.49:8821/cground/order";

        // 연결 설정
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/json");
        conn.setDoOutput(true); // POST body 사용 가능

        // [1] Jackson 을 이용해서 객체 -> json 문자열 변환
        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(vo);

        System.out.println("jsonBody: " + jsonBody);

        // [2] 전송
        try (OutputStream os = conn.getOutputStream()){
            os.write(jsonBody.getBytes());
            os.flush();
        }

        System.out.printf("Response Code : %d\n", conn.getResponseCode());
        System.out.printf("Response Message : %s\n", conn.getResponseMessage());

        // [3] 응답 처리
        if(conn.getResponseCode() == 200 ){
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            )){
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line);
                }

                // 응답값 그대로 반환
                return sb.toString();
            }
        } else {
            throw new RuntimeException("API 오류" + conn.getResponseCode());
        }
    }
}
