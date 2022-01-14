//package demo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import demo.controller.RandomController;
//import demo.controller.RecommendationController;
//import demo.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@WebMvcTest(controllers = RecommendationController.class)
//@EnableTransactionManagement
//@ComponentScan
//public class RecommendationControllerTest {
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