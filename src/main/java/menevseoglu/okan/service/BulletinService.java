package menevseoglu.okan.service;

import menevseoglu.okan.model.Bulletin;

/**
 * This class is the abstract representation of the service layer for the bulletin operations.
 */
public interface BulletinService {

    Iterable<Bulletin> getBulletins();

    Bulletin getBulletin(short id);

    void saveBulletin(Bulletin bulletin);

    void updateBulletin(short id, Bulletin newBulletin);

    void deleteBulletin(short id);
}
