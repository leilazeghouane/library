package src;

public interface Searchable {
    /**
     * Checks if the object matches the given query.
     * @param query The search query.
     * @return true if the object matches the query, false otherwise.
     */
    boolean matches(String query);
}
