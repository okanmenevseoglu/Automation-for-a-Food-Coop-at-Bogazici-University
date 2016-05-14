package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Photo;
import menevseoglu.okan.repository.PhotoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the photo service operations.
 */
public class PhotoServiceImplTest {

    @Mock
    PhotoRepository photoRepository;

    @Mock
    private ArrayList<Photo> photoList;

    @Mock
    private Photo photo;

    @InjectMocks
    PhotoServiceImpl photoService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of photo repository
     * @see PhotoServiceImpl#getPhotos()
     */
    @Test
    public void getPhotos_shouldInvokeFindAllMethodOfPhotoRepository() throws Exception {
        photoService.getPhotos();
        verify(photoRepository, times(1)).findAll();
    }

    /**
     * @verifies return what photo repository returns
     * @see PhotoServiceImpl#getPhotos()
     */
    @Test
    public void getPhotos_shouldReturnWhatPhotoRepositoryReturns() throws Exception {
        when(photoRepository.findAll()).thenReturn(photoList);
        assertEquals(photoService.getPhotos(), photoList);
    }

    /**
     * @verifies invoke findOne method of photo repository with given id
     * @see PhotoServiceImpl#getPhoto
     */
    @Test
    public void getPhoto_shouldInvokeFindOneMethodOfPhotoRepositoryWithGivenId() throws Exception {
        photoService.getPhoto(anyInt());
        verify(photoRepository, times(1)).findOne(anyInt());
    }

    /**
     * @verifies return what photo repository returns
     * @see PhotoServiceImpl#getPhoto
     */
    @Test
    public void getPhoto_shouldReturnWhatPhotoRepositoryReturns() throws Exception {
        when(photoRepository.findOne(anyInt())).thenReturn(photo);
        assertEquals(photoService.getPhoto(1), photo);
    }

    /**
     * @verifies invoke save method of photo repository
     * @see PhotoServiceImpl#savePhoto(menevseoglu.okan.model.Photo)
     */
    @Test
    public void savePhoto_shouldInvokeSaveMethodOfPhotoRepository() throws Exception {
        photoService.savePhoto(photo);
        verify(photoRepository, times(1)).save(photo);
    }

    /**
     * @verifies invoke save method of photo repository with given id and new photo data
     * @see PhotoServiceImpl#updatePhoto(int, menevseoglu.okan.model.Photo)
     */
    @Test
    public void updatePhoto_shouldInvokeSaveMethodOfPhotoRepositoryWithGivenIdAndNewPhotoData() throws Exception {
        photoService.updatePhoto(anyInt(), photo);
        verify(photoRepository, times(1)).findOne(anyInt());
        verify(photoRepository, times(1)).save(photoRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke save method of photo repository even if at least one data is null
     * @see PhotoServiceImpl#updatePhoto(int, menevseoglu.okan.model.Photo)
     */
    @Test
    public void updatePhoto_shouldInvokeSaveMethodOfPhotoRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        photo.setPhotoURL(null);
        photoService.updatePhoto(anyInt(), photo);
        verify(photoRepository, times(1)).findOne(anyInt());
        verify(photoRepository, times(1)).save(photoRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke delete method of photo repository with given id
     * @see PhotoServiceImpl#deletePhoto
     */
    @Test
    public void deletePhoto_shouldInvokeDeleteMethodOfPhotoRepositoryWithGivenId() throws Exception {
        photoService.deletePhoto(anyInt());
        verify(photoRepository, times(1)).delete(anyInt());
    }
}
