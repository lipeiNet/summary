package webmvc;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import spittr.web.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Administrator on 2016/11/11.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController homeController=new HomeController();
        MockMvc mockMvc=standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"))
        .andDo(MockMvcResultHandlers.print());
    }
}
