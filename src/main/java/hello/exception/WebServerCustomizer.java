package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;

//@Component  // was로 전달된 예외에 대한 처리, was 가 /error-page/500 과 같은 페이지를 요청함
public class WebServerCustomizer  implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
  @Override
  public void customize(ConfigurableWebServerFactory factory) {
    ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
    ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
    ErrorPage errorPageex = new ErrorPage(RuntimeException.class, "/error-page/500"); //runtimeException자식까지 포함

    factory.addErrorPages(errorPage404,errorPageex,errorPage500);
  }
}
