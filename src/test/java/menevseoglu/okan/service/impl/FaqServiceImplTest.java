package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.repository.FaqRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the faq service operations.
 */
public class FaqServiceImplTest {

    @Mock
    FaqRepository faqRepository;

    @Mock
    private ArrayList<Faq> faqList;

    @Mock
    private Faq faq;

    @InjectMocks
    FaqServiceImpl faqService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of faq repository
     * @see FaqServiceImpl#getFaqs()
     */
    @Test
    public void getFaqs_shouldInvokeFindAllMethodOfFaqRepository() throws Exception {
        faqService.getFaqs();
        verify(faqRepository, times(1)).findAll();
    }

    /**
     * @verifies return what faq repository returns
     * @see FaqServiceImpl#getFaqs()
     */
    @Test
    public void getFaqs_shouldReturnWhatFaqRepositoryReturns() throws Exception {
        when(faqRepository.findAll()).thenReturn(faqList);
        assertEquals(faqService.getFaqs(), faqList);
    }

    /**
     * @verifies invoke findOne method of faq repository with given id
     * @see FaqServiceImpl#getFaq(short)
     */
    @Test
    public void getFaq_shouldInvokeFindOneMethodOfFaqRepositoryWithGivenId() throws Exception {
        faqService.getFaq(anyShort());
        verify(faqRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what faq repository returns
     * @see FaqServiceImpl#getFaq(short)
     */
    @Test
    public void getFaq_shouldReturnWhatFaqRepositoryReturns() throws Exception {
        when(faqRepository.findOne(anyShort())).thenReturn(faq);
        assertEquals(faqService.getFaq((short) 1), faq);
    }

    /**
     * @verifies invoke save method of faq repository
     * @see FaqServiceImpl#saveFaq(menevseoglu.okan.model.Faq)
     */
    @Test
    public void saveFaq_shouldInvokeSaveMethodOfFaqRepository() throws Exception {
        faqService.saveFaq(faq);
        verify(faqRepository, times(1)).save(faq);
    }

    /**
     * @verifies invoke save method of faq repository with given id and new faq data
     * @see FaqServiceImpl#updateFaq(short, menevseoglu.okan.model.Faq)
     */
    @Test
    public void updateFaq_shouldInvokeSaveMethodOfFaqRepositoryWithGivenIdAndNewFaqData() throws Exception {
        faqService.updateFaq(anyShort(), faq);
        verify(faqRepository, times(1)).findOne(anyShort());
        verify(faqRepository, times(1)).save(faqRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of faq repository even if at least one data is null
     * @see FaqServiceImpl#updateFaq(short, menevseoglu.okan.model.Faq)
     */
    @Test
    public void updateFaq_shouldInvokeSaveMethodOfFaqRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        faq.setQuestion(null);
        faqService.updateFaq(anyShort(), faq);
        faq.setAnswer(null);
        faqService.updateFaq(anyShort(), faq);
        verify(faqRepository, times(2)).findOne(anyShort());
        verify(faqRepository, times(2)).save(faqRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke delete method of faq repository with given id
     * @see FaqServiceImpl#deleteFaq(short)
     */
    @Test
    public void deleteFaq_shouldInvokeDeleteMethodOfFaqRepositoryWithGivenId() throws Exception {
        faqService.deleteFaq(anyShort());
        verify(faqRepository, times(1)).delete(anyShort());
    }
}
