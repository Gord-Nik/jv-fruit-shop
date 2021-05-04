package core.basesyntax.operationswithfile;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

public class FileWriterImpl implements FileWriter {
    @Override
    public void getNewFile(HashMap<String, Integer> balance, String newCsvFileName) {
        StringWriter output = new StringWriter();
        try (ICsvListWriter listWriter = new CsvListWriter(output,
                CsvPreference.STANDARD_PREFERENCE)) {
            for (Map.Entry<String, Integer> entry : balance.entrySet()) {
                listWriter.write(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            java.io.FileWriter file1 = new java.io.FileWriter(newCsvFileName);
            file1.write("fruit,quantity" + System.lineSeparator());
            file1.write(output.toString());
            file1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}