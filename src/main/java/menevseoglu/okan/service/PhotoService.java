package menevseoglu.okan.service;

import menevseoglu.okan.model.Photo;

/**
 * This class is the abstract representation of the service layer for the photo operations.
 */
public interface PhotoService {

    Iterable<Photo> getPhotos();

    Photo getPhoto(int id);

    void savePhoto(Photo photo);

    void updatePhoto(int id, Photo newPhoto);

    void deletePhoto(int id);
}
