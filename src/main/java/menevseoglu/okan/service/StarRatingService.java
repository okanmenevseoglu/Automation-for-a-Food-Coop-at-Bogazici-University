package menevseoglu.okan.service;

import menevseoglu.okan.model.StarRating;

/**
 * This class is the abstract representation of the service layer for the star rating operations.
 */
public interface StarRatingService {

    Iterable<StarRating> getStarRatings();

    StarRating getStarRating(int id);

    void saveStarRating(StarRating starRating);

    void updateStarRating(int id, StarRating newStarRating);

    void deleteStarRating(int id);
}
