package hello_spring.hello_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class MineController {



    @PostMapping("/run")
    public ResponseEntity<String> runCpp() {
        try {
            Process process = Runtime.getRuntime().exec("C:\\Users\\user\\source\\repos\\programing\\x64\\Debug\\programing.exe");
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));

            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            return ResponseEntity.ok(output.toString());
        } catch (IOException | InterruptedException e) {
            return ResponseEntity.status(500).body("실행 중 오류 발생: " + e.getMessage());
        }
    }
}