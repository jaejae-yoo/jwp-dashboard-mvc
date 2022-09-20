package com.techcourse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualHandlerAdapterTest {

    private final TestController testController = new TestController();
    private final ManualHandlerAdapter manualHandlerAdapter = new ManualHandlerAdapter();

    @DisplayName("ManualHandlerAdapter가 Controller를 지원하는지 확인한다.")
    @Test
    void ManualHandlerAdapterSupportsController() {
        assertThat(manualHandlerAdapter.supports(testController)).isTrue();
    }

    @DisplayName("ManualHandlerAdapter가 Controller를 실행한다.")
    @Test
    void handlerAdapterExecutesHandler() throws Exception {
        //given
        var request = mock(HttpServletRequest.class);
        var response = mock(HttpServletResponse.class);

        when(request.getAttribute("id")).thenReturn("gugu");
        when(request.getRequestURI()).thenReturn("/hello");
        when(request.getMethod()).thenReturn("GET");

        //when & then
        assertThat(manualHandlerAdapter.handle(request, response, testController))
                .isInstanceOf(ModelAndView.class);
        assertThat(manualHandlerAdapter.handle(request, response, testController)
                .getView()).isInstanceOf(JspView.class);
    }
}
