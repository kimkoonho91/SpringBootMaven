package util;

import java.io.File;

public class FileUtil {
    // 폴더의 파일 목록 가져오기
    public void getFileList() {
        File file = new File("D:\\배경화면");
        
        int count = 0;
        
        for (File data : file.listFiles()) {
            count++;
            
            System.out.print("\"" + data.getName() + "\", ");
            
            if (count == 10) {
                count = 0;
                System.out.println();
            }
        }
    }
}
