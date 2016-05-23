package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.StarRating;
import menevseoglu.okan.repository.StarRatingRepository;
import menevseoglu.okan.service.StarRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the star rating operations.
 */
@Service
@Transactional
public class StarRatingServiceImpl implements StarRatingService {

    @Autowired
    StarRatingRepository starRatingRepository;

    /**
     * @return Iterable StarRating object
     * @should invoke findAll method of starRating repository
     * @should return what starRating repository returns
     */
    @Override
    public Iterable<StarRating> getStarRatings() {
        return starRatingRepository.findAll();
    }

    /**
     * @param id of the starRating
     * @return StarRating object with the given id
     * @should invoke findOne method of starRating repository with given id
     * @should return what starRating repository returns
     */
    @Override
    public StarRating getStarRating(int id) {
        return starRatingRepository.findOne(id);
    }

    /**
     * @param starRating to be saved
     * @should invoke save method of starRating repository
     */
    @Override
    public void saveStarRating(StarRating starRating) {
        starRatingRepository.save(starRating);
    }

    /**
     * @param id            of the starRating that will be updated
     * @param newStarRating to represent new values
     * @should invoke save method of starRating repository with given id and new starRating data
     * @should invoke save method of starRating repository even if starRating data is null
     */
    @Override
    public void updateStarRating(int id, StarRating newStarRating) {
        StarRating oldStarRating = starRatingRepository.findOne(id);
        if (newStarRating.getStarRate() != 0)
            oldStarRating.setStarRate(newStarRating.getStarRate());
        starRatingRepository.save(oldStarRating);
    }

    /**
     * @param id of the starRating that will be deleted
     * @should invoke delete method of starRating repository with given id
     */
    @Override
    public void deleteStarRating(int id) {
        starRatingRepository.delete(id);
    }
}
