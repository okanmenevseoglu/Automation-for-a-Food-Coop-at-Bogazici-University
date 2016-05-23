package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Photo;
import menevseoglu.okan.repository.PhotoRepository;
import menevseoglu.okan.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the photo operations.
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    /**
     * @return Iterable Photo object
     * @should invoke findAll method of photo repository
     * @should return what photo repository returns
     */
    @Override
    public Iterable<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    @Override
    public Iterable<Photo> getPhotosByMemberId(int id) {
        return photoRepository.findAllByMemberId(id);
    }

    @Override
    public Iterable<Photo> getPhotosByProductId(short id) {
        return photoRepository.findAllByProductId(id);
    }

    @Override
    public Iterable<Photo> getPhotosByProducerId(short id) {
        return photoRepository.findAllByProducerId(id);
    }

    @Override
    public Iterable<Photo> getPhotosByPostId(int id) {
        return photoRepository.findAllByPostId(id);
    }

    /**
     * @param id of the photo
     * @return Photo object with the given id
     * @should invoke findOne method of photo repository with given id
     * @should return what photo repository returns
     */
    @Override
    public Photo getPhoto(int id) {
        return photoRepository.findOne(id);
    }

    /**
     * @param photo to be saved
     * @should invoke save method of photo repository
     */
    @Override
    public void savePhoto(Photo photo) {
        photoRepository.save(photo);
    }

    /**
     * @param id       of the photo that will be updated
     * @param newPhoto to represent new values
     * @should invoke save method of photo repository with given id and new photo data
     * @should invoke save method of photo repository even if at least one data is null
     */
    @Override
    public void updatePhoto(int id, Photo newPhoto) {
        Photo oldPhoto = photoRepository.findOne(id);
        if (newPhoto.getPhotoURL() != null)
            oldPhoto.setPhotoURL(newPhoto.getPhotoURL());
        photoRepository.save(oldPhoto);
    }

    /**
     * @param id of the photo that will be deleted
     * @should invoke delete method of photo repository with given id
     */
    @Override
    public void deletePhoto(int id) {
        photoRepository.delete(id);
    }
}
