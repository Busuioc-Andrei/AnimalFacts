//package demo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import demo.controller.RandomController;
//import demo.controller.ReactionController;
//import demo.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//@WebMvcTest(controllers = RandomController.class)
//@EnableTransactionManagement
//@ComponentScan
//public class RandomControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private AnimalRepository animalRepository;
//    @Autowired
//    private CommentRepository commentRepository;
//    @Autowired
//    private FactRepository factRepository;
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//    @Autowired
//    private ImageRepository imageRepository;
//    @Autowired
//    private SuggestionRepository suggestionRepository;
//
//}