package datalayer;

/**
 * The FindingStatusDAO interface provides methods to access and manage finding status data in the database.
 */
public interface FindingStatusDAO {

    /**
     * Retrieves the finding status ID for a given status description.
     *
     * @param statusDescription The description of the finding status.
     * @return The finding status ID associated with the given status description.
     */
    int getFindingStatusIdForStatusDescription(String statusDescription);
}
