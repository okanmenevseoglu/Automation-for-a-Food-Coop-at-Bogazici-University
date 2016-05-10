package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PostType;
import menevseoglu.okan.repository.PostTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the post type service operations.
 */
public class PostTypeServiceImplTest {

    @Mock
    PostTypeRepository postTypeRepository;

    @Mock
    private ArrayList<PostType> postTypeList;

    @Mock
    private PostType postType;

    @InjectMocks
    PostTypeServiceImpl postTypeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of post type repository
     * @see PostTypeServiceImpl#getPostTypes()
     */
    @Test
    public void getPostTypes_shouldInvokeFindAllMethodOfPostTypeRepository() throws Exception {
        postTypeService.getPostTypes();
        verify(postTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what post type repository returns
     * @see PostTypeServiceImpl#getPostTypes()
     */
    @Test
    public void getPostTypes_shouldReturnWhatPostTypeRepositoryReturns() throws Exception {
        when(postTypeRepository.findAll()).thenReturn(postTypeList);
        assertEquals(postTypeService.getPostTypes(), postTypeList);
    }

    /**
     * @verifies invoke findOne method of post type repository with given id
     * @see PostTypeServiceImpl#getPostType(short)
     */
    @Test
    public void getPostType_shouldInvokeFindOneMethodOfPostTypeRepositoryWithGivenId() throws Exception {
        postTypeService.getPostType(anyShort());
        verify(postTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what post type repository returns
     * @see PostTypeServiceImpl#getPostType(short)
     */
    @Test
    public void getPostType_shouldReturnWhatPostTypeRepositoryReturns() throws Exception {
        when(postTypeRepository.findOne(anyShort())).thenReturn(postType);
        assertEquals(postTypeService.getPostType((short) 1), postType);
    }

    /**
     * @verifies invoke save method of post type repository
     * @see PostTypeServiceImpl#savePostType(menevseoglu.okan.model.PostType)
     */
    @Test
    public void savePostType_shouldInvokeSaveMethodOfPostTypeRepository() throws Exception {
        postTypeService.savePostType(postType);
        verify(postTypeRepository, times(1)).save(postType);
    }

    /**
     * @verifies invoke delete method of post type repository with given id
     * @see PostTypeServiceImpl#deletePostType(short)
     */
    @Test
    public void deletePostType_shouldInvokeDeleteMethodOfPostTypeRepositoryWithGivenId() throws Exception {
        postTypeService.deletePostType(anyShort());
        verify(postTypeRepository, times(1)).delete(anyShort());
    }
}
