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
     * @should invoke findAll method of bulletin repository
     * @should return what bulletin repository returns
     */
    @Override
    public Iterable<Bulletin> getBulletins() {
        return bulletinRepository.findAll();
    }

    /**
     * @param id of the bulletin
     * @return Bulletin object with the given id
     * @should invoke findOne method of bulletin repository with given id
     * @should return what bulletin repository returns
     */
    @Override
    public Bulletin getBulletin(short id) {
        return bulletinRepository.findOne(id);
    }

    /**
     * @param bulletin to be saved
     * @should invoke save method of bulletin repository
     */
    @Override
    public void saveBulletin(Bulletin bulletin) {
        bulletinRepository.save(bulletin);
    }

    /**
     * @param id          of the bulletin that will be updated
     * @param newBulletin to represent new values
     * @should invoke save method of bulletin repository with given id and new bulletin data
     * @should invoke save method of bulletin repository even if at least one data is null
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
     * @should invoke delete method of bulletin repository with given id
     */
    @Override
    public void deleteBulletin(short id) {
        bulletinRepository.delete(id);
    }
}
