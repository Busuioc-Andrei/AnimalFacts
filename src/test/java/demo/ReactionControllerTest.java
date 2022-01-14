//package demo;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import demo.controller.ReactionController;
//import demo.models.Comment;
//import demo.models.Fact;
//import demo.models.Feedback;
//import demo.repository.CommentRepository;
//import demo.repository.FactRepository;
//import demo.repository.FeedbackRepository;
//import demo.service.Credentials;
//import demo.service.CustomException;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = ReactionController.class)
//@EnableTransactionManagement
//@ComponentScan
//public class ReactionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private FactRepository factRepository;
//    @MockBean
//    private CommentRepository commentRepository;
//    @MockBean
//    private FeedbackRepository feedbackRepository;
//
//    private static Fact fact;
//    private static Comment comment;
//    private static Feedback feedback;
//    private static LocalDateTime now = LocalDateTime.now();
//
//    @BeforeAll
//    public static void setup() {
//        fact = new Fact(1L, null, null, null, "Giant pandas spend 10-16 hours a day feeding, mainly on bamboo.", now, now);
//        comment = new Comment(1L, fact, "John", "I did not know that", now, now);
//        feedback = new Feedback(1L, fact, "John", true, now, now);
//    }
//
//    @Test
//    public void testSendComment() throws Exception {
//        String endpoint = "/reaction/comment/fact/" + fact.getId();
//        mockMvc.perform(post(endpoint)
//                    .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(comment)))
//                .andExpect(status().isNoContent());
//    }
//}
