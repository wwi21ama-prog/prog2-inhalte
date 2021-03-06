import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Importer {
    public static Map<String, BankAccount> readBankAccounts(String filename) {
        Map<String, BankAccount> bankAccounts = new HashMap<>();

        try {
            File importFile = new File(filename);
            FileReader fileReader = new FileReader(importFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineParts = line.split(":");
                if (lineParts.length != 3) {
                    // FileFormatException
                }
                BankAccount bankAccount = new BankAccount(lineParts[0], Double.parseDouble(lineParts[1]), Integer.parseInt(lineParts[2]) == 1);
                bankAccounts.put(bankAccount.getIban(), bankAccount);
            }

            bufferedReader.close();

            System.out.printf("Die Kontoinformationen für %d Kunden wurden erfolgreich geladen.\n", bankAccounts.size());
        } catch (FileNotFoundException e) {
            System.err.printf("Die Datei %s wurde nicht gefunden.\n", filename);
        } catch (IOException e) {
            System.err.println("Beim Lesen der Datei ist ein Fehler aufgetreten.");
        }

        return bankAccounts;
    }
}
