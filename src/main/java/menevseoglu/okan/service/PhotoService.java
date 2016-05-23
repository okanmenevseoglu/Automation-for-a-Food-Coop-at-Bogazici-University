package menevseoglu.okan.service;

import menevseoglu.okan.model.Photo;

/**
 * This class is the abstract representation of the service layer for the photo operations.
 */
public interface PhotoService {

    Iterable<Photo> getPhotos();

    Iterable<Photo> getPhotosByMemberId(int id);

    Iterable<Photo> getPhotosByProductId(short id);

    Iterable<Photo> getPhotosByProducerId(short id);

    Iterable<Photo> getPhotosByPostId(int id);

    Photo getPhoto(int id);

    void savePhoto(Photo photo);

    void updatePhoto(int id, Photo newPhoto);

    void deletePhoto(int id);
}
