import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookWatchService {
	static Map<String, Integer> bookInfos = new HashMap<>();
	
	public static void main(String[] args) throws IOException, InterruptedException {
    	String watchedDir = "books";
        Path dir = Paths.get(watchedDir);

        WatchService ws = FileSystems.getDefault().newWatchService();
        dir.register(ws, ENTRY_CREATE, ENTRY_MODIFY);
        // dir.register(ws, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        while (true) {
            WatchKey key = ws.take();

            for (WatchEvent<?> event: key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path relativePath = (Path)event.context();
                addBookInfo(relativePath);
                printBookInfos();
            }

            key.reset();
        }
    }

	private static void printBookInfos() {
		System.out.println(bookInfos);
	}

	private static void addBookInfo(Path relativePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("books", relativePath.toString()));
            if (lines.size() == 0)   return;
            bookInfos.put(lines.get(0), lines.size() - 1);
        } catch (IOException e) {
            System.out.println("File doesn't exist anymore: " + relativePath.toString());
        }
	}
}
