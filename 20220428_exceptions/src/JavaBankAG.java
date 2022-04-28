import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaBankAG {

    public static final String FILENAME = "accountdetails.txt";

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, BankAccount> bankAccounts;

    public static void main(String[] args) {
        printGreeting();
        bankAccounts = Importer.readBankAccounts(JavaBankAG.class.getResource(FILENAME).getFile());
        String userInput;
        while (true) {
            userInput = printMenuAndAskForAction();
            try {
                switch (userInput) {
                    case "1":
                        getBankAccountForIban("Geben Sie die IBAN des Kontos ein:").printDetails();
                        break;
                    case "2":
                        BankAccount depositBankAccount = getBankAccountForIban("Geben Sie die IBAN des Kontos ein, für das Sie die Einzahlung vornehmen möchten:");
                        double amountToDeposit = askForDouble("Welcher Betrag soll eingezahlt werden (Format: _.__)?");
                        depositBankAccount.deposit(amountToDeposit);
                        System.out.printf("Der Betrag in Höhe von %.2f € wurde dem Konto mit der IBAN %s gutgeschrieben.\n", amountToDeposit, depositBankAccount.getIban());
                        break;
                    case "3":
                        BankAccount debitBankAccount = getBankAccountForIban("Geben Sie die IBAN des Kontos ein, für das Sie die Auszahlung vornehmen möchten:");
                        double amountToDebit = askForDouble("Welcher Betrag soll abgebucht werden (Format: _.__)?");
                        if (debitBankAccount.debit(amountToDebit)) {
                            System.out.printf("Der Betrag in Höhe von %.2f € wurde vom Konto mit der IBAN %s abgebucht.\n", amountToDebit, debitBankAccount.getIban());
                        } else {
                            System.err.printf("Der Betrag in Höhe von %.2f € konnte nicht vom Konto mit der IBAN %s abgebucht werden, da die Deckung nicht ausreicht und keine Überziehung erlaubt ist.\n",
                                    amountToDebit, debitBankAccount.getIban());
                        }
                        break;
                    case "4":
                        BankAccount selectedBankAccount = getBankAccountForIban("Geben Sie die IBAN des Kontos ein, für das Sie die Kontoüberziehungseinstellungen anpassen möchten.");
                        System.out.printf("Das Konto mit der IBAN %s erlaubt%sÜberziehung.", selectedBankAccount.getIban(), selectedBankAccount.allowsOverdraft() ? "" : " keine ");
                        String newOptionValue = askForString("Soll eine Überziehung für das Konto erlaubt werden (ja/nein)?");
                        selectedBankAccount.setOverdraft(newOptionValue.equals("ja"));
                        break;
                    case "e":
                        printFarewell();
                        System.exit(0);
                    default:
                        System.err.println("Die Eingabe wurde nicht erkannt, bitte versuchen Sie es nocheinmal.");
                }
            } catch (Exception e) {
                System.err.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            }
        }
    }

    private static void printGreeting() {
        System.out.println("-----------------------------");
        System.out.println("--- Bank Account Software ---");
        System.out.println("-----------------------------");
        System.out.println("Guten Tag Benutzer!");
        System.out.println("Lade Kontoinformationen...");
    }

    private static String printMenuAndAskForAction() {
        System.out.println(">>> Hauptmenü <<<");
        System.out.println("Sie haben folgende Möglichkeiten:");
        System.out.println("(1) Kontoinformationen für einen Kunden anzeigen");
        System.out.println("(2) Einzahlung durchführen");
        System.out.println("(3) Abbuchung durchführen");
        System.out.println("(4) Kontoüberziehungseinstellungen");
        System.out.println("(e) Beenden");
        System.out.println("Geben Sie die Nummer der gewünschten Aktion ein:");
        return scanner.nextLine();
    }

    private static void printFarewell() {
        System.out.println("Die Anwendung wird beendet");
        System.out.println("Bis zum nächsten Mal!");
        System.out.println("-----------------------------");
        System.out.println("--- Bank Account Software ---");
        System.out.println("-----------------------------");
    }

    private static String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static double askForDouble(String message) throws NumberFormatException {
        System.out.println(message);
        // Workaround aufgrund fehlendes Newline bei .nextDouble(), siehe https://stackoverflow.com/a/13102066
        String doubleAsString = scanner.nextLine();
        return Double.parseDouble(doubleAsString);
    }

    private static BankAccount getBankAccountForIban(String message) throws NullPointerException {
        String iban = askForString(message);
        return bankAccounts.get(iban);
    }
}
