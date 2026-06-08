package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.exe"; // Hãy để một file bất kỳ dung lượng lớn vào đây
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();
        
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Mỗi lần + là tạo ra 1 Object mới -> Rác (Garbage)
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
