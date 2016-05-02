package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Bulletin;
import menevseoglu.okan.repository.BulletinRepository;
import menevseoglu.okan.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the bulletin operations.
 */
@Service
@Transactional
public class BulletinServiceImpl implements BulletinService {

    @Autowired
    BulletinRepository bulletinRepository;

    /**
     * @return Iterable Bulletin object
     * @should get all the bulletins
     */
    @Override
    public Iterable<Bulletin> getBulletins() {
        return bulletinRepository.findAll();
    }

    /**
     * @param id of the bulletin
     * @return Bulletin object with the given id
     * @should get the bulletin with given id
     */
    @Override
    public Bulletin getBulletin(short id) {
        return bulletinRepository.findOne(id);
    }

    /**
     * @param bulletin to be saved
     * @should save the given bulletin to the database
     */
    @Override
    public void saveBulletin(Bulletin bulletin) {
        bulletinRepository.save(bulletin);
    }

    /**
     * @param id          of the bulletin that will be updated
     * @param newBulletin to represent new values
     * @should update the bulletin with given id
     */
    @Override
    public void updateBulletin(short id, Bulletin newBulletin) {
        Bulletin oldBulletin = bulletinRepository.findOne(id);
        if (newBulletin.getName() != null)
            oldBulletin.setName(newBulletin.getName());
        if (newBulletin.getDate() != null)
            oldBulletin.setDate(newBulletin.getDate());
        if (newBulletin.getUrl() != null)
            oldBulletin.setUrl(newBulletin.getUrl());
        bulletinRepository.save(oldBulletin);
    }

    /**
     * @param id of the bulletin that will be deleted
     * @should delete the bulletin with given id
     */
    @Override
    public void deleteBulletin(short id) {
        bulletinRepository.delete(id);
    }


}
