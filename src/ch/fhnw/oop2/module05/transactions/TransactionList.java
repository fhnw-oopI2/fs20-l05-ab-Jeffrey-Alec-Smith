package ch.fhnw.oop2.module05.transactions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * This class implements a list of transactions performed by the traders over time.
 *
 */
public final class TransactionList {

    private final List<Transaction> allTransactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        allTransactions.add(transaction);
    }

    public int size() {
        return allTransactions.size();
    }

    // TODO: AB02
    /**
     * Returns the transactions done in the year specified. The transactions are sorted by value
     * (small to high).
     * 
     * @param year The year
     * @return All transactions made in this year
     */
    public List<Transaction> transactionsInYear(int year) {
        return allTransactions.stream()
                                .filter(n -> n.getYear() == year)
                                .sorted((n1, n2)->{return n1.getValue() - n2.getValue();})
                                .collect(toList());
    }

    // TODO: AB03
    /**
     * Returns all the cities in which traders work.
     * 
     * @return The cities
     */
    public List<String> cities() {
        return allTransactions.stream()
                                .map(n->n.getTrader().getCity())
                                .distinct()
                                .collect(toList());
    }

    // TODO: AB04
    /**
     * Returns all traders from a given city sorted by name.
     * 
     * @param city The trader's city
     * @return All traders from given city sorted by name
     */
    public List<Trader> traders(String city) {
        return allTransactions.stream()
                                .map(n->n.getTrader())
                                .filter(n->city.equalsIgnoreCase(n.getCity()))
                                .sorted((n1, n2)->n1.getName().compareTo(n2.getName()))
                                .collect(toList());
    }

    // TODO: AB05
    /**
     * True if there are traders in the city, false otherwise.
     * 
     * @param city The city
     * @return True if there are any trader based in given city
     */
    public boolean traderInCity(String city) {
        return allTransactions.stream()
                                .anyMatch(n -> city.equalsIgnoreCase(n.getTrader().getCity()));
    }

    // TODO: AB06
    /**
     * Moves all traders from their city to the city specified.
     * 
     * @param from the trader's current city
     * @param to the trader's new city
     */
    public void relocateTraders(String from, String to) {
        allTransactions.stream()
                        .map(n->n.getTrader())
                        .filter(n->from.equalsIgnoreCase(n.getCity()))
                        .forEach(n->n.setCity(to));
    }

    // TODO: AB07
    /**
     * Returns the highest value of all transactions.
     * 
     * @return the highest value in all the transactions
     */
    public int highestValue() {
        return allTransactions.stream()
                                .map(n->n.getValue())
                                .max(Integer::compareTo)
                                .get();
    }
}
