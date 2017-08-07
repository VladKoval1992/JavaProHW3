
import java.io.IOException;
import java.io.RandomAccessFile;

public class Parser {

    private String path;

    public Parser(String path) {
        this.path = path;
    }

    private String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        try(RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            String line;
            while((line = raf.readLine()) != null)
                sb.append(line).append(" &");
        }
        return sb.toString();
    }

    public void parser() throws IOException {
        String src = readFile();
        src = src.replaceAll("[{}]|[\\[\\]]|,", "");
        for(String s : src.split("&")) {
            String arr[] = s.split("\"");
            if(arr.length == 0)
                continue;
            for(String inS : arr) {
                System.out.print(inS.replaceAll("\"", "").trim() + " ");
            }
            System.out.println();
        }
    }
}